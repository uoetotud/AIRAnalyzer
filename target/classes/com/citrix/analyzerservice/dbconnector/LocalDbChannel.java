package com.citrix.analyzerservice.dbconnector;

import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ChannelStats;

public class LocalDbChannel {

	private String uuid;
	private ChannelStats stats;
	private ChannelScore score;
	
	public LocalDbChannel(String uuid, ChannelStats stats, ChannelScore score) {
		this.uuid = uuid;
		this.stats = stats;
		this.score = score;
	}

	public String getUuid() {
		return uuid;
	}

	public ChannelStats getStats() {
		return stats;
	}

	public ChannelScore getScore() {
		return score;
	}
	
	public void setScore(ChannelScore score) {
		this.score = score;
	}
	
}
