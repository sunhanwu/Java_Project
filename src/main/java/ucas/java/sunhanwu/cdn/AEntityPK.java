package ucas.java.sunhanwu.cdn;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AEntityPK implements Serializable {
    private String dns;
    private String ip;

    @Column(name = "dns")
    @Id
    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    @Column(name = "ip")
    @Id
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AEntityPK aEntityPK = (AEntityPK) o;

        if (dns != null ? !dns.equals(aEntityPK.dns) : aEntityPK.dns != null) return false;
        if (ip != null ? !ip.equals(aEntityPK.ip) : aEntityPK.ip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dns != null ? dns.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        return result;
    }
}
