package dataAccessObject;

import java.util.ArrayList;
import java.util.List;


public interface DAOInterface<T> {
	public int add(T t);
	
	public int update(T t);
	
	public int delele(T t);
	
	public List<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
}
