package com.tap.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.Entity.Employee;
import com.tap.dao.EmployeeDAO;

@Component("daoi")
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Employee e) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee getEmpById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session.get(Employee.class,id);
	}

	@Override
	public void updateEmp(Employee e) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    // Load existing employee
	    Employee existingEmp = session.get(Employee.class, e.getId());
	    if(existingEmp != null) {
	        existingEmp.setName(e.getName());
	        existingEmp.setEmail(e.getEmail());
	        session.update(existingEmp);
	    }

	    session.getTransaction().commit();
	    session.close();
	}


	@Override
	public List<Employee> fetchAll() {
	    String hql = "from Employee";
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    Query<Employee> query = session.createQuery(hql, Employee.class);
	    List<Employee> list = query.list();

	    session.getTransaction().commit();
	    session.close();

	    return list;
	}
	@Override
	public void deleteEmp(int id) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    // Load existing employee
	    Employee existingEmp = session.get(Employee.class, id);
	    if(existingEmp != null) {
	        session.delete(existingEmp);
	    }

	    session.getTransaction().commit();
	    session.close();
	}

}
