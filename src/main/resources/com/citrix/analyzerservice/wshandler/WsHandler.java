package com.citrix.analyzerservice.wshandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.citrix.analyzerservice.dbconnector.LocalDbChannel;
import com.citrix.analyzerservice.dbconnector.LocalDbContainer;
import com.citrix.analyzerservice.dbconnector.TestStructure;
import com.citrix.analyzerservice.dtcollector.DtCollector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	@Path("/Channels/{chanId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChannel(@PathParam("chanId") String chanId) {
		LocalDbContainer channel = DtCollector.getChannel("00000000-0000-0000-0000000000000000", chanId);
				
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(channel);
	}
}
