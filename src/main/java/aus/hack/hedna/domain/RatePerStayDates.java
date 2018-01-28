package aus.hack.hedna.domain;

public class RatePerStayDates
{
    private String rate_before_tax;

    private String date;

    private String rate_after_tax;

    public String getRate_before_tax ()
    {
        return rate_before_tax;
    }

    public void setRate_before_tax (String rate_before_tax)
    {
        this.rate_before_tax = rate_before_tax;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getRate_after_tax ()
    {
        return rate_after_tax;
    }

    public void setRate_after_tax (String rate_after_tax)
    {
        this.rate_after_tax = rate_after_tax;
    }

	@Override
	public String toString() {
		return "RatePerStayDates [rate_before_tax=" + rate_before_tax + ", date=" + date + ", rate_after_tax="
				+ rate_after_tax + "]";
	}

}
