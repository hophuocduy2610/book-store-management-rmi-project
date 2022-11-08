package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.ProductDAO;
import entity.Product;
import util.HibernateUtil;

public class ProductDAOImpl extends AbstractDAOImpl implements ProductDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -969103758701553505L;

	protected EntityManager em;

	public ProductDAOImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addProduct(Product product) throws RemoteException {
		// TODO Auto-generated method stub
		return add(product);
	}

	public boolean udateProduct(Product product) throws RemoteException {
		// TODO Auto-generated method stub
		return update(product);
	}

	public boolean deleteProduct(String productID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(productID, Product.class);
	}

	public Product getProductById(String productID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Product WHERE productID = '" + productID + "'";
		return (Product) getSingle(sql, Product.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByName(String productName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Product WHERE name = '" + productName + "'";
		return (List<Product>) getList(sql, Product.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getListProducts() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Product";
		return (List<Product>) getList(sql, Product.class);
	}

	public String generateProductID() throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countProduct();
		String productId = "SP";

		if (rowCount == 99) {
			productId = productId + (rowCount + 1);
		} else if (rowCount == 9) {
			productId = productId + "0" + (rowCount + 1);
		} else {
			productId = productId + "00" + (rowCount + 1);
		}

		return productId;
	}

	public int countProduct() {
		String sql = "SELECT COUNT(*) FROM Product";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}

	public String getNameSupplierById(String supplierID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT name FROM Supplier WHERE supplierID = '" + supplierID + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();
	}

	public String getNameProductTypeByID(String productTypeID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT name FROM ProductType WHERE productTypeID = '" + productTypeID + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();
	}
}
