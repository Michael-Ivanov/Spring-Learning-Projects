package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructorDemo {

    public static void main(String[] args) {



        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {

            Instructor instructor = new Instructor(
                    "Johnny", "Doe", "jdoe@mail.com");
            InstructorDetail detail = new InstructorDetail(
                    "http://www.youtube.com/jondoe", "Bike");

            // associate the objects
            instructor.setInstructorDetail(detail);

            // begin a transaction
            session.beginTransaction();

            // save the instructor
            // this will also save the details object because of CascadeType.ALL
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
