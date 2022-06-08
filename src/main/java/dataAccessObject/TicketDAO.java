package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Ticket;

public class TicketDAO implements DAOInterface<Ticket>{
	
	public static TicketDAO getInstance() {
		return new TicketDAO();
	}

	@Override
	public int add(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Ticket t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delele(Ticket t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public int saveOrUpdate(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Ticket> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Ticket> resultSelect = (ArrayList<Ticket>) session.createQuery("FROM Ticket",Ticket.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ticket selectById(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
