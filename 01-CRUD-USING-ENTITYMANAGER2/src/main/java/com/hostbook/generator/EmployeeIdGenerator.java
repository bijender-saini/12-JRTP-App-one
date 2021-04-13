package com.hostbook.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "ITL";
		// String dte = new SimpleDateFormat("ddMMMyy").format(new //
		// Date(System.currentTimeMillis()));
		int random = Math.abs(new Random().nextInt(99999999));

		// return prefix+"/"+dte+"/"+random;

		return prefix+random; 
		
	}

	}

