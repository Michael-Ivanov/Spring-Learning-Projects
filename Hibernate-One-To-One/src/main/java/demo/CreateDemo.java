package demo;

import config.HibernateConfig;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try(Session session = factory.getCurrentSession()) {
            // create the objects
            /*Instructor instructor = new Instructor("Chad", "Darby", "darby@mail.com");
            InstructorDetail detail = new InstructorDetail("http://www.youtube.com/hhh", "Eating");*/

            Instructor instructor = new Instructor(
                    "Madhu", "Patel", "m_patel@mail.com");
            InstructorDetail detail = new InstructorDetail(
                    "http://www.youtube.com/patel_madhu", "Meditation");

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
