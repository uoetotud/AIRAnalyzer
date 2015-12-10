import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.citrix.analyzerservice.dbconnector.DbConnectorFactory;
import com.citrix.analyzerservice.dbconnector.IDbConnector;
import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbConference;
import com.citrix.analyzerservice.dtprocessor.DtProcessor;

public class Main {

	public static void main(String[] args) {

//		DbContainer dc = new DbContainer();
//		dc.getNewConfIds();
		
		Processor p = new Processor();
		p.calChannelScore();
		p.calConferenceScore();
	}
	
}
