
/**
 * Created by Rijad on 18.08.2014.
 */
public class MemberController {
    private String name;
    private String vorname;
    private int memberSince;
    private int payment;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public void setMemberSince(int date)
    {
        this.memberSince = date;
    }

    public void setPayment(int payment)
    {
        this.payment = payment;
    }
}
