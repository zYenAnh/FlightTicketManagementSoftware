package entities;

import java.util.ArrayList;

import dataAccessObject.EmployeeDAO;

public class EmployeeModel {
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
	
	public void insert(Employee emp) {
		this.employees.add(emp);
	}
	
	public void remove(Employee emp) {
		int i;
		for(i=0;i<employees.size();i++) {
			if(employees.get(i).getEmployeeId()==emp.getEmployeeId()) {
				break;
			}
		}
		this.employees.remove(i);
	}
	
	public void update(Employee student) {
//		int i;
//		for(i=0;i<this.dsSinhVien.size();i++) {
//			if(this.dsSinhVien.get(i).getMaSinhVienInt()==student.getMaSinhVienInt())
//				break;
//		}
//		this.dsSinhVien.remove(i);
//		this.dsSinhVien.add(student);
	}

	public boolean kiemTraStudentTonTai(Employee st) {
//		for(Employee student: this.dsSinhVien) {
//			if(student.getMaSinhVienInt() == st.getMaSinhVienInt())
//				return true;
//		}
		return false;
	}
	
}
