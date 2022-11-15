package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Staff")
public class Staff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6878190034772833539L;

	@Id
	@Column(name= "staffID")
	private String id;
	
	@Column(name= "name", columnDefinition = "NVARCHAR(200)")
	private String name;
	
	@Column(name= "date_of_birth",columnDefinition = "Date")
	private Date dateOfBirth;
	
	@Column(name= "gender", columnDefinition = "NVARCHAR(15)")
	private String gender;
	
	@Column(name= "phone", columnDefinition = "VARCHAR(15)")
	private String phone;
	
	@Column(name= "position", columnDefinition = "NVARCHAR(50)")
	private String position;
	
	@Embedded
	private Address address;
	
	@Column(columnDefinition = "BIT")
	private int status;
	
	public Staff() {
		super();
	}

	public Staff(String id, String name, Date dateOfBirth, String gender, String phone,
			String position, Address address, int status) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.position = position;
		this.address = address;
		this.status = status;
	}

	public Staff(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				 + ", phone=" + phone + ", position=" + position + ", address="
				+ address + ", status=" + status + "]";
	}
}
