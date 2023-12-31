package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Save
        Student st = new Student(1, "nisha", "kolhapur");
        System.out.println(st);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();

        // Save another student
        Student st1 = new Student(2, "gayu", "kolhapur");
        System.out.println(st1);

        Session session1 = factory.openSession();
        Transaction tx1 = session1.beginTransaction();
        session1.save(st1);
        tx1.commit();
        session1.close();

        // Update
        session = factory.openSession();
        tx = session.beginTransaction();

        // Load the student by ID
        Student studentToUpdate = session.get(Student.class, 2);

        // Update the student
        studentToUpdate.setName("Shraddha");
        studentToUpdate.setCity("Aundh");

        // Commit the transaction
        tx.commit();
        session.close();

        System.out.println("done...");

        // Delete
        session = factory.openSession();
        tx = session.beginTransaction();

        // Load the student by ID
        Student studentToDelete = session.get(Student.class, 1);

        // Delete the student
        session.delete(studentToDelete);

        // Commit the transaction
        tx.commit();
        session.close();

        System.out.println("done...");
    }
}
