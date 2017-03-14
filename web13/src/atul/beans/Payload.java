package atul.beans;
public class Payload
{
    private Order order;

    private AddonInstance addonInstance;

    public Company company;

    public Account account;

    public AddonBinding addonBinding;

    public Configuration configuration;

    public Notice notice;

    public User user;

    public Order getOrder ()
    {
        return order;
    }

    public void setOrder (Order order)
    {
        this.order = order;
    }

    public AddonInstance getAddonInstance ()
    {
        return addonInstance;
    }

    public void setAddonInstance (AddonInstance addonInstance)
    {
        this.addonInstance = addonInstance;
    }

    public Company getCompany ()
    {
        return company;
    }

    public void setCompany (Company company)
    {
        this.company = company;
    }

    public Account getAccount ()
    {
        return account;
    }

    public void setAccount (Account account)
    {
        this.account = account;
    }

    public AddonBinding getAddonBinding ()
    {
        return addonBinding;
    }

    public void setAddonBinding (AddonBinding addonBinding)
    {
        this.addonBinding = addonBinding;
    }

    public Configuration getConfiguration ()
    {
        return configuration;
    }

    public void setConfiguration (Configuration configuration)
    {
        this.configuration = configuration;
    }

    public Notice getNotice ()
    {
        return notice;
    }

    public void setNotice (Notice notice)
    {
        this.notice = notice;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [order = "+order+", addonInstance = "+addonInstance+", company = "+company+", account = "+account+", addonBinding = "+addonBinding+", configuration = "+configuration+", notice = "+notice+", user = "+user+"]";
    }
}