package entities;
// Generated May 28, 2022, 3:41:14 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoicedetailId generated by hbm2java
 */
@Embeddable
public class InvoicedetailId implements java.io.Serializable {

	private int invoiceId;
	private int ticketId;

	public InvoicedetailId() {
	}

	public InvoicedetailId(int invoiceId, int ticketId) {
		this.invoiceId = invoiceId;
		this.ticketId = ticketId;
	}

	@Column(name = "Invoice_ID", nullable = false)
	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "Ticket_ID", nullable = false)
	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InvoicedetailId))
			return false;
		InvoicedetailId castOther = (InvoicedetailId) other;

		return (this.getInvoiceId() == castOther.getInvoiceId()) && (this.getTicketId() == castOther.getTicketId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getInvoiceId();
		result = 37 * result + this.getTicketId();
		return result;
	}

}
