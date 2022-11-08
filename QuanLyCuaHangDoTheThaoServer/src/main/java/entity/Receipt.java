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
@Table(name= "Receipt")
public class Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1308064836662610654L;

	@Id
	@Column(name= "receiptID")
	private String receiptID;
	
	@ManyToOne
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "staffID")
	private Staff staff;
	
	@Column(name= "date", columnDefinition = "DATE")
	private Date date;
	
	@Column(name= "total", columnDefinition = "MONEY")
	private double totalPrice;
	
	@Column(name = "status", columnDefinition = "BIT")
	private int status;

	public Receipt() {
		super();
	}

	
	public Receipt(String id, Customer customer, Staff staff, Date date, double totalPrice, int status) {
		super();
		this.receiptID = id;
		this.customer = customer;
		this.staff = staff;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
	}


	public String getId() {
		return receiptID;
	}

	public void setId(String receiptID) {
		this.receiptID = receiptID;
	}

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Receipt [id=" + receiptID + ", customer=" + customer + ", staff=" + staff + ", date=" + date + ", totalPrice="
				+ totalPrice + ", status=" + status + "]";
	}

}
