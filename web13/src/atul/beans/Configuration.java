package atul.beans;

public class Configuration
{
    private String domain;

    public String getDomain ()
    {
        return domain;
    }

    public void setDomain (String domain)
    {
        this.domain = domain;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [domain = "+domain+"]";
    }
}