package ucas.java.sunhanwu.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import ucas.java.sunhanwu.cdn.AEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QueryDatabase {

    public static SessionFactory sessionFactory;
    public static final ThreadLocal<Session> session = new ThreadLocal<>();
    static
    {
        try
        {
            Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            System.err.println("Initialize SessionFactory fail " + e);
        }
    }

    public static Session getSession()
    {
        Session sess = (Session)session.get();
        if(sess==null)
        {
            sess = sessionFactory.openSession();
            session.set(sess);
        }
        return sess;
    }

    public static void closeSession()
    {
        Session sess = (Session)session.get();
        if(sess!=null)
        {
            sess.close();
        }
        session.set(null);
        sessionFactory.close();
    }

    //constructor
    public QueryDatabase(){}

    public List query(String query, int type) throws IllegalAccessException {
        List result = null;
        Session sess = getSession();
        // 0 for A record, 1 for CNAME record
        switch (type)
        {
            case 0:
                String sql1 = "from AEntity a where a.dns like '%" + query + "%'";
                Query q1 = sess.createQuery(sql1);
                result = q1.list();
                break;
            case 1:
                String sql2 = "from CnameEntity cname where cname.dns1 like '%" + query + "%'";
                Query q2 = sess.createQuery(sql2);
                result = q2.list();
                break;
            default:
                throw new IllegalAccessException("type must be 0 or 1");
        }
        return result;
    }
}
