import com.ivan.tutorial.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HibernateBoilerPlate {

    private SessionFactory sessionFactory;
    private User user;

    @Before
    public void setUp() {
        // Create the SessionFactory from hibernate.cfg.xml
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        user = UserUtil.createUser();
    }

    @After
    public void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

    @Test
    public void addUser() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        assertThat(session.contains(user), is(true));
        session.close();
    }

    @Test
    public void addThenDeleteUser() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        assertThat(session.contains(user), is(true));
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @Test
    public void addUserThenDeleteAuthority() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        assertThat(session.contains(user), is(true));

        List<User> users = session.createCriteria(User.class).list();
        User userDB = users.get(0);

        session.beginTransaction();
        userDB.getAuthorities().clear();
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void student() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Set<Phone> phoneNumbers = new HashSet<Phone>();
        phoneNumbers.add(new Phone("32354353"));
        phoneNumbers.add(new Phone("9889343423"));

        Student student = new Student();   
        student.setName("Hippo");
        student.setPhones(phoneNumbers);
        session.save(student);

        session.getTransaction().commit();
        
        session.beginTransaction();
        List<Student> students = session.createCriteria(Student.class).list();
        Student studentDb = students.get(0);
        studentDb.getPhones().clear();

        session.getTransaction().commit();

        session.close();


    }


}
