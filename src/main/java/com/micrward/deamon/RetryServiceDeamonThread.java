package com.micrward.deamon;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micrward.example.ParticipantServiceProxyImpl;
import com.micrward.example.model.ServiceData;

@Component()
public class RetryServiceDeamonThread implements DisposableBean, Runnable {

	@Autowired
    private ParticipantServiceProxyImpl participantServiceProxyImpl;
	
    private Thread thread;
    private volatile boolean someCondition = true;

    public RetryServiceDeamonThread(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        while(someCondition){
            doStuff();
        }
    }

    private void doStuff() {
		System.out.println("--- doStuff run..");
		
		ServiceData serviceData = new ServiceData();
		
		participantServiceProxyImpl.striveDo(serviceData);
		
		System.out.println("----testStriveDo test finish-------");
		
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
    public void destroy(){
        someCondition = false;
    }

}