package com.sindhe.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sindhe.model.Website;

@Path("/records")
public class RESTEasyHelloWorldService {
	// http://zetcode.com/jaxrs/resteasycrud/
	// https://www.9lessons.info/2012/09/restful-web-services-api-using-java-and.html
	ServiceImpl ser;

	@GET
	@Path("getById/{ById}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Website> getRecordById(@PathParam("ById") int id) {
		return new ServiceImpl().getRecordsById(id);
	}

	@GET
	@Path("getAll/Records")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Website> getAllRecords() {
		return new ServiceImpl().getAllRecords();
	}

/*	@DELETE
	@Path("/{Id}")
	public String deletReodrdById(@PathParam("Id") Long Id) {

		return null;

	}*/

	@DELETE
	@Path("/{id}")
	public List<Website> deleteById(@PathParam("id") Long id) {
		return new ServiceImpl().deleteById(id);
	}

}