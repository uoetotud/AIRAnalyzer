package com.citrix.analyzerservice.dtcollector;

import com.citrix.analyzerservice.dbconnector.DbConnectorFactory;
import com.citrix.analyzerservice.dbconnector.IDbConnector;
import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbContainer;

public class DtCollector {
	
	public static LocalDbContainer getChannel(String confId, String chanId) {
		DbConnectorFactory dcf = new DbConnectorFactory();
		IDbConnector ldc = dcf.getDbContainer("LOCAL");
		
		LocalDbChannel channel = ldc.findChannel(confId, chanId);
		
		LocalDbContainer result = new LocalDbContainer(null, channel);
		
		return result;
	}

}
