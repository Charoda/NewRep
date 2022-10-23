package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session  = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> emps = session.createQuery("from Employee")
//                            .getResultList();
            List<Employee> emps = session.createQuery("from Employee where name ='Zaur'")
                    .getResultList();
            emps.stream().forEach(System.out::println);
            session.getTransaction().commit();
            System.out.println("Done!");

        }
    }
}
