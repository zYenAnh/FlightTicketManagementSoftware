package dataAccessObject;

import java.util.ArrayList;
import java.util.List;


public interface DAOInterface<T> {
	public int add(T t);
	
	public void update(T t);
	
	public void delele(T t);
	
	public int saveOrUpdate(T t);
	
	public List<T> selectAll();
	
	public T selectById(T t);
	
	public List<T> selectByCondition(String condition);
}
