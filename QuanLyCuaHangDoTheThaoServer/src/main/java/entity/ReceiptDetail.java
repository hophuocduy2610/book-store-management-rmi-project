package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ReceiptDetailPK.class)
public class ReceiptDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 157015851742859362L;

	@Id
	@ManyToOne
	@JoinColumn(name = "receiptID")
	private Receipt receipt;

	@Id
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;

	private int quantity;

	@Column(columnDefinition = "MONEY")
	private double unitPrice;

	@Column(columnDefinition = "MONEY")
	private double amount;
	
	@Column(columnDefinition = "BIT")
	private int status;

	public ReceiptDetail() {
	}

	public ReceiptDetail(Receipt receipt, Product product, int quantity, double unitPrice, double amount, int status) {
		this.receipt = receipt;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.status = status;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReceiptDetail [receipt=" + receipt + ", product=" + product + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", amount=" + amount + ", status=" + status + "]";
	}
}
