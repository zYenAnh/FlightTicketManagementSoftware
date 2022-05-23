package test;

import org.hibernate.Session;

import dataAccessObject.HibernateUtils;
import entities.Aircraft;

public class HibernateExample2 {
	public static void main(String[] args) {
        
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            // Begin a unit of work
            session.beginTransaction();
 
            // Insert user
            Aircraft ac = new Aircraft();
            ac.setAircraftId("Airline 370");
            ac.setNumberOfSeats(20);
            System.out.println("Cat id = " + session.save(ac));
             
            session.getTransaction().commit();
        }
    }
}
