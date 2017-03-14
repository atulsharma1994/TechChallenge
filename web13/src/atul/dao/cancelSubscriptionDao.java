package atul.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import atul.beans.MainClass;

interface cancelSubsInterface{
	public void del(MainClass mainClass) throws ClassNotFoundException, SQLException;
	public boolean checkExist(MainClass mainClass) throws Exception;
	public boolean getAccountIdentifier(MainClass pojo) throws ClassNotFoundException, SQLException;
}
public class cancelSubscriptionDao implements cancelSubsInterface{
	
	public void del(MainClass mainClass) throws ClassNotFoundException, SQLException{
		Connection connection = DBConnection.getConnection();
		String uuid;
		uuid = mainClass.creator.getUuid();
		System.out.println("uuid="+uuid);
		String query = "delete from Developer where uuid = ?";
        PreparedStatement prepareStatement = (PreparedStatement) connection.prepareStatement(query);
        prepareStatement.setString(1, uuid);
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
	 
	 public boolean getAccountIdentifier(MainClass mainClass) throws ClassNotFoundException, SQLException {
	        // TODO Auto-generated method stub
		 Connection connection = DBConnection.getConnection();
	        Statement stmt = (Statement) connection.createStatement();
	        ResultSet rst = (ResultSet) stmt.executeQuery("select * from Developer WHERE uuid = '"+mainClass.getPayload().getAccount().getAccountIdentifier()+"'");
	        if(rst.next())
	        {
	            connection.close();
	            return true;
	        }
	        connection.close();
	        return false;
	    }

}
