package com.insertmain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homewokr.entities.CustomerEntity;
import com.homewokr.entities.DriverEntity;
import com.homewokr.entities.PolicyEntity;
import com.homewokr.entities.VehicleEntity;
import com.homework.repositories.CustomerRepository;
import com.homework.repositories.PolicyRepository;

public class PolicyInsertMain {

	public static void main(String[] args) {

		ApplicationContext ap = new ClassPathXmlApplicationContext("homework.xml");

		PolicyRepository pr = (PolicyRepository) ap.getBean("policyRepository");
		CustomerRepository cr = (CustomerRepository) ap.getBean("customerRepository");
		CustomerEntity cu = cr.getById(1);
		PolicyEntity policyentity = new PolicyEntity();

		policyentity.setPolicyNo("B87879");
		policyentity.setPolicyType("Auto");
		policyentity.setStartDate("2019-06-12");
		policyentity.setExpiration("2020-12-10");
		policyentity.setPrice("$250");
		policyentity.setCustomer(cu);

		pr.saveInfo(policyentity);

		PolicyEntity p = pr.getById(1);

		System.out.println(p.toString());

		DriverEntity driverentity = new DriverEntity();

		driverentity.setActive(true);
		driverentity.setFirstName("Chris");
		driverentity.setLastName("Mango");
		driverentity.setLicenceNo("Y990989");
		driverentity.setLicenceState("MD");
		driverentity.setPolicy(p);

		pr.addDriver(driverentity);

		VehicleEntity vehicleentity = new VehicleEntity();

		vehicleentity.setActive(true);
		vehicleentity.setColor("Black");
		vehicleentity.setMake("Jeep");
		vehicleentity.setModel("SRT");
		vehicleentity.setVinNo("VIN9989876");
		vehicleentity.setYear(2018);
		vehicleentity.setPolicy(p);

		pr.addVehicle(vehicleentity);

		List<VehicleEntity> v = pr.getbyYear(2018);

		System.out.println(v.toString());

	}

}
