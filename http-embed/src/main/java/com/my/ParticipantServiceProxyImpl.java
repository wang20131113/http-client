package com.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceProxyImpl extends ParticipantServiceProxy<ParticipantService> {

	public ParticipantServiceProxyImpl(@Autowired ParticipantService participantService) {
		super(participantService);
	}

}
