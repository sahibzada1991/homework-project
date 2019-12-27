package com.homework.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.homewokr.entities.AddressEntity;
import com.homewokr.entities.CustomerEntity;

public class CustomerRepository {

	private SessionFactory sessionFactory;

	public void saveCustomer(CustomerEntity customer) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(customer);

		session.getTransaction().commit();
		session.close();

	}

	public CustomerEntity getById(long id) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		CustomerEntity customerentity = (CustomerEntity) session.get(CustomerEntity.class, id);
		session.getTransaction().commit();
		session.close();

		return customerentity;
	}

	public void saveAddress(AddressEntity address) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(address);

		session.getTransaction().commit();
		session.close();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
