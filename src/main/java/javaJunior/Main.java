package javaJunior;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javaJunior.model.Person;

public class Main {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Person person = new Person("Ivan", 20);
            session.save(person);
            Person person1 = new Person("Semen", 25);
            session.save(person1);
            System.out.println("Person saved successfully");

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}