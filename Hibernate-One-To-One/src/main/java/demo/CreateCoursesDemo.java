package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCoursesDemo {

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
            // create some courses
            Course course1 = new Course("Air Guitar - The ultimate guide");
            Course course2 = new Course("The Pinball Masterclass");
            // add courses to the instructor
            instructor.add(course1);
            instructor.add(course2);
            // save courses
            session.save(course1);
            session.save(course2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
