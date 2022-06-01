package entities;

import java.util.ArrayList;

import dataAccessObject.FlightDAO;

public class FlightModel {
private ArrayList<Flight> flights;
	
	public FlightModel() {
		this.flights = new ArrayList<Flight>();
		this.flights = FlightDAO.getInstance().selectAll();
	}
	
	public FlightModel(ArrayList<Flight> listFlight) {
		super();
		this.flights = listFlight;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setEmployees(ArrayList<Flight> listFlight) {
		this.flights = listFlight;
	}
	
	public void insert(Flight flg) {
		this.flights.add(flg);
	}
	
	public void remove(Flight flg) {
		int i;
		for(i=0;i<flights.size();i++) {
			if(flights.get(i).getFlightId()==flg.getFlightId()) {
				break;
			}
		}
		this.flights.remove(i);
	}
	
	public void update(Flight student) {
//		int i;
//		for(i=0;i<this.dsSinhVien.size();i++) {
//			if(this.dsSinhVien.get(i).getMaSinhVienInt()==student.getMaSinhVienInt())
//				break;
//		}
//		this.dsSinhVien.remove(i);
//		this.dsSinhVien.add(student);
	}

	public boolean kiemTraStudentTonTai(Flight st) {
//		for(Employee student: this.dsSinhVien) {
//			if(student.getMaSinhVienInt() == st.getMaSinhVienInt())
//				return true;
//		}
		return false;
	}
}
