package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sun.istack.internal.NotNull;

@Entity
public class Garage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Id is going to be generated automatically
	@Id
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq")
	@Column(name="ID_HOTEL")
	private int mIdGarage;

	@NotNull
	@Column(name="NAME")
	private String mName;

	@NotNull
	@Column(name="CITY")
	private String mCity;

	@Column(name="OWNER")
	private String mOwner;

	@Column(name="OFICIAL")
	private boolean mIsOfficial;

	@Column(name="CAPACITY")
	private long mCapacity;

	public void setId( int id ) {
		this.mIdGarage = id;
	}

	public int getId() {
		return this.mIdGarage;
	}

	public void setCity( String name ) {
		this.mCity = name;
	}

	public String getCity() {
		return this.mCity;
	}

	public void setName( String name ) {
		this.mName = name;
	}

	public String getName() {
		return this.mName;
	}

	public void setIsOfficial( boolean iIsOfficial ) {
		this.mIsOfficial = iIsOfficial;
	}

}

