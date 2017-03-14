package atul.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import atul.beans.MainClass;
import atul.model.ResponseSuccess;
import atul.services.cancelSubscriptionServices;
import atul.utils.oAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import org.codehaus.jackson.map.DeserializationConfig;
/**
 * Servlet implementation class CancelSubscription
 */
@WebServlet("/CancelSubscription")
public class CancelSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
	       PrintWriter out = response.getWriter();
	       String eventUrl= (String) request.getParameter("eventUrl");
	       oAuth oauth=new oAuth();
	 	   ObjectMapper mapper = new ObjectMapper();
	       mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	       //response.setStatus(200);
	       ResponseSuccess responseObject = new ResponseSuccess(true,"random-account-identifier");
	       String json = mapper.writeValueAsString(responseObject);
	      cancelSubscriptionServices cancelServices = new cancelSubscriptionServices();
	      try{
	    	   
	    	   HttpURLConnection req=oauth.oAuthConn(eventUrl);
	            req.connect();          
	            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
	            String line = "";
	            while((line = br.readLine())!= null){
	                System.out.println(line);
	                MainClass pojo = mapper.readValue(line,MainClass.class);
	                System.out.println(pojo.getPayload().getCompany());          
	                cancelServices.cancelService(pojo);
	            }
	            br.close();
	            out.print(json);
	            out.flush();
	       }catch(Exception e){
	           System.out.print("###error: ");
	           e.printStackTrace();
	       }
	
	}	
	}

