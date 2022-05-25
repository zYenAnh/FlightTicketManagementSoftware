package dataAccessObject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Account;

public class AccountDAO implements DAOInterface<Account>{

	public static AccountDAO getInstance() {
		return new AccountDAO();
	}
	
	@Override
	public int add(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Account t) {
	}

	@Override
	public void delele(Account t) {
	}

	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectById(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectByCondition(String condition) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Account WHERE " +condition;
            List<Account> resultSelect = session.createQuery(hql).list();
            session.getTransaction().commit();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int saveOrUpdate(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
