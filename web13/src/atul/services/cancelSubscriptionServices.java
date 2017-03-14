package atul.services;

import atul.beans.MainClass;
import atul.dao.cancelSubscriptionDao;
import atul.model.ResponseSuccess;
interface cancelSubsServicesInterface{
	public ResponseSuccess cancelService(MainClass mainClass) throws Exception;	
}

public class cancelSubscriptionServices implements cancelSubsServicesInterface{
public ResponseSuccess cancelService(MainClass mainClass) throws Exception{
       
	ResponseSuccess responseObject;
    cancelSubscriptionDao Dao = new cancelSubscriptionDao();
    if(Dao.checkExist(mainClass))
    {
        
        if(Dao.getAccountIdentifier(mainClass))
        {
            Dao.del(mainClass);
            responseObject = new ResponseSuccess(true,mainClass.getCreator().getFirstName()+":"+mainClass.getCreator().getUuid());
            return responseObject;
        }
        responseObject = new ResponseSuccess(false,"");   
        return responseObject;
    }
    else
    {
        System.out.println("User already unsubscribed the product");
        responseObject = new ResponseSuccess(false,"");
        return responseObject;
    }
}
}
