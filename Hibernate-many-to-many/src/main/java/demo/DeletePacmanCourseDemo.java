package demo;

import config.HibernateConfig;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeletePacmanCourseDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            // begin a transaction
            session.beginTransaction();

            // get the pacman course from db
            int courseId = 4;
            Course course = session.get(Course.class, courseId);
            // delete the course
            System.out.println("Deleting course: " + course);
            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
