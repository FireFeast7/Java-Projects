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
            Users user = new Users();
//            user.setEmail("qwerty@gmail.com");
//            user.setUsername("hehe");
//            user.setFirstName("qwer");
//            user.setLastName("ty");
//            session.save(user);
            session.createQuery("update users set lastName = 'sex' where  userId=6").executeUpdate();
            session.createQuery("delete from users where userId =  5").executeUpdate();
           session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
