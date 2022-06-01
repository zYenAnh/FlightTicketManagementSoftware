package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Flight;

public class FlightDAO implements DAOInterface<Flight>{

	public static FlightDAO getInstance() {
		return new FlightDAO();
	}
	
	@Override
	public int add(Flight t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Flight t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delele(Flight t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Flight t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Flight> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Flight> resultSelect = (ArrayList<Flight>) session.createQuery("FROM Flight",Flight.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Flight selectById(Flight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Flight> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
