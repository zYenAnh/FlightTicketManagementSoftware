package entities;
// Generated Jun 1, 2022, 11:56:14 AM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Invoicedetail generated by hbm2java
 */
@Entity
@Table(name = "invoicedetail", catalog = "flightticketmanagementdatabase")
public class Invoicedetail implements java.io.Serializable {

	private InvoicedetailId id;
	private Invoice invoice;
	private Ticket ticket;
	private Integer quantity;

	public Invoicedetail() {
	}

	public Invoicedetail(InvoicedetailId id, Invoice invoice, Ticket ticket) {
		this.id = id;
		this.invoice = invoice;
		this.ticket = ticket;
	}

	public Invoicedetail(InvoicedetailId id, Invoice invoice, Ticket ticket, Integer quantity) {
		this.id = id;
		this.invoice = invoice;
		this.ticket = ticket;
		this.quantity = quantity;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "invoiceId", column = @Column(name = "Invoice_ID", nullable = false)),
			@AttributeOverride(name = "ticketId", column = @Column(name = "Ticket_ID", nullable = false)) })
	public InvoicedetailId getId() {
		return this.id;
	}

	public void setId(InvoicedetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Invoice_ID", nullable = false, insertable = false, updatable = false)
	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ticket_ID", nullable = false, insertable = false, updatable = false)
	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Column(name = "Quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
