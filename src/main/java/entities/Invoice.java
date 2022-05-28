package entities;
// Generated May 28, 2022, 3:41:14 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Invoice generated by hbm2java
 */
@Entity
@Table(name = "invoice", catalog = "flightticketmanagementdatabase")
public class Invoice implements java.io.Serializable {

	private Integer invoiceId;
	private Customer customer;
	private Employee employee;
	private Date establishedDate;
	private String total;
	private Set<Invoicedetail> invoicedetails = new HashSet<Invoicedetail>(0);

	public Invoice() {
	}

	public Invoice(Customer customer, Employee employee) {
		this.customer = customer;
		this.employee = employee;
	}

	public Invoice(Customer customer, Employee employee, Date establishedDate, String total,
			Set<Invoicedetail> invoicedetails) {
		this.customer = customer;
		this.employee = employee;
		this.establishedDate = establishedDate;
		this.total = total;
		this.invoicedetails = invoicedetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Invoice_ID", unique = true, nullable = false)
	public Integer getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_ID", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Employee_ID", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EstablishedDate", length = 10)
	public Date getEstablishedDate() {
		return this.establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	@Column(name = "Total", length = 16777215)
	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
	public Set<Invoicedetail> getInvoicedetails() {
		return this.invoicedetails;
	}

	public void setInvoicedetails(Set<Invoicedetail> invoicedetails) {
		this.invoicedetails = invoicedetails;
	}

}
