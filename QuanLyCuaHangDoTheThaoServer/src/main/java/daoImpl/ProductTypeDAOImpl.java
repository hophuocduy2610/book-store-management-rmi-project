package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.ProductTypeDAO;
import entity.ProductType;
import util.HibernateUtil;

public class ProductTypeDAOImpl extends AbstractDAOImpl implements ProductTypeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6079574408850589119L;

	protected EntityManager em;

	public ProductTypeDAOImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addProductType(ProductType productType) throws RemoteException {
		// TODO Auto-generated method stub
		return add(productType);
	}

	public boolean updateProductType(ProductType productType) throws RemoteException {
		// TODO Auto-generated method stub
		return update(productType);
	}

	public boolean deleteProductType(String productType) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(productType, ProductType.class);
	}

	public ProductType getProductTypeByID(String productTypeID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ProductType WHERE productTypeID = '" + productTypeID + "'";
		return (ProductType) getSingle(sql, ProductType.class);

	}
	
	public String getNameProductTypeByID(String productTypeID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT name FROM ProductType WHERE productTypeID = '" + productTypeID + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();

	}
	
	@SuppressWarnings("unchecked")
	public List<ProductType> getProductTypeByName(String productTypeName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ProductType WHERE name = '" + productTypeName + "'";
		return (List<ProductType>) getList(sql, ProductType.class);
	}

	@SuppressWarnings("unchecked")
	public List<ProductType> getListProductTypes() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ProductType";
		return (List<ProductType>) getList(sql, ProductType.class);
	}

	public String generateProductTypeID() throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countProductType();
		String productTypeId = "LSP";
		
		if (rowCount == 99) {
			productTypeId = productTypeId + (rowCount + 1);
		} else if (rowCount == 9) {
			productTypeId = productTypeId + "0" + (rowCount + 1);
		} else {
			productTypeId = productTypeId + "00" + (rowCount + 1);
		}

		return productTypeId;
	}
	public int countProductType() {
		String sql = "SELECT COUNT(*) FROM ProductType";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}

	public String getIDProductTypeByName(String productTypeName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT productTypeID FROM ProductType WHERE name = N'" + productTypeName + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();
	}
}
