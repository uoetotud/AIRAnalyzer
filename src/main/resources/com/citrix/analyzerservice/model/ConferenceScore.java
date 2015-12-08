package com.citrix.analyzerservice.model;

public class ConferenceScore {

	private int avgPLIndicator;
	private int avgLevelIndicator;
	
	public ConferenceScore(int avgPLIndicator, int avgLevelIndicator) {
		super();
		this.avgPLIndicator = avgPLIndicator;
		this.avgLevelIndicator = avgLevelIndicator;
	}

	private int getAvgPLIndicator() {
		return avgPLIndicator;
	}

	private int getAvgLevelIndicator() {
		return avgLevelIndicator;
	}
	
}
