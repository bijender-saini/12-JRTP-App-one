package com.hostbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hostbook.domain.Employee;
import com.hostbook.dto.EmployeeDTO;

@Repository
public class EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	public Employee saveEmployee(Employee employee) {

		Session session = entityManager.unwrap(Session.class);
		Transaction tx = session.beginTransaction();

		try {
			entityManager.persist(employee);
			session.close();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	public Employee updateEmployee(String id, Employee emp) {
		Session session = entityManager.unwrap(Session.class);
		Transaction tx = session.beginTransaction();
		Employee employee = null;
		try {
			employee = entityManager.merge(emp);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return employee;
	}

	public Employee deleteEmployee(String id) {
		Session session = entityManager.unwrap(Session.class);
		Transaction tx = session.beginTransaction();
		Employee employee = null;
		try {
			employee = entityManager.find(Employee.class, id);

			entityManager.remove(employee);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return employee;

	}

	public Employee getEmployee(String id) {
		Employee employee = null;

		try {
			employee = entityManager.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;

	}

	public List<Object> getAllEmployee() {
		List<Object> resultList = null;
		try {

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Object> createQuery = criteriaBuilder.createQuery();
			Root<Employee> employee = createQuery.from(Employee.class);

			CriteriaQuery<Object> select = createQuery.select(employee);
			TypedQuery<Object> createQuery2 = entityManager.createQuery(select);
			resultList = createQuery2.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultList;

	}

	public List<Employee> getEmployeeByBranchName(String department) {

		List<Employee> resultList = null;
		try {
			
			  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			  CriteriaQuery<Employee> createQuery =
			  criteriaBuilder.createQuery(Employee.class); Root<Employee> employee =
			  createQuery.from(Employee.class); createQuery.select(employee);
			  
			  createQuery.where(criteriaBuilder.equal(employee.get("employeeDepartment"),
			  department));
			  
			  resultList = entityManager.createQuery(createQuery).getResultList();
			 

			//resultList=entityManager.createQuery("select e.employeeName from Employee e where employeeDepartment=?1").setParameter(1,department).getResultList();
			
			//resultList=entityManager.createQuery("from Employee e where e.employeeDepartment=?1").setParameter(1, department).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
