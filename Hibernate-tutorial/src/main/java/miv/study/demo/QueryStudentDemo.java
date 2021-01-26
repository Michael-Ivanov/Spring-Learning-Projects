package miv.study.demo;

import miv.study.config.HibernateConfig;
import miv.study.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateConfig.getSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").getResultList();

            // display students
            for (Student student : students) {
                System.out.println(student);
            }

            // query students: lastName = 'Wall'
            List<Student> students1 = session.createQuery("from Student s where s.lastName='Wall'").getResultList();
            for (Student student : students1) {
                System.out.println(student);
            }

            // commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
