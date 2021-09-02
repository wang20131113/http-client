package com.my.serviceImpl;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.my.ParticipantService;
import com.my.model.ServiceData;

@Service
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

	public void backProcess(Object serviceData) {
		System.out.println(Calendar.getInstance().getTime() + " : backProcess method run.");
	}
}
