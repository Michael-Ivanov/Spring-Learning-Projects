package demo;

import config.HibernateConfig;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {



        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            int id = 1;

            // begin a transaction
            session.beginTransaction();
            // get the instructor detail object
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            // print the instructor detail
            System.out.println("Instructor Detail: " + instructorDetail);
            // print the associated instructor
            System.out.println("The associated instructor: " + instructorDetail.getInstructor());
            // delete the instructor detail
            System.out.println("Deleting instructorDetail: " + instructorDetail);
            session.delete(instructorDetail);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
