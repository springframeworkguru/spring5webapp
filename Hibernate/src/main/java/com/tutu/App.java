package com.tutu;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("hi");
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);

        Student s1 = new Student("Hemant", 2 , "Hyderabad");
        System.out.println(s1);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(s1);
        session.getTransaction().commit();
    }
}
