package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import atul.model.ResponseSuccess;

/**
 * Servlet implementation class CreateSubscripton
 */
@WebServlet("/CreateSubscripton")
public class CreateSubscripton extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String eventURL= (String) request.getParameter("eventURL");
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(200);
        ResponseSuccess responseObject = new ResponseSuccess(true,"new-account-identifier");
        String json = mapper.writeValueAsString(responseObject);
        out.print(json);
        System.out.println(eventURL);
        
//        OAuthConsumer consumer = new DefaultOAuthConsumer("growhealth-152806", "CiDfzbHZy4aTKLl0");
//        URL url = new URL(eventURL);
//        HttpURLConnection req = (HttpURLConnection) url.openConnection();
//        
//        req.setRequestProperty("Accept", "application/json");
//        try{
//            consumer.sign(req);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        req.connect();
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        String line = "";
//        while((line = br.readLine())!= null){
//            System.out.println(line);
//        }
//        br.close();
	
	}

}
