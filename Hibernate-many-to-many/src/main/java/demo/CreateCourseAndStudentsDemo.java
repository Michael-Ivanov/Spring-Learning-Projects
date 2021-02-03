package demo;

import config.HibernateConfig;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        try(SessionFactory factory = HibernateConfig.getConfiguration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {

            // begin a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How to score one million points");

            // add some reviews
            course.addReview(new Review("Great course ... loved it!"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot!"));

            // save the course /// and leverage the cascade all
            System.out.println("Saving the course: " + course);
            session.save(course);
            System.out.println("Course saved.");

            // create the students
            Student student1 = new Student("John", "Doe", "john@mail.com");
            Student student2 = new Student("Mary", "Public", "mary@mail.com");

            // add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("Saving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
