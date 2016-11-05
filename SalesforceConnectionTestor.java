package com.webservice.service.salesforce;

import org.junit.Test;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.transport.SalesforceHttpTransport;

public class SalesforceConnectionTestor {
	
	EnterpriseConnection connection;
	
	@Test
	public void testConnection(){
		String username = "<UserName>";
		String password = "<PASSWORD><SECURITY_TOKEN>";
		String authEndPoint = "https://test.salesforce.com/services/Soap/c/36.0/";
		try {
			login(username, password, authEndPoint);
		} catch (CloneNotSupportedException e) {
		   System.out.println("Error occured.");
		}
		
	}
	
	private boolean login(String username, String password, String authEndPoint) throws CloneNotSupportedException {
	      boolean success = false;
	      
	      String RECEIVE_QUERY = "<SOQL_QUERY>";

	      try {
	         ConnectorConfig config = new ConnectorConfig();
	         config.setUsername(username);
	         config.setPassword(password);

	         config.setAuthEndpoint(authEndPoint);
	         //Set the Custom Transporter
	         config.setTransport(SalesforceHttpTransport.class);
	         connection = new EnterpriseConnection(config);

	         QueryResult result = connection.query(RECEIVE_QUERY);
	         success = true;         
	      } catch (ConnectionException ce) {
	         System.out.println("Error occured.");
	      }

	      return success;
	   }

}
