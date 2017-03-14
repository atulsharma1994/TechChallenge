package atul.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import atul.beans.MainClass;
interface createSubsInterface{
	 public void insert(MainClass mainClass) throws Exception;
	 public boolean checkExist(MainClass mainClass) throws Exception;
}

public class createSubsDao implements createSubsInterface{
	 public void insert(MainClass mainClass) throws Exception{
	        
	        Connection connection = DBConnection.getConnection();
	        System.out.println("In DAO");
	        String uuid,baseUrl, partner,firstName,email;
	        
	        uuid = mainClass.creator.getUuid();
	        baseUrl = mainClass.marketplace.getBaseUrl();
	        partner = mainClass.marketplace.getPartner();
	        firstName = mainClass.creator.getFirstName();
	        email = mainClass.getFlag();
	        
	        
	        String query = "insert into Developer values(?,?,?,?,?)";
	        PreparedStatement prepareStatement = (PreparedStatement) connection.prepareStatement(query);
	        prepareStatement.setString(1, uuid);
	        prepareStatement.setString(2, baseUrl);
	        prepareStatement.setString(3, partner);
	        prepareStatement.setString(4, firstName);
	        prepareStatement.setString(5, email);
	        
	        int resultSet = prepareStatement.executeUpdate();     
	    }
	    
	    public boolean checkExist(MainClass mainClass) throws Exception{

	        Connection connection = DBConnection.getConnection();
	        String uuid;    
	        uuid = mainClass.creator.getUuid();
	        
	        String query = "select * from Developer where uuid = ?";
	        PreparedStatement prepareStatement = (PreparedStatement) connection.prepareStatement(query);
	        prepareStatement.setString(1, uuid);
	        ResultSet resultSet = (ResultSet) prepareStatement.executeQuery();
	        while(resultSet.next()){
	            return true;
	        }
	        return false;
	        
	    }
	
}
