package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "ProductType")
public class ProductType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6800632186237265236L;

	@Id
	@Column(name= "productTypeID")
	private String id;
	
	@Column(name= "name", columnDefinition = "NVARCHAR(200)")
	private String name;
	
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products;
	
	@Column(columnDefinition = "BIT")
	private int status;

	public ProductType() {
		super();
	}
	
	public ProductType(String id) {
		super();
		this.id = id;
	}

	public ProductType(String id, String name, List<Product> products, int status) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
		this.status = status;
	}

	public ProductType(String id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", products=" + products + ", status=" + status + "]";
	}

}
