package com.citrix.analyzerservice.dbconnector;

import java.util.Collection;

import com.citrix.analyzerservice.model.ChannelScore;
import com.citrix.analyzerservice.model.ConferenceScore;
import com.citrix.analyzerservice.model.ConferenceStats;

public class LocalDbConference {

	private String uuid;
	private ConferenceStats stats;
	private ConferenceScore score;
	private Collection<LocalDbChannel> channels;
	
	public LocalDbConference(String uuid, ConferenceStats stats, ConferenceScore score,
			Collection<LocalDbChannel> channels) {
		this.uuid = uuid;
		this.stats = stats;
		this.score = score;
		this.channels = channels;
	}	

	public LocalDbConference(String uuid, ConferenceStats stats, Collection<LocalDbChannel> channels) {
		this(uuid, stats, null, channels);
	}

	private String getUuid() {
		return uuid;
	}

	private ConferenceStats getStats() {
		return stats;
	}

	private ConferenceScore getScore() {
		return score;
	}

	private Collection<LocalDbChannel> getChannels() {
		return channels;
	}
	
	private void setScore(ConferenceScore score) {
		this.score = score;
	}
	
}
