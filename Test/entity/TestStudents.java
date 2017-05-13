package entity;

import db.MyHibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

import java.sql.Date;
import java.util.List;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class TestStudents {
    @Test
    public void TestStudentsExport(){//自动生成表结构
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.getCurrentSession();
        SchemaExport schemaExport = new SchemaExport(config);
        schemaExport.create(true,true);
    }
    @Test
    public void TestSessionFactory(){
        SessionFactory sessionFactory = MyHibernateSessionFactory.getSessionFactory();
        if(sessionFactory !=null){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void TestSaveStudents(){
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Students s1 = new Students("03","joy","woman",new Date(1996-1-29),"shanghai");
        //Students s2 = new Students("16","mark","man",new Date(1996-3-2),"helan");
       // Students s3 = new Students("06","merry","woman",new Date(1994-8-8),"sichuan");
        session.save(s1);
        //session.save(s2);
        //session.save(s3);
        transaction.commit();
        sessionFactory.close();
    }
    @Test
    public void TestQueryStudents(){
        StudentsDao studentsDao= new StudentsDaoImpl();
        List<Students> list = studentsDao.queryAllStudents();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));//因为students类有toString方法
        }
    }
    @Test
    public void TestDeleteStudents(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        Assert.assertEquals(true,studentsDao.deleteStudents("03"));
    }
    @Test
    public void TestAddStudents(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        Students s = new Students("04","april","woman",new Date(1995-1-29),"shandong");
        Assert.assertEquals(true,studentsDao.addStudents(s));
    }
    @Test
    public void TestSelectStudents(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        List<Students> list = studentsDao.selectStudents("m");
        for(int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

