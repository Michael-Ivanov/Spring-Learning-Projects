package miv.study.demo;

import miv.study.config.HibernateConfig;
import miv.study.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = HibernateConfig.getSessionFactory();
        // create a student object
        System.out.println("Creating new Student object...");
        Student student = new Student("Daffy", "Duck", "DDuck@mail.com");
        // create session
        try (Session session = factory.getCurrentSession()) {
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);
            // commit the transaction
            session.getTransaction().commit();
            // new code
            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + student.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            // retrieve student based on the id: primary key
            System.out.println("Getting student with id: " + student.getId());
            Student newStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + newStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
