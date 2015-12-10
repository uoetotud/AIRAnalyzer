package com.citrix.analyzerservice.dtprocessor;

import java.util.List;

import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ConferenceScore;

public interface IDtProcessor {

	List<String> getNewConfIds();
	
	void calculateScore(List<String> confIds);
	
	boolean updateList();
	
}
