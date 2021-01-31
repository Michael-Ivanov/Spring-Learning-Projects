package demo;

import config.HibernateConfig;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try(Session session = factory.getCurrentSession()) {

            // begin a transaction
            session.beginTransaction();

            // get instructor by primary key / id
            int id = 3;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            // delete the instructor
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                // will also delete associated object
                // because of CascadeType.ALL
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
