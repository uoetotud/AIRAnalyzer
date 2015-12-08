package com.citrix.analyzerservice.dbconnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IDbConnector {
	
//	List<String> findAllConfIds(String path);
//	List<String> findProConfIds(String path);
	List<String> findNewConfIds(String path);
	
	LocalDbConference findConference(String confId);
	
	LocalDbChannel findChannel(String confId, String chanId);

	List<List<String>> readFile(String path, String delimiter);
	
	boolean writeFile(String path, String[] content);
}
