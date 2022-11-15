package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1597650198828382371L;

	@Id
	@Column(name = "customerID")
	private String id;

	@Column(name = "name", columnDefinition = "NVARCHAR(200)")
	private String name;

	@Column(name = "gender", columnDefinition = "NVARCHAR(10)")
	private String gender;

	@Column(name = "phone", columnDefinition = "VARCHAR(15)")
	private String phone;

	@Column(name = "email", columnDefinition = "VARCHAR(100)")
	private String email;

	@Embedded
	private Address address;

	@Column(columnDefinition = "BIT")
	private int status;

	public Customer() {
		super();
	}

	// Constructor đầy đủ tham số
	public Customer(String id, String name, String gender, String phone, String email, Address address, int status) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
	}

	// Constructor dành cho cập nhật
	public Customer(String id, String name, String gender, String phone, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Customer(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", status=" + status + "]";
	}
}
