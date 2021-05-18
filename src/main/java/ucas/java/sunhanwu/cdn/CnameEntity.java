package ucas.java.sunhanwu.cdn;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CNAME", schema = "cdn", catalog = "")
@IdClass(CnameEntityPK.class)
public class CnameEntity {
    private String dns1;
    private String dns2;
    private String area;
    private Timestamp date;
    private String flag;

    @Id
    @Column(name = "dns1")
    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    @Id
    @Column(name = "dns2")
    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CnameEntity that = (CnameEntity) o;

        if (dns1 != null ? !dns1.equals(that.dns1) : that.dns1 != null) return false;
        if (dns2 != null ? !dns2.equals(that.dns2) : that.dns2 != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dns1 != null ? dns1.hashCode() : 0;
        result = 31 * result + (dns2 != null ? dns2.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
