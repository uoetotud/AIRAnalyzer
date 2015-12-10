package com.citrix.analyzerservice.dtcollector;

import java.util.List;

import com.citrix.analyzerservice.dbconnector.DbConnectorFactory;
import com.citrix.analyzerservice.dbconnector.IDbConnector;
import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbConference;
import com.citrix.analyzerservice.dbconnector.LocalDbContainer;

public class DtCollector {
	
	public static List<LocalDbConference> getConferenceList() {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		List<LocalDbConference> conferenceList = ldc.findConferenceList();
		
		return conferenceList;
	}
	
	public static LocalDbConference getConferenceSummary(String confId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		LocalDbConference conference = ldc.findConference(confId, false);
		
		return conference;
	}
	
	public static LocalDbConference getConferenceDetails(String confId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		LocalDbConference conference = ldc.findConference(confId, true);
		
		return conference;
	}
	
	public static List<LocalDbChannel> getConfChannels(String confId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		List<LocalDbChannel> channelList = ldc.findConfChannels(confId);
		
		return channelList;
	}
	
	public static LocalDbChannel getChannelSummary(String confId, String chanId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		LocalDbChannel channel = ldc.findChannel(confId, chanId, false);
		
		return channel;
	}
	
	public static LocalDbChannel getChannelDetails(String confId, String chanId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		LocalDbChannel channel = ldc.findChannel(confId, chanId, true);
		
		return channel;
	}

}
