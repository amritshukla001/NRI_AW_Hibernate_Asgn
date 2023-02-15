package com.hibernate.HibernateDemoProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Select {

	public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Student id:");
        
        Student student=(Student)session.load(Student.class, scan.nextInt());
        
        System.out.println("Student Name: "+ student.getName());
        System.out.println("Student City:"+student.getCity());
	}

}
