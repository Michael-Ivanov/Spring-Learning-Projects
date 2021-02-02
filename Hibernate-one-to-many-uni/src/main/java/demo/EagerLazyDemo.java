package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EagerLazyDemo {

    public static void main(String[] args) {

        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            int id = 4;
            // begin a transaction
            session.beginTransaction();
            // get the instructor from db
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("gggg: Instructor: " + instructor);
            // get courses for the instructor
            System.out.println("gggg: Courses: " + instructor.getCourses());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("gggg: Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
