package com.citrix.analyzerservice.dbconnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.citrix.analyzerservice.model.ChannelStats;

public interface IDbConnector {
	
//	List<String> findAllConfIds(String path);
//	List<String> findProConfIds(String path);
	List<String> findNewConfIds();
	
	List<LocalDbConference> findConferenceList();
	
	LocalDbConference findConference(String confId, boolean showAll);
	
	List<LocalDbChannel> findConfChannels(String confId);
	
	LocalDbChannel findChannel(String confId, String chanId, boolean showAll);
	ChannelStats findChannelStats(String confId, String chanId);
	
	boolean writeFile(String[] content);
}
