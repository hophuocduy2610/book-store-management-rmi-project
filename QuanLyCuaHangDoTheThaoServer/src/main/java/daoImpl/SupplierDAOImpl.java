package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.SupplierDAO;
import entity.Supplier;
import util.HibernateUtil;

public class SupplierDAOImpl extends AbstractDAOImpl implements SupplierDAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5733717348414813393L;
	
	protected EntityManager em;

	public SupplierDAOImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addSupplier(Supplier supplier) throws RemoteException {
		// TODO Auto-generated method stub
		return add(supplier);
	}

	public boolean updateSupplier(Supplier supplier) throws RemoteException {
		// TODO Auto-generated method stub
		return update(supplier);
	}

	public boolean deleteSupplier(String supplierID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(supplierID, Supplier.class);
	}

	public Supplier getSupplierById(String supplierID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Supplier WHERE supplierID = '" + supplierID + "'";
		return (Supplier) getSingle(sql, Supplier.class);
	}
	
	public String getNameSupplierById(String supplierID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT name FROM Supplier WHERE supplierID = '" + supplierID + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getSupplierByName(String supplierName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Supplier WHERE name = '" + supplierName + "'";
		return (List<Supplier>) getList(sql, Supplier.class);
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getListSuppliers() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Supplier";
		return (List<Supplier>) getList(sql, Supplier.class);
	}

	public String generateSupplierID() throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countSupplier();
		String supplierId = "NCC";
		
		if (rowCount == 99) {
			supplierId = supplierId + (rowCount + 1);
		} else if (rowCount == 9) {
			supplierId = supplierId + "0" + (rowCount + 1);
		} else {
			supplierId = supplierId + "00" + (rowCount + 1);
		}

		return supplierId;
	}
	
	public int countSupplier() {
		String sql = "SELECT COUNT(*) FROM Supplier";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}

	public String getIDSupplierByName(String supplierName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT supplierID FROM Supplier WHERE name = N'" + supplierName + "'";
		return (String) em.createNativeQuery(sql).getSingleResult();
	}
	
}
