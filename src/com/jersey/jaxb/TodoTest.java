package com.jersey.jaxb;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class TodoTest {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());
		// Get XML
		String xmlResponse = target.path("rest").path("todo").request().accept(MediaType.TEXT_XML).get(String.class);
		// Get XML for application
		String xmlAppResponse = target.path("rest").path("todo").request().accept(MediaType.APPLICATION_XML)
				.get(String.class);

		// Get JSON for application
		String jsonResponse = target.path("rest").path("todo").request().accept(MediaType.APPLICATION_JSON)
				.get(String.class);

		System.out.println(xmlResponse);
		System.out.println(xmlAppResponse);
		System.out.println(jsonResponse);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/webServiceRESTJersey").build();
	}

}
