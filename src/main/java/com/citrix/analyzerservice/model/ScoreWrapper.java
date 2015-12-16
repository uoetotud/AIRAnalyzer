package com.citrix.analyzerservice.model;

import java.util.Collection;

public class ScoreWrapper {

	private ConferenceScore confScore;
	private Collection<ChannelScore> chanScoreList;
	
	public ScoreWrapper(ConferenceScore confScore, Collection<ChannelScore> chanScoreList) {
		this.confScore = confScore;
		this.chanScoreList = chanScoreList;
	}

	public ConferenceScore getConfScore() {
		return confScore;
	}

	public Collection<ChannelScore> getChanScoreList() {
		return chanScoreList;
	}	
	
}
