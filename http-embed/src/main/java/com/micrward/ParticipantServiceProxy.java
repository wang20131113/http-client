package com.micrward;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.micrward.assist.CountGenerator;

/**
 * @author davy wang
 *
 */
public class ParticipantServiceProxy<T extends ParticipantService> {

	@Autowired
	private ScheduledExecutorService scheduledExecutorService;
	
	@Autowired
	private CountGenerator countGenerator;
	/**
	 * 具体的服务类
	 */
	private T participantService;

	public ParticipantServiceProxy(T participantService){
		this.participantService = participantService;
	}
	/**
	 * 代理执行
	 * @param 分布服务的数据
	 */
	public void striveDo(Object serviceData) {
		this.striveDo(serviceData, 1);
	}
	
	public ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}
	public void setScheduledExecutorService(
			ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}
	public CountGenerator getCountGenerator() {
		return countGenerator;
	}
	public void setCountGenerator(CountGenerator countGenerator) {
		this.countGenerator = countGenerator;
	}
	void striveDo(Object serviceData,int count ){
		
		long byCount = 0;
		try{
			byCount = this.countGenerator.getByCount(count);
			System.out.println("count: "+ count +" byCount: " + byCount);
		}catch(Throwable t){
			t.printStackTrace();
			scheduledExecutorService.shutdown();
		}
		scheduledExecutorService.schedule(new SubRunnable((ParticipantServiceProxy<T>)this,serviceData,count), byCount, TimeUnit.MILLISECONDS);
	}
	
	class SubRunnable  extends ParticipantServiceProxy<T>  implements Runnable{
		private Object serviceData;
		private int count;

		public SubRunnable(T service, Object serviceData, int count){
			super(service);
			this.serviceData = serviceData;
			this.count = count;
		}
		
		public SubRunnable(ParticipantServiceProxy<T> proxy, Object serviceData, int count){
			super(proxy.participantService);
			super.setCountGenerator(proxy.getCountGenerator());
			super.setScheduledExecutorService(proxy.getScheduledExecutorService());
			this.serviceData = serviceData;
			this.count = count;
		}
		
		public void run() {
			try{
				super.participantService.forwardProcess(serviceData);
			}catch(RuntimeException connectTimeoutException){
				participantService.backProcess(serviceData);
				try{
					super.striveDo(serviceData, count+1);
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		}
	}
}
