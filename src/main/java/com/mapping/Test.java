package com.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee= new Employee();
		employee.setName("dhiraj");
		
		Employee employee1= new Employee();
		employee1.setName("bhagwat");
		
		Project project= new Project();
		project.setName("insurance");
		
		Project project1= new Project();
		project1.setName("banking");
		List<Employee> empList= new ArrayList<>();
		empList.add(employee);
		empList.add(employee1);
		
		List<Project> proList = new ArrayList<>();
		proList.add(project);
		proList.add(project1);
		
		 employee.setProjects(proList);
		 project.setEmployees(empList);
		 
		session.save(employee);
		session.save(employee1);

		session.save(project);
		session.save(project1);

		//transaction.commit();
        session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		
		
	}

}
