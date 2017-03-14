package atul.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

interface oAuthInterface{
	public String getEventUrl(HttpServletRequest request, HttpServletResponse response);
	public HttpURLConnection oAuthConn(String eventUrl);
}
public class oAuth {

	public String getEventUrl(HttpServletRequest request, HttpServletResponse response)	{
		response.setContentType("application/json");
	      String eventUrl= (String) request.getParameter("eventUrl");
	      return eventUrl;
	}
	public HttpURLConnection oAuthConn(String eventUrl) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException{
		  OAuthConsumer consumer = new DefaultOAuthConsumer("cipher-154159", "UQWitWRBCxfiiJQM");
          URL url = new URL(eventUrl);
          HttpURLConnection req = (HttpURLConnection) url.openConnection();
          req.setRequestProperty("Accept", "application/json");
          consumer.sign(req);
          return req;
	}

}
