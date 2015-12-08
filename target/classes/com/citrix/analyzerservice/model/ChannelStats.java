package com.citrix.analyzerservice.model;

import java.time.LocalDateTime;

public class ChannelStats {

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private StreamProcessor strProcessor;
	private StreamEnhancer strEnhancer;
	
	public ChannelStats(LocalDateTime startTime, LocalDateTime endTime, StreamProcessor strProcessor, StreamEnhancer strEnhancer) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.strProcessor = strProcessor;
		this.strEnhancer = strEnhancer;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public StreamProcessor getStrProcessor() {
		return strProcessor;
	}

	public StreamEnhancer getStrEnhancer() {
		return strEnhancer;
	}
	
	
}
