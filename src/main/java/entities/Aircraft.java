package entities;
// Generated Jun 6, 2022, 6:02:59 PM by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Aircraft generated by hbm2java
 */
@Entity
@Table(name = "aircraft", catalog = "sellticketdb")
public class Aircraft implements java.io.Serializable {

	private String aircraftId;
	private Integer economyClassSeats;
	private Integer businessClassSeats;
	private Set<Flight> flights = new HashSet<Flight>(0);

	public Aircraft() {
	}

	public Aircraft(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public Aircraft(String aircraftId, Integer economyClassSeats, Integer businessClassSeats, Set<Flight> flights) {
		this.aircraftId = aircraftId;
		this.economyClassSeats = economyClassSeats;
		this.businessClassSeats = businessClassSeats;
		this.flights = flights;
	}

	@Id

	@Column(name = "Aircraft_ID", unique = true, nullable = false, length = 20)
	public String getAircraftId() {
		return this.aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	@Column(name = "EconomyClassSeats")
	public Integer getEconomyClassSeats() {
		return this.economyClassSeats;
	}

	public void setEconomyClassSeats(Integer economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}

	@Column(name = "BusinessClassSeats")
	public Integer getBusinessClassSeats() {
		return this.businessClassSeats;
	}

	public void setBusinessClassSeats(Integer businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
	public Set<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

}
