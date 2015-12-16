import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.citrix.analyzerservice.dbconnector.DbConnectorFactory;
import com.citrix.analyzerservice.dbconnector.IDbConnector;
import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbConference;
import com.citrix.analyzerservice.dbconnector.LocalDbContainer;
import com.citrix.analyzerservice.dtprocessor.DtProcessor;
import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ConferenceScore;
import com.citrix.analyzerservice.util.Config;

public class MainTest {
	
	final int interval = 5000; // set time interval in millisecond

//	public static void main(String[] args) {
//
//		LocalDbContainer ldc = new LocalDbContainer();
//		DtProcessor dp = new DtProcessor();
//		
//		List<String> newConfIds = dp.getNewConfIds();
//		
//		if (newConfIds != null || !newConfIds.isEmpty()) {
//			
//			List<ConferenceScore> confScores = new ArrayList<ConferenceScore>();
//			ConferenceScore confScore = new ConferenceScore(0, 0);
//			
//			for (String confId : newConfIds) {
//				
//				List<LocalDbChannel> channels = ldc.findConfChannels(confId);
//				List<ChannelScore> chanScores = new ArrayList<ChannelScore>();
//				
//				for (LocalDbChannel channel : channels) {					
//					ChannelScore chanScore = dp.calChannelScore(confId, channel.getUuid());
//					chanScores.add(chanScore);
//				}
//				
////				System.out.println(chanScores.size());
//				dp.updateChanList(confId, chanScores);
//				
//				confScore = dp.calConferenceScore(confId, chanScores);
//				confScores.add(confScore);
//			}		
//			
//			dp.updateConfList(newConfIds, confScores);
//		}
//		
//	}
	
	static void testConfigProperties() {
		Config config = new Config();
		Map<String, String> configs = config.getPropValues();
		for (String key : configs.keySet())
			System.out.println(key + " :: " + configs.get(key));
	}
	
}
