package com.micrward.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micrward.ParticipantService;
import com.micrward.ParticipantServiceProxy;

@Service
public class ParticipantServiceProxyImpl extends ParticipantServiceProxy<ParticipantService> {

	public ParticipantServiceProxyImpl(@Autowired ParticipantService participantService) {
		super(participantService);
	}

}
