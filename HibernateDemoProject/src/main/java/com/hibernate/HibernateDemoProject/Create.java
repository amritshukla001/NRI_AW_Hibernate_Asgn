package com.hibernate.HibernateDemoProject;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Create 
{
    public static void main( String[] args )
    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        Student st=new Student();
        st.setId(114);
        st.setName("Dev");
        st.setCity("Kumar");
        System.out.println(st);
        
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        
        tx.commit();
        session.close();
        System.out.println("Creation Done");
        
    }
}
