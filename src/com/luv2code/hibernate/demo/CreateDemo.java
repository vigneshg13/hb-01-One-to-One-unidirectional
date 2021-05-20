package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// Create a SessionFactory which is heavy weight object just needs to be created
		// at once and shared across the application.
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create a session from session factory. Session is created from session
		// factory and commit ur transaction and close it away
		Session session = factory.getCurrentSession();

		try {
			/*// create a Instructor Object via constructor
			Instructor tempInstructor = new Instructor("Paul", "Wilson", "paul.wilson@luv2code.com");

			// Create a Instructor Detail Object
			InstructorDetail tempDetail = new InstructorDetail("youtube.com/luv2Code", "Trekking");
*/
			// create a Instructor Object via constructor
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

			// Create a Instructor Detail Object
			InstructorDetail tempDetail = new InstructorDetail("youtube.com/learnwithmadhu", "Guitar");

			// Set the Instructor Detail object in Instructor Object - Associate the object
			tempInstructor.setInstructorDetail(tempDetail);

			// Start a hibernate transaction
			session.beginTransaction();

			// Save the Instructor
			// Note: This will save the Detail object as well because of CascadeType.ALL
			System.out.println("Saving Instructor..." + tempInstructor);
			session.save(tempInstructor);

			// commit the transaction for the session
			session.getTransaction().commit();

			System.out.println("Done!!!");
			String[] sample = new String[5];
			List<Integer> primList = new ArrayList<Integer>();
			for (i = start; i <= end; i++) {
				 
	            // Skip 0 and 1 as they are
	            // niether prime nor composite
	            if (i == 1 || i == 0)
	                continue;
	 
	            // flag variable to tell
	            // if i is prime or not
	            flag = 1;
	 
	            for (j = 2; j <= i / 2; ++j) {
	                if (i % j == 0) {
	                    flag = 0;
	                    break;
	                }
	            }
	 
	            // flag = 1 means i is prime
	            // and flag = 0 means i is not prime
	            if (flag == 1)
	                System.out.println(i);
	        }

		} finally {

			// finally close the factory object
			factory.close();
		}

	}

}
