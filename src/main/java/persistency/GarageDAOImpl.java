package persistency;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Garage;

public class GarageDAOImpl implements IGarageDAO{

	public void insertGarage( Garage iGarage ) throws HibernateException {

		 // Create the SessionFactory from hibernate.cfg.xml
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	     try{

	         Transaction transaction = session.beginTransaction();
	         session.merge( iGarage );
	         transaction.commit();

	     } catch ( HibernateException e ) {
	    	 throw new HibernateException( e.getMessage() );        
	     }
	}

	public Garage getGarage( int iId ) throws HibernateException {

		 // Create the SessionFactory from hibernate.cfg.xml
		 Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	     try{
	         session.beginTransaction();

	         // From Garage -> class mapped in configuration
	         Query query = session.createQuery("FROM Garage WHERE id_hotel = :id_hotel");
	         query.setParameter("id_hotel", iId);

	         List<?> lQuery = query.list();
	         return (Garage) lQuery.get(0);

	     } catch (HibernateException e) {
	    	 throw new HibernateException(e.getMessage());        
	     }
	}

	public Garage getGarageByCity( String iCity ) throws HibernateException {

   	 	// Create the SessionFactory from hibernate.cfg.xml
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	    try{
	         session.beginTransaction();

	         // From Garage -> class mapped in configuration
	         Query query = session.createQuery("FROM Garage WHERE city = :city");
	         query.setParameter("city", iCity);

	         List<?> lQuery = query.list();
	         Garage oG = (Garage) lQuery.get(0);
	         return oG;

	     } catch (HibernateException e) {
	    	 throw new HibernateException(e.getMessage());
	     } catch (IndexOutOfBoundsException ioobe) {
	    	 // Protecting from empty list - returning null
	    	 return null;
	     }
	}
}
