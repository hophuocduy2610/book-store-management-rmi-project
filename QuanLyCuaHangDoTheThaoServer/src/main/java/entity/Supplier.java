package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Supplier")
public class Supplier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3364445644457060923L;

	@Id
	@Column(name= "supplierID")
	private String id;
	
	@Column(name= "name", columnDefinition = "NVARCHAR(200)")
	private String name;
	
	@Column(name= "phone", columnDefinition = "VARCHAR(15)")
	private String phone;
	
	@Column(name= "email", columnDefinition = "VARCHAR(50)")
	private String email;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products;
	
	@Column(columnDefinition = "BIT")
	private int status;
	
	public Supplier() {
		super();
	}

	public Supplier(String id) {
		super();
		this.id = id;
	}

	public Supplier(String id, String name, String phone, String email, Address address, List<Product> products,
			int status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.products = products;
		this.status = status;
	}

	public Supplier(String id, String name, String phone, String email, Address address, int status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", products=" + products + ", status=" + status + "]";
	}
}
