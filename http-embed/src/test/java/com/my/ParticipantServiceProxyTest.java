package com.my;

import com.my.model.ServiceData;

public class ParticipantServiceProxyTest {

	public void test(ServiceData serviceData){
		ParticipantServiceProxy participantServiceProxy = new ParticipantServiceProxy();
		participantServiceProxy.striveDo(serviceData);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		new ParticipantServiceProxyTest().test(new ServiceData());
		
		//Thread.sleep(5000);
		System.out.println("-----------------second time ---------------");
		/*ServiceData serviceData = new ServiceData();
		serviceData.setFlag("true");
		new ParticipantServiceProxyTest().test(serviceData);*/
		
		
	}
}
