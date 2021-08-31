package com.my;

import com.my.model.ServiceData;
import com.my.serviceImpl.ParticipantServiceImpl;

public class ParticipantServiceProxyTest {

	public void test(Object serviceData){
		ParticipantServiceProxy<ParticipantServiceImpl> participantServiceProxy = new ParticipantServiceProxy<>(new ParticipantServiceImpl());
		participantServiceProxy.striveDo(serviceData);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//new ParticipantServiceProxyTest().test(new ServiceData());
		
		Thread.sleep(5000);
		System.out.println("-----------------second time ---------------");
		ServiceData serviceData = new ServiceData();
		serviceData.setFlag("true");
		new ParticipantServiceProxyTest().test(serviceData);
		
		
	}
}
