package com.hibernate.HibernateDemoProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter Student id to update: ");
        Student student=(Student)session.get(Student.class, scan.nextInt());
        
        if(student!=null)
        {
        	session.delete(student);
        	session.flush();
        	tx.commit();
        	System.out.println("record deleted successfully");
        }
        
        else {
        	System.out.println("No such record found");
        }

	}

}
