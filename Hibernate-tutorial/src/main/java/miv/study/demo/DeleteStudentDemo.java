package miv.study.demo;

import miv.study.config.HibernateConfig;
import miv.study.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = HibernateConfig.getSessionFactory();
        // create session
        Session session= factory.getCurrentSession();
        try  {
            int studentId = 1;

            // start a transaction
            session.beginTransaction();

            // retrieve student object based on the id
            System.out.println("Getting student with id: " + studentId);
            Student student = session.get(Student.class, studentId);

            // delete the student
//            System.out.println("Deleting student..." + student);
//            session.delete(student);

            // delete the student id = 2
            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
