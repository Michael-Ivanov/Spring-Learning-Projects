package demo;

import config.HibernateConfig;
import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;

public class FetchJoinDemo {

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
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                                + "join fetch i.courses "
                                                + "where i.id=:theInstructorId",
                    Instructor.class);
            // set parameter for query
            query.setParameter("theInstructorId", id);

            // execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("gggg: Instructor: " + instructor);
            // commit transaction
            session.getTransaction().commit();
            // close session
            session.close();
            // get courses for the instructor
            System.out.println("gggg: Courses: " + instructor.getCourses());

            System.out.println("gggg: Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
