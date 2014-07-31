package main;

import persistency.GarageDAOImpl;
import persistency.HibernateUtils;
import persistency.IGarageDAO;
import entity.Garage;

public class Main {

	public static void main( String args[] ) {

		// Creating random instances to store in the database
		Garage gMad = new Garage();
		gMad.setCity( "Madrid" );
		gMad.setName( "SEAT" );
		gMad.setIsOfficial(true);

		Garage gBar = new Garage();
		gBar.setCity( "Barcelona" );
		gBar.setName( "La Rueda" );

		Garage gSev = new Garage();
		gSev.setCity( "Sevilla" );
		gSev.setName( "Sevilla Sur" );

		IGarageDAO lGDI = new GarageDAOImpl();
		System.out.println( "Insert garages" );

		// Inserts to database
		lGDI.insertGarage( gMad );
		lGDI.insertGarage( gBar );
		lGDI.insertGarage( gSev );

		// Retrieving from Database
		Garage gs = lGDI.getGarageByCity( "Sevilla" );
		if ( null != gs )
			System.out.println( "Garage Id: " + gs.getId() + ", name: " + gs.getName() + " ( " + gs.getCity() + " )");
		else
			System.out.println("Query did not resolved to a value");

		// Finish session factory: terminate program
		HibernateUtils.closeSessionFactory();
	}
}
