package miv.study.demo;

import miv.study.config.HibernateConfig;
import miv.study.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = HibernateConfig.getSessionFactory();
        // create session

        try (Session session = factory.getCurrentSession()) {
            // create a student object
            System.out.println("Creating new Student object...");
            Student student = new Student("John", "Wu", "JWu@mail.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the student...");
            session.save(student);
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
