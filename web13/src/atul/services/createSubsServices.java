package atul.services;

import atul.beans.MainClass;
import atul.dao.createSubsDao;
interface createSubsInterface{
	public boolean createService(MainClass mainClass) throws Exception;	
}

public class createSubsServices implements createSubsInterface{
public boolean createService(MainClass mainClass) throws Exception{
        
        createSubsDao createSubsDao = new createSubsDao();
        if(!createSubsDao.checkExist(mainClass)){
            createSubsDao.insert(mainClass);
            return true;
        }
        else
            System.out.println("Adready Exist");
            
        return false;
    }
}
