package entities;

import java.util.ArrayList;

import dataAccessObject.EmployeeDAO;

public class EmployeeModel implements ModelInterface<Employee>{
	private ArrayList<Employee> employees;
	
	public EmployeeModel() {
		this.employees = new ArrayList<Employee>();
		this.employees = EmployeeDAO.getInstance().selectIsActive();
	}
	
	public EmployeeModel(ArrayList<Employee> listEmp) {
		super();
		this.employees = listEmp;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> listEmp) {
		this.employees = listEmp;
	}
	
	@Override
	public void insert(Employee emp) {
		this.employees.add(emp);
	}
	
	@Override
	public void remove(Employee emp) {
		int i;
		for(i=0;i<employees.size();i++) {
			if(employees.get(i).getEmployeeId()==emp.getEmployeeId()) {
				break;
			}
		}
		this.employees.remove(i);
	}
	
	@Override
	public void update(Employee student) {
	}

	@Override
	public boolean checkExists(Employee t) {
		return false;
	}
	
	public Employee searchEmployeeById(int Id) {
		for(Employee e: employees) {
			if(e.getEmployeeId() == Id)
				return e;
		}
		return null;
	}
}
