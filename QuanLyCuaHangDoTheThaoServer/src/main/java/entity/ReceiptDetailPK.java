package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ReceiptDetailPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8420211585486139860L;
	
	private Receipt receipt;
	private Product product;
	
	public ReceiptDetailPK() {
	}

	public ReceiptDetailPK(Receipt receipt, Product product) {
		super();
		this.receipt = receipt;
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(receipt, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiptDetailPK other = (ReceiptDetailPK) obj;
		return Objects.equals(receipt, other.receipt) && Objects.equals(product, other.product);
	}
	
}
