package dataAccessObject;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import antlr.collections.List;
import entities.Account;
import entities.Employee;

public class EmployeeDAO implements DAOInterface<Employee>{
	
	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}

	@Override
	public int add(Employee t) {
		int result =0;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = (Integer) session.save(t);
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
        }
		return result;
	}

	@Override
	public void update(Employee t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            System.out.println("toi dayyyyyyyyy");
            session.update(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public void delele(Employee t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(t.getAccounts());
            session.delete(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public java.util.List<Employee> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            java.util.List<Employee> resultSelect = session.createQuery("FROM Employee",Employee.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee selectById(Employee t) {
		Employee result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Employee.class, t.getEmployeeId());
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> selectByCondition(String condition) {
		return null;
	}

	@Override
	public int saveOrUpdate(Employee t) {
		return 0;
	}

}
