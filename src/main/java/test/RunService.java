package test;

import javax.xml.ws.Endpoint;


public class RunService {
	public static void main(String[] args) {
		//url: @IP et du n port
		String url= "http://localhost:5555/";
		//publier le WS Point d'acc�s au WebService
		Endpoint.publish(url, new service.ContactService());
		System.out.println("D�marrage du serveur....");
		
	}
	
}
