package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseAndReviewDemo {

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

            // create a course
            Course course = new Course("Pacman - How to score one million points");

            // add some reviews
            course.addReview(new Review("Great course ... loved it!"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot!"));

            // save the course /// and leverage the cascade all
            System.out.println("Saving the course: " + course);
            System.out.println("Reviews: " + course.getReviews());
            session.save(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
