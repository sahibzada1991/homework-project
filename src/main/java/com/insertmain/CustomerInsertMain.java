package com.insertmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homewokr.entities.AddressEntity;
import com.homewokr.entities.CustomerEntity;
import com.homework.repositories.CustomerRepository;

public class CustomerInsertMain {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("homework.xml");

		CustomerRepository cr = (CustomerRepository) ac.getBean("customerRepository");

		CustomerEntity customerentity = new CustomerEntity();

		customerentity.setFirstName("Shawn");
		customerentity.setLastName("Dwain");
		customerentity.setDob("01/12/1887");
		customerentity.setEmail("shwn.dwain@gmail.com");
		customerentity.setGender("Male");
		customerentity.setLastFourSsn("0077");
		customerentity.setPhone(799898789);

		cr.saveCustomer(customerentity);

		AddressEntity address = new AddressEntity();

		address.setStreet("9998 shelburne terr");
		address.setCity("Gaithersburg");
		address.setState("MD");
		address.setZipcode(22903);
		address.setType("Residentional");
		address.setCustomer(customerentity);

		cr.saveAddress(address);

	}

}
