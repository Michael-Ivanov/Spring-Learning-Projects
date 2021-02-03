package demo;

import config.HibernateConfig;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddCoursesForMaryDemo {

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

            // get the student mary from database
            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Student loaded: " + student);
            System.out.println("Courses: " + student.getCourses());

            // create more courses
            Course course1 = new Course("Rubik's cube - How to speed cube!");
            Course course2 = new Course("Atari 2600 - Game development.");


            // add some reviews
            course1.addReview(new Review("Normal course. Improved my skills"));
            course1.addReview(new Review("Great. Now i'm a champion"));
            course2.addReview(new Review("Atari is a such legacy thing.."));
            // add mary to courses
            course1.addStudent(student);
            course2.addStudent(student);
            // save the courses
            System.out.println("Saving the courses...");
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
