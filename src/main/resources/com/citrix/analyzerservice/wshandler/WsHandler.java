package com.citrix.analyzerservice.wshandler;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbConference;
import com.citrix.analyzerservice.dbconnector.LocalDbContainer;
import com.citrix.analyzerservice.dbconnector.TestStructure;
import com.citrix.analyzerservice.dtcollector.DtCollector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Path("/QueryAPI")
public class WsHandler {

	@GET
	@Path("/greeting")
	@Produces(MediaType.APPLICATION_JSON)
	public String greeting(@QueryParam("name") String name) {
		
		TestStructure resp = new TestStructure(name, 28, "Citrix");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();		
		
		return gson.toJson(resp);
//		return resp;
	}
	
	@GET
	@Path("/Conferences")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConferenceList() {
		List<LocalDbConference> conferenceList = DtCollector.getConferenceList();
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
//		    @Override
//		    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//		        Instant instant = Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong());
//		        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//		    }
//		}).create();
		
		return gson.toJson(conferenceList);
	}
	
	@GET
	@Path("/Conferences/{confId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConferenceSummary(@PathParam("confId") String confId) {
		LocalDbConference container = DtCollector.getConferenceSummary(confId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(container);
	}
	
	@GET
	@Path("/Conferences/{confId}/Details")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConferenceDetails(@PathParam("confId") String confId) {
		LocalDbConference container = DtCollector.getConferenceDetails(confId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(container);
	}
	
	@GET
	@Path("/Conferences/{confId}/Channels")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfChannels(@PathParam("confId") String confId) {
		List<LocalDbChannel> channels = DtCollector.getConfChannels(confId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(channels);
	}
	
	@GET
	@Path("/Channels/{chanId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChannelSummary(@PathParam("chanId") String chanId) {
		LocalDbChannel channel = DtCollector.getChannelSummary("00000000-0000-0000-0000000000000000", chanId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(channel);
	}
	
	@GET
	@Path("/Channels/{chanId}/Details")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChannelDetails(@PathParam("chanId") String chanId) {
		LocalDbChannel channel = DtCollector.getChannelDetails("00000000-0000-0000-0000000000000000", chanId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(channel);
	}
}
