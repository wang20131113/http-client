package com.my.serviceImpl;

import java.util.Calendar;

import com.my.ParticipantService;
import com.my.model.ServiceData;

public class ParticipantServiceImpl implements ParticipantService {

	public void forwardProcess(Object paramServiceData) {
		assert paramServiceData instanceof ServiceData;
		ServiceData serviceData = (ServiceData)paramServiceData;
		System.out.println(Calendar.getInstance().getTime() + " : forwardProcess method run.");
		if("true".equals(serviceData.getFlag())){
			System.out.println(Calendar.getInstance().getTime() + " : forwardProcess method run complete.");
		}else{
			throw new RuntimeException("test fail.");
		}
	}

	public void backProcess() {
		System.out.println(Calendar.getInstance().getTime() + " : backProcess method run.");
	}
}
