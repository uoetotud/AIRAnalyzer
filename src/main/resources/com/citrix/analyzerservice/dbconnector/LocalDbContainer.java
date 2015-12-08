package com.citrix.analyzerservice.dbconnector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ChannelStats;
import com.citrix.analyzerservice.model.ConferenceStats;
import com.citrix.analyzerservice.model.Mixer;
import com.citrix.analyzerservice.model.StreamProcessor;

public class LocalDbContainer implements IDbConnector {

	private transient String defaultPath = "C:/Users/xil/Desktop/AIR recording example";
	private LocalDbConference conference;
	private LocalDbChannel channel;
	
	public LocalDbContainer(LocalDbConference conference, LocalDbChannel channel) {
		this.conference = conference;
		this.channel = channel;
	}
	
	public LocalDbContainer() {}
	
	@Override
	public List<String> findNewConfIds(String path) {
		List<String> newConfIds = new ArrayList<String>();
		
		List<String> allConfIds = findAllConfIds(path);
		List<String> proConfIds = findProConfIds(path + "/ConfList.txt");
		
		if (allConfIds.size() == proConfIds.size())
			return newConfIds;
		
		for (String s : allConfIds)
			if (!proConfIds.contains(s))
				newConfIds.add(s);
		
		return newConfIds;
	}
	
	@Override
	public LocalDbConference findConference(String confId) {
		List<String> folder = getFileNameFromId(defaultPath, confId);
		if (folder.isEmpty() && folder.size() <= 0)
			return null;
		
		String path = defaultPath + "/" + folder.get(0);
		File confFolder = new File(path);
		
		// Get conference statistics
		LocalDateTime dateTime = convertStringToDate(folder.get(0));
		
		int channelNo = getChannelNo(path);
		
		Map<String, double[]> mixData = convertDataStructure(readFile(path+"/MixerSumStream-test.txt", ","));
		Mixer mix = new Mixer(mixData.get("quantum"), mixData.get("nConferenceId"), mixData.get("nSpeakers"));
		
		ConferenceStats stats = new ConferenceStats(dateTime, null, null, channelNo, mix);
		
		// Get conference score
		
		LocalDbConference conference = null;
//		LocalDbConference conference = new LocalDbConference(confId, stats, score, channels);
		
		return conference;
	}
	
	@Override
	public LocalDbChannel findChannel(String confId, String chanId) {
		List<String> folder = getFileNameFromId(defaultPath, confId);
		if (folder.isEmpty() && folder.size() <= 0)
			return null;
		
		List<String> files = new ArrayList<String>();
		Map<String, double[]> strProData = null;		
		
		String path = defaultPath + "/" + folder.get(0);
		
		files.addAll(getFileNameFromId(path, chanId));
		
		// Get channel statistics
		for (int i=0; i<files.size(); i++)
			strProData = convertDataStructure(readFile(path+"/"+files.get(i), ","));
		
		StreamProcessor sp = new StreamProcessor(strProData.get("SeqNr"), strProData.get("NS_speechPowerOut"), strProData.get("NS_noisePowerOut"));
		ChannelStats stats = new ChannelStats(null, null, sp, null);
		
		// Get channel score
		ChannelScore score = null;
		
		List<List<String>> chans = readFile(defaultPath+"/ChanList.txt", ",");
		for (List<String> chan : chans)
			if (chan.get(1).equals(chanId))
				score = new ChannelScore(Integer.parseInt(chan.get(3)), Integer.parseInt(chan.get(4)), Double.parseDouble(chan.get(5)));	
		
		LocalDbChannel channel = new LocalDbChannel(chanId, stats, score);	
		
		return channel;
	}

