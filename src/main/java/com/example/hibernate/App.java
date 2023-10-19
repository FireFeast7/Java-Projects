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
           List<Users> users = session.createQuery("from users where  lastName like '%a%t%' ").getResultList();
            for(Users temp : users) {
                System.out.println(temp);
            }
        }finally {
            session.close();
            factory.close();
        }
    }
}
