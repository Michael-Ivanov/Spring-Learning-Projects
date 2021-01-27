package miv.study.demo;

import miv.study.config.HibernateConfig;
import miv.study.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = HibernateConfig.getSessionFactory();
        // create session
        Session session= factory.getCurrentSession();
        try  {
            int studentId = 1;

            // start a transaction
            session.beginTransaction();

            // retrieve student object based on the id
            System.out.println("Getting student with id: " + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("Get complete: " + student);

            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            // NEW CODE, new transaction

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
