package ucas.java.sunhanwu.cdn;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "A", schema = "cdn")
@IdClass(AEntityPK.class)
public class AEntity {
    private String dns;
    private String ip;
    private String area;
    private Integer depth;
    private Timestamp date;
    private String flag;

    @Id
    @Column(name = "dns")
    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    @Id
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    @Column(name = "depth")
    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
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

        AEntity aEntity = (AEntity) o;

        if (dns != null ? !dns.equals(aEntity.dns) : aEntity.dns != null) return false;
        if (ip != null ? !ip.equals(aEntity.ip) : aEntity.ip != null) return false;
        if (area != null ? !area.equals(aEntity.area) : aEntity.area != null) return false;
        if (depth != null ? !depth.equals(aEntity.depth) : aEntity.depth != null) return false;
        if (date != null ? !date.equals(aEntity.date) : aEntity.date != null) return false;
        if (flag != null ? !flag.equals(aEntity.flag) : aEntity.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dns != null ? dns.hashCode() : 0;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
       String desc = "{" ;
       desc += this.dns + ", " ;
       desc += this.ip + ", ";
       desc += this.area + ", ";
       desc += this.depth + ", ";
       desc += this.date + ", ";
       desc += this.flag + "}\n";
       return desc;

    }
}
