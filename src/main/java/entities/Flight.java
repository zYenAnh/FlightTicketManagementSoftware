package entities;
// Generated May 25, 2022, 10:24:12 AM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Flight generated by hbm2java
 */
@Entity
@Table(name = "flight", catalog = "flightticketmanagementdatabase")
public class Flight implements java.io.Serializable {

	private String flightId;
	private Aircraft aircraft;
	private Airport airport;
	private Date takeOffTime;
	private String destinationId;
	private Date landingTime;
	private Date flightDate;
	private Integer numberOfEconomySeats;
	private Integer numberOfBusinessSeats;
	private String status;
	private String basicPrice;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Flight() {
	}

	public Flight(String flightId, Aircraft aircraft, Airport airport) {
		this.flightId = flightId;
		this.aircraft = aircraft;
		this.airport = airport;
	}

	public Flight(String flightId, Aircraft aircraft, Airport airport, Date takeOffTime, String destinationId,
			Date landingTime, Date flightDate, Integer numberOfEconomySeats, Integer numberOfBusinessSeats,
			String status, String basicPrice, Set<Ticket> tickets) {
		this.flightId = flightId;
		this.aircraft = aircraft;
		this.airport = airport;
		this.takeOffTime = takeOffTime;
		this.destinationId = destinationId;
		this.landingTime = landingTime;
		this.flightDate = flightDate;
		this.numberOfEconomySeats = numberOfEconomySeats;
		this.numberOfBusinessSeats = numberOfBusinessSeats;
		this.status = status;
		this.basicPrice = basicPrice;
		this.tickets = tickets;
	}

	@Id

	@Column(name = "Flight_ID", unique = true, nullable = false, length = 10)
	public String getFlightId() {
		return this.flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Aircraft_ID", nullable = false)
	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Departure_ID", nullable = false)
	public Airport getAirport() {
		return this.airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "TakeOffTime", length = 8)
	public Date getTakeOffTime() {
		return this.takeOffTime;
	}

	public void setTakeOffTime(Date takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	@Column(name = "Destination_ID", length = 100)
	public String getDestinationId() {
		return this.destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "LandingTime", length = 8)
	public Date getLandingTime() {
		return this.landingTime;
	}

	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FlightDate", length = 10)
	public Date getFlightDate() {
		return this.flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	@Column(name = "NumberOfEconomySeats")
	public Integer getNumberOfEconomySeats() {
		return this.numberOfEconomySeats;
	}

	public void setNumberOfEconomySeats(Integer numberOfEconomySeats) {
		this.numberOfEconomySeats = numberOfEconomySeats;
	}

	@Column(name = "NumberOfBusinessSeats")
	public Integer getNumberOfBusinessSeats() {
		return this.numberOfBusinessSeats;
	}

	public void setNumberOfBusinessSeats(Integer numberOfBusinessSeats) {
		this.numberOfBusinessSeats = numberOfBusinessSeats;
	}

	@Column(name = "Status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "BasicPrice", length = 16777215)
	public String getBasicPrice() {
		return this.basicPrice;
	}

	public void setBasicPrice(String basicPrice) {
		this.basicPrice = basicPrice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}