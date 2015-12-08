package com.citrix.analyzerservice.model;

public class Mixer {

	private double[] quantum;
	private double[] nConferenceId;
	private double[] nSpeakers;
	
	public Mixer(double[] quantum, double[] nConferenceId, double[] nSpeakers) {
		this.quantum = quantum;
		this.nConferenceId = nConferenceId;
		this.nSpeakers = nSpeakers;
	}

	private double[] getQuantum() {
		return quantum;
	}

	private double[] getnConferenceId() {
		return nConferenceId;
	}

	private double[] getnSpeakers() {
		return nSpeakers;
	}

	
	
}
