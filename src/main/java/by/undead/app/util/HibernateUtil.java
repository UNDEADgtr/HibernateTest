package by.undead.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private SessionFactory sf;

    private final ThreadLocal sessions = new ThreadLocal();

    private static HibernateUtil init = new HibernateUtil();

    public HibernateUtil() throws ExceptionInInitializerError{
        try {
            Configuration config = new AnnotationConfiguration();
            config.setNamingStrategy(new MyNamingStrategy());
            this.sf = config.configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static HibernateUtil getInst(){
        return init;
    }

    public Session getSession(){
        Session session = (Session) sessions.get();
        if(session==null){
        session = sf.openSession();
        sessions.set(session);
        }
        return session;
    }
}
