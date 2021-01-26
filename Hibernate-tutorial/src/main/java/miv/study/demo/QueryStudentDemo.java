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
            displayStudents(students);

            // query students: lastName = 'Wall'
            System.out.println("Students with lastName = 'Wall'");
            students = session.createQuery("from Student s where s.lastName='Wall'").getResultList();
            displayStudents(students);

            // query students: lastName = 'Wall" OR firstName = 'Daffy'
            System.out.println("Students with lastName = 'Wall' or firstName = 'Daffy'");
            students = session.createQuery(
                    "from Student where lastName = 'Wall' or firstName = 'Daffy'")
                    .getResultList();
            displayStudents(students);

            // query students: where email LIKE '%@ggg'
            System.out.println("Students with email LIKE '%@ggg'");
            students = session.createQuery("from Student s where s.email like '%@ggg'").getResultList();
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
