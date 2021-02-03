package demo;

import config.HibernateConfig;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetCoursesForMaryDemo {

    public static void main(String[] args) {

        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {

            // begin a transaction
            session.beginTransaction();

            // get the student mary from database
            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Student loaded: " + student);
            System.out.println("Courses: " + student.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
