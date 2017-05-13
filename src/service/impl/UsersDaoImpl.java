package service.impl;

import db.MyHibernateSessionFactory;
import entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.UsersDao;

import java.util.List;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class UsersDaoImpl implements UsersDao {
    @Override
    public boolean UserLogin(Users u) {
        Transaction transaction = null;
        String hql = "";
        try {
            SessionFactory sessionFactory = MyHibernateSessionFactory.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            hql = "from Users where username=? and password=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, u.getUsername());
            query.setParameter(1, u.getPassword());
            List list =query.list();
            transaction.commit();
            if(list.size()>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (transaction != null) {
                transaction = null;
            }
        }
    }
}
