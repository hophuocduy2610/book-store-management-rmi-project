package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2727862912427815447L;

	@Id
	@Column(name= "productID")
	private String id;
	
	@Column(name= "name", columnDefinition = "NVARCHAR(250)")
	private String name;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price", columnDefinition = "MONEY")
	private double price;
	
	private Date importDate;
	
	@ManyToOne
	@JoinColumn(name= "type_id")
	private ProductType productType;
	
	@ManyToOne
	@JoinColumn(name= "supplier_id")
	private Supplier supplier;
	
	@Column(columnDefinition = "BIT")
	private int status;
	

	public Product() {
		super();
	}

	public Product(String id, String name, int quantity, double price, Date importDate, ProductType productType,
			Supplier supplier, int status) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.importDate = importDate;
		this.productType = productType;
		this.supplier = supplier;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getImportDate() {
		return importDate;
	}


	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", productType="
				+ productType + ", supplier=" + supplier + ", status=" + status + "]";
	}
}
