package entities;
// Generated May 28, 2022, 3:41:14 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "flightticketmanagementdatabase")
public class Account implements java.io.Serializable {

	private String username;
	private Employee employee;
	private String password;
	private String role;
	private Integer isActive;

	public Account() {
		this.isActive =1;
	}

	public Account(String username, Employee employee, String password) {
		this.username = username;
		this.employee = employee;
		this.password = password;
	}

	public Account(String username, Employee employee, String password, String role, Integer isActive) {
		this.username = username;
		this.employee = employee;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}

	@Id

	@Column(name = "Username", unique = true, nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Employee_ID", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "Password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Role", length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "isActive")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
