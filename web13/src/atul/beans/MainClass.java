package atul.beans;

public class MainClass
{
    private String returnUrl;

    private int applicationUuid;

    private String flag;

    public Payload payload;

    private String[] links;

    public Marketplace marketplace;

    private String type;

    public Creator creator;

    public String getReturnUrl ()
    {
        return returnUrl;
    }

    public void setReturnUrl (String returnUrl)
    {
        this.returnUrl = returnUrl;
    }

    public int getApplicationUuid ()
    {
        return applicationUuid;
    }

    public void setApplicationUuid (int applicationUuid)
    {
        this.applicationUuid = applicationUuid;
    }

    public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    public Payload getPayload ()
    {
        return payload;
    }

    public void setPayload (Payload payload)
    {
        this.payload = payload;
    }

    public String[] getLinks ()
    {
        return links;
    }

    public void setLinks (String[] links)
    {
        this.links = links;
    }

    public Marketplace getMarketplace ()
    {
        return marketplace;
    }

    public void setMarketplace (Marketplace marketplace)
    {
        this.marketplace = marketplace;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Creator getCreator ()
    {
        return creator;
    }

    public void setCreator (Creator creator)
    {
        this.creator = creator;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [returnUrl = "+returnUrl+", applicationUuid = "+applicationUuid+", flag = "+flag+", payload = "+payload+", links = "+links+", marketplace = "+marketplace+", type = "+type+", creator = "+creator+"]";
    }
}