	@Override
	public List<List<String>> readFile(String path, String delimiter) {
		BufferedReader br = null;
		String line = "";
		List<List<String>> data = new ArrayList<List<String>>();		
		
		try {
			br = new BufferedReader(new FileReader(path));
			
			while ((line = br.readLine()) != null) {
				ArrayList<String> dataLine = new ArrayList<String>();
				String[] splitData = line.split("\\s*"+delimiter+"\\s*");
				for (int i=0; i<splitData.length; i++)
					if (!(splitData[i] == null) || !(splitData[i].length() == 0))
						dataLine.add(splitData[i].trim());
				data.add(dataLine);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return data;
		
	}
	
	@Override
	public boolean writeFile(String path, String[] content) {
		
		try {
			File file = new File(path);
			
			if (!file.exists())
				file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
			for (int i=0; i<content.length; i++) {
				bw.write(content[i]);
				bw.newLine();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private List<String> findAllConfIds(String path) {
		List<String> confs = getFolderNames(path);
		List<String> confIds = new ArrayList<String>();
		
		for (int i=0; i<confs.size(); i++) {
			String confName = confs.get(i);
			confIds.add(confName.substring(confName.indexOf('_')+1));
		}
		
		return confIds;
	}
	
	private List<String> findProConfIds(String path) {
		List<String> confIds = new ArrayList<String>();
		
		BufferedReader br = null;
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
				int index = line.indexOf(',');
				confIds.add(line.substring(0, index));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return confIds;
	}
	
	private List<String> getFolderNames(String path) {
		List<String> folders = new ArrayList<String>();
		File folder = new File(path);
		File[] fileLists = folder.listFiles();
		
		if (fileLists.length <= 0)
			return new ArrayList<String>();
		
		for (int i=0; i<fileLists.length; i++)
			if (fileLists[i].isDirectory())
				folders.add(fileLists[i].getName());
		
		return folders;
	}
	
	private List<String> getFileNames(String path) {
		List<String> folders = new ArrayList<String>();
		File folder = new File(path);
		File[] fileLists = folder.listFiles();
		
		if (fileLists.length <= 0)
			return new ArrayList<String>();
		
		for (int i=0; i<fileLists.length; i++)
			if (fileLists[i].isFile() && fileLists[i].getName().endsWith(".txt"))
				folders.add(fileLists[i].getName());
		
		return folders;
	}
	
	private List<String> getFileNameFromId(String path, String uuid) {
		List<String> files = new ArrayList<String>();
		File folder = new File(path);
		File[] fileLists = folder.listFiles();
		
		if (fileLists.length <= 0)
			return new ArrayList<String>();
		
		for (int i=0; i<fileLists.length; i++)
			if (fileLists[i].getName().contains(uuid))
				files.add(fileLists[i].getName());
		
		return files;
	}
	
	private Map<String, double[]> convertDataStructure(List<List<String>> data) {
		Map<String, double[]> convertedData = new LinkedHashMap<String, double[]>();
		int dataRowNo = data.size();
		int dataColNo = data.get(0).size();
		int i = 0;
		
		double[][] dataMatrix = new double[dataColNo][dataRowNo-1];
		
		for (i=1; i<dataRowNo; i++) {
			for (int j=0; j<dataColNo; j++) {
				dataMatrix[j][i-1] = Double.parseDouble(data.get(i).get(j));
			}
		}
		
		for (i=0; i<data.get(0).size(); i++) {
			convertedData.put(data.get(0).get(i).substring(1, data.get(0).get(i).length()-1), dataMatrix[i]);			
		}
		
		return convertedData;
	}
	
	private int getChannelNo(String path) {
		int count = 0;
		
		File folder = new File(path);
		File[] fileLists = folder.listFiles();
		
		if (fileLists.length <= 0)
			return 0;
		
		for (int i=0; i<fileLists.length; i++)
			if (fileLists[i].isFile() && fileLists[i].getName().startsWith("MixerInChannel"))
				count++;
		
		return count;
	}
	
	private LocalDateTime convertStringToDate(String s) {
		String dateTimeStr = "20" + s.substring(0, 13);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
		
		return dateTime;
	}
}
