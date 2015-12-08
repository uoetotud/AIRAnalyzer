package com.citrix.analyzerservice.model;

import java.time.LocalDateTime;

public class ConferenceStats {
	
	private LocalDateTime timestamp;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int channelNo;
	private Mixer mixer;
	
	public ConferenceStats(LocalDateTime timestamp, LocalDateTime startTime, LocalDateTime endTime, int channelNo, Mixer mixer) {
		super();
		this.timestamp = timestamp;
		this.startTime = startTime;
		this.endTime = endTime;
		this.channelNo = channelNo;
		this.mixer = mixer;
	}

	private LocalDateTime getTimestamp() {
		return timestamp;
	}

	private LocalDateTime getStartTime() {
		return startTime;
	}

	private LocalDateTime getEndTime() {
		return endTime;
	}

	private int getChannelNo() {
		return channelNo;
	}

	private Mixer getMixer() {
		return mixer;
	}
	
	

}
