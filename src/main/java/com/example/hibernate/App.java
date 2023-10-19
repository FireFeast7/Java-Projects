package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
           session.createQuery("update users set email = '1235@gmail.com' where username = 'Martin'").executeUpdate();
           session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
