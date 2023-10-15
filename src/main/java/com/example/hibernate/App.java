package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            Users user = new Users();
            session.beginTransaction();
            user = session.get(Users.class,1);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println(user);
        }finally {
            session.close();
            factory.close();
        }
    }
}
