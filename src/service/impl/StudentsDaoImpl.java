package service.impl;

import db.MyHibernateSessionFactory;
import entity.Students;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.StudentsDao;

import java.util.List;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class StudentsDaoImpl implements StudentsDao {
    @Override
    public List<Students> queryAllStudents() {
        Transaction transaction =null;
        List<Students> list=null;
        String hql="";
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            hql="from entity.Students";
            transaction =session.beginTransaction();
            Query query=session.createQuery(hql);
            list=query.list();
            transaction.commit();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.commit();
            return list;
        }finally {
            if(transaction !=null){
                transaction=null;
            }
        }
    }

    @Override
    public Students queryStudentsBySid(String sid) {
        Transaction transaction = null;
        Students students =null;
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            transaction =session.beginTransaction();
            students =(Students)session.get(Students.class,sid);
            transaction.commit();
            return students;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.commit();
            return students;
        }finally {
            if(transaction!=null){
                transaction =null;
            }
        }
    }

    @Override
    public boolean addStudents(Students s) {
        Transaction transaction = null;
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            transaction =session.beginTransaction();
            session.save(s);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(transaction!=null){
                transaction =null;
            }
        }
    }

    @Override
    public boolean updateStudents(Students s) {
        Transaction transaction = null;
        try {
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.update(s);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (transaction != null) {
                transaction = null;
            }
        }
    }
    @Override
    public boolean deleteStudents(String sid) {
        Transaction transaction = null;
        try{
            Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Students s = (Students) session.get(Students.class,sid);
            session.delete(s);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(transaction !=null){
                transaction=null;
            }
        }
    }

    @Override
    public List<Students> selectStudents(String sname) {
        Transaction transaction = null;
        List<Students> selectList = null;
        String hql="";
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            hql="from Students where sname like '%"+sname+"%'";
            Query query = session.createQuery(hql);
            selectList = query.list();
            transaction.commit();
            return selectList;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.commit();
            return null;
        }finally {
            if(transaction != null){
                transaction = null;
            }
        }

    }
}
