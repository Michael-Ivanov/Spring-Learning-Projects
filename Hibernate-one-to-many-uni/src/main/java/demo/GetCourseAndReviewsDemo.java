package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {

            // begin a transaction
            session.beginTransaction();

            // get the course
            int id = 3;
            Course course = session.get(Course.class, id);
            // print the course
            System.out.println(">>" + course);
            // print the course reviews
            System.out.println(">>" + course.getReviews());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
