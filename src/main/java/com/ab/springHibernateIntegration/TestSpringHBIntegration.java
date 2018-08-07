package com.ab.springHibernateIntegration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestSpringHBIntegration {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext   context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory  sessionFactory  = (SessionFactory) context.getBean("sessionFactory");
		Session  session  = sessionFactory.openSession();
		Transaction  tx = session.beginTransaction();
		
		Employee  employee = (Employee) context.getBean("employee");
		session.save(employee);
		
		Employee  employee1 = (Employee) context.getBean("employee1");
		session.save(employee1);
		
		session.flush();
		tx.commit();
		session.close();
	}//main
}//TestSpringHBIntegration
