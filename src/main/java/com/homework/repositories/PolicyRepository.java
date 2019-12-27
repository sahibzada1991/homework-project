package com.homework.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.homewokr.entities.DriverEntity;
import com.homewokr.entities.PolicyEntity;
import com.homewokr.entities.VehicleEntity;

public class PolicyRepository {

	private SessionFactory sessionFactory;

	public void saveInfo(PolicyEntity policy) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(policy);

		session.getTransaction().commit();

		session.close();

	}

	public PolicyEntity getById(long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		PolicyEntity policyentity = (PolicyEntity) session.get(PolicyEntity.class, id);

		session.getTransaction().commit();

		session.close();

		return policyentity;

	}

	public void addDriver(DriverEntity driver) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(driver);

		session.getTransaction().commit();

		session.close();

	}

	public void addVehicle(VehicleEntity vehicle) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vehicle);

		session.getTransaction().commit();

		session.clear();

	}

	public List<VehicleEntity> getbyYear(long year) {

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Query q = session.createQuery("select v from VehicleEntity v where v.year =:year");
		q.setParameter("year", year);

		List<VehicleEntity> ve = q.list();
		session.getTransaction().commit();
		session.close();

		return ve;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
