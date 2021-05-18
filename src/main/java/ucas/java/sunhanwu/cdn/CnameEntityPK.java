package ucas.java.sunhanwu.cdn;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CnameEntityPK implements Serializable {
    private String dns1;
    private String dns2;

    @Column(name = "dns1")
    @Id
    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    @Column(name = "dns2")
    @Id
    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CnameEntityPK that = (CnameEntityPK) o;

        if (dns1 != null ? !dns1.equals(that.dns1) : that.dns1 != null) return false;
        if (dns2 != null ? !dns2.equals(that.dns2) : that.dns2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dns1 != null ? dns1.hashCode() : 0;
        result = 31 * result + (dns2 != null ? dns2.hashCode() : 0);
        return result;
    }
}
