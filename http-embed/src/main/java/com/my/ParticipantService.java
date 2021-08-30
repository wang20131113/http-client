package com.my;

import com.my.model.ServiceData;

public interface ParticipantService {

	void forwardProcess(ServiceData serviceData);

	void backProcess();

}
