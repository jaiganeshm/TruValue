package aus.hack.hedna.domain;

public class Property
{
    private String property_id;

    private String anchor_customer_id;

    private String timezone;

    private String etag;

    private Address address;

    private String email;

    private String is_active;

    private String name;

    private String property_code;

    public String getProperty_id ()
    {
        return property_id;
    }

    public void setProperty_id (String property_id)
    {
        this.property_id = property_id;
    }

    public String getAnchor_customer_id ()
    {
        return anchor_customer_id;
    }

    public void setAnchor_customer_id (String anchor_customer_id)
    {
        this.anchor_customer_id = anchor_customer_id;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getIs_active ()
    {
        return is_active;
    }

    public void setIs_active (String is_active)
    {
        this.is_active = is_active;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getProperty_code ()
    {
        return property_code;
    }

    public void setProperty_code (String property_code)
    {
        this.property_code = property_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [property_id = "+property_id+", anchor_customer_id = "+anchor_customer_id+", timezone = "+timezone+", etag = "+etag+", address = "+address+", email = "+email+", is_active = "+is_active+", name = "+name+", property_code = "+property_code+"]";
    }
}