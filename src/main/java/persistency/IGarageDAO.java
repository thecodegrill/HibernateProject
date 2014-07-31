package persistency;

import entity.Garage;

public interface IGarageDAO {

	// Methods available - Garage
	public void insertGarage( Garage garage );
	public Garage getGarage( int iId );
	public Garage getGarageByCity( String iName );

}
