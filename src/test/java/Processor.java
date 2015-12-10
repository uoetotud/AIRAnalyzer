import com.citrix.analyzerservice.dtprocessor.DtProcessor;
import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ChannelStats;
import com.citrix.analyzerservice.model.ConferenceScore;

public class Processor {

	DtProcessor dp = new DtProcessor();
	
	public void calChannelScore() {
//		ChannelScore score = dp.calChannelScore("00000000-0000-0000-0000000000000000", "C42E0EA0-E3D3-453E-ABCDEFG123456789");
		ChannelScore score = dp.calChannelScore("00000000-0000-0000-0000000000000000", "C05C1C75-8DDF-4906-9C9CC69277926064");
		
		System.out.println("Channel 0:");
		System.out.println(score.getAvgPLIndicator());
		System.out.println(score.getAvgLevelIndicator());
		System.out.println(score.getAvgPacketLoss());
		System.out.println();
		
		score = dp.calChannelScore("00000000-0000-0000-0000000000000000", "C42E0EA0-E3D3-453E-A6A6458B611B89D6");
		
		System.out.println("Channel 1:");
		System.out.println(score.getAvgPLIndicator());
		System.out.println(score.getAvgLevelIndicator());
		System.out.println(score.getAvgPacketLoss());
		System.out.println();
		
		score = dp.calChannelScore("00000000-0000-0000-0000000000000000", "B620092E-1B06-4A4D-829811D6003FB46A");
		
		System.out.println("Channel 2:");
		System.out.println(score.getAvgPLIndicator());
		System.out.println(score.getAvgLevelIndicator());
		System.out.println(score.getAvgPacketLoss());
		System.out.println();
	}
	
	public void calConferenceScore() {
		ConferenceScore score = dp.calConferenceScore("00000000-0000-0000-0000000000000000");
		
		System.out.println("Conference:");
		System.out.println(score.getAvgPLIndicator());
		System.out.println(score.getAvgLevelIndicator());
	}
}
 