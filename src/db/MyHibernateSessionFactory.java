package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * Created by NamNicer on 2017/5/11.
 */
public class MyHibernateSessionFactory {
    private  static SessionFactory sessionFactory;
    private MyHibernateSessionFactory(){}//体现单例模式
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            Configuration config = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }else {
        return sessionFactory;
        }
    }
}
