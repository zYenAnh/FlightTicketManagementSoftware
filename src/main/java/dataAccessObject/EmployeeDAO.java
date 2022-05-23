package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import antlr.collections.List;
import entities.Employee;

public class EmployeeDAO implements DAOInterface<Employee>{
	
	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}

	@Override
	public int add(Employee t) {
		return 0;
	}

	@Override
	public int update(Employee t) {
		return 0;
	}

	@Override
	public int delele(Employee t) {
		return 0;
	}

	@Override
	public java.util.List<Employee> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            java.util.List<Employee> resultSelect = session.createQuery("FROM Employee",Employee.class)
            		.list();
            session.getTransaction().commit();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee selectById(Employee t) {
		return null;
	}

	@Override
	public ArrayList<Employee> selectByCondition(String condition) {
		return null;
	}

}
