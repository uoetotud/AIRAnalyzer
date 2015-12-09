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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public int getChannelNo() {
		return channelNo;
	}

	public Mixer getMixer() {
		return mixer;
	}
	
	

}
