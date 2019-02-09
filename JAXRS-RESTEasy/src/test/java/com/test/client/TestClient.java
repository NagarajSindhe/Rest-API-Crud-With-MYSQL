package com.test.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class TestClient {
	
	@Test
	public void TestClient() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		  HttpGet request = new HttpGet("http://localhost:8086/JAXRS-RESTEasy/rest/records/1");
		  HttpResponse response = client.execute(request);
		  int i=response.getStatusLine().getStatusCode();
		  System.out.println(i);
		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		  String line = "";
		  while ((line = rd.readLine()) != null) {
		    System.out.println(line);
		  }
	}

}
