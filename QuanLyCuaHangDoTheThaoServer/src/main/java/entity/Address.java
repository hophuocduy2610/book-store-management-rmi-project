package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5516857001193515313L;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String city;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String district;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String ward;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String address;
	
	public Address() {
		super();
	}

	public Address(String city, String district, String ward, String address) {
		super();
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", district=" + district + ", ward=" + ward + ", address=" + address + "]";
	}
	
	
}
