package com.my;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.assist.CountGenerator;

/**
 * 暂时使用类实现，待后续采用接口。
 * @author davy wang
 *
 */
public class ParticipantServiceProxy<T extends ParticipantService> {

	//TODO
	private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	
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
	
	
	void striveDo(Object serviceData,int count ) {
		
		try{
			//TODO 约束一下这种类型的服务（网络远程访问类型，特点是：时间长，不保证成功）
			participantService.forwardProcess(serviceData);
			if( 1 < count ){
				scheduledExecutorService.shutdown();
			}
		}catch(RuntimeException connectTimeoutException){
			participantService.backProcess();
			
			//TODO 把生产间隔时间的类抽象成接口
			int nextCount = count+1;
			long byCount = 0;
			try{
				byCount = this.countGenerator.getByCount(nextCount);
			}catch(Throwable t){
				scheduledExecutorService.shutdown();
			}
			if(!scheduledExecutorService.isShutdown()){
				scheduledExecutorService.schedule(new SubRunnable(participantService,serviceData,nextCount), byCount, TimeUnit.MILLISECONDS);
			}
			Thread.currentThread().interrupt();
			
		}finally{
		}
	}
	
	class SubRunnable  extends ParticipantServiceProxy<T>  implements Runnable{

		private Object serviceData;
		private int count;
		
		public SubRunnable(T service, Object serviceData, int count){
			super(service);
			this.serviceData = serviceData;
			this.count = count;
		}
		
		public void run() {
			super.striveDo(serviceData, count);
			
		}
		
	}
}
