package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {

        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session  = factory.getCurrentSession();
            Employee emp = new Employee("Oleg","Petrov","hr",800);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int myId = emp.getId();
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class,10);
            System.out.println(employee);
            session.getTransaction().commit();
            System.out.println(employee);
            System.out.println("Done2");
        }
    }
}
