package model;

import java.util.ArrayList;

import dataAccessObject.TicketDAO;
import entities.Ticket;

public class TicketModel implements ModelInterface<Ticket>{

	private ArrayList<Ticket> tickets;
	
	public TicketModel() {
		tickets = new ArrayList<Ticket>();
		tickets = TicketDAO.getInstance().selectAll();
	}
	
	@Override
	public void insert(Ticket t) {
		tickets.add(t);
	}

	@Override
	public void remove(Ticket t) {
		this.tickets.remove(t);
		
	}

	@Override
	public void update(Ticket t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExists(Ticket t) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public Ticket searchTicketById(int id) {
		for(Ticket t: tickets) {
			if(t.getTicketId()==id)
				return t;
		}
		return null;
	}
	

}
