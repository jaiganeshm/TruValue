package aus.hack.hedna.domain;

public class Address
{
    private String address_line1;

    private String zip_code;

    private String country;

    private String city;

    public String getAddress_line1 ()
    {
        return address_line1;
    }

    public void setAddress_line1 (String address_line1)
    {
        this.address_line1 = address_line1;
    }

    public String getZip_code ()
    {
        return zip_code;
    }

    public void setZip_code (String zip_code)
    {
        this.zip_code = zip_code;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

	@Override
	public String toString() {
		return "Address [address_line1=" + address_line1 + ", zip_code=" + zip_code + ", country=" + country + ", city="
				+ city + "]";
	}
}