package entities;

import java.util.ArrayList;

import dataAccessObject.TicketDAO;

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
		// TODO Auto-generated method stub
		
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
	
	

}
