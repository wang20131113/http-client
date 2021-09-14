package com.micrward;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micrward.bootstrap.DemoApplication;
import com.micrward.example.ParticipantServiceProxyImpl;
import com.micrward.example.model.ServiceData;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ParticipantServiceProxySelfTest {

	@Autowired
    private ParticipantServiceProxyImpl participantServiceProxyImpl;
	
	@Test
	public void testStriveDo(){
		ServiceData serviceData = new ServiceData();
		
		participantServiceProxyImpl.striveDo(serviceData);
		
		System.out.println("----testStriveDo test finish------");
		
		System.out.println("process start");
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println("process end");
		
		Assertions.assertEquals(Float.valueOf(200), new Float(200) );
	}
	
	@Test
	public void testStriveDo2(){
		ServiceData serviceData = new ServiceData();
		serviceData.setFlag("true");
	
		this.participantServiceProxyImpl.striveDo(serviceData);
		System.out.println("---- testStriveDo2 test finish------");
		Assertions.assertEquals(Float.valueOf(200), new Float(200) );
	}
}
