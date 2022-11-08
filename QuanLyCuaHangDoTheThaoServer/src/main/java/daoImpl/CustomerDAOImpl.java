package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.CustomerDAO;
import entity.Customer;
import util.HibernateUtil;

public class CustomerDAOImpl extends AbstractDAOImpl implements CustomerDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2500497067965603227L;
	
	protected EntityManager em;

	public CustomerDAOImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addCustomer(Customer customer) throws RemoteException {
		return add(customer);
	}

	public boolean udateCustomer(Customer customer) throws RemoteException {
		// TODO Auto-generated method stub
		return update(customer);
	}

	public boolean deleteCustomer(String customerID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(customerID, Customer.class);
	}

	public Customer getCustomerById(String customerID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Customer WHERE customerID = '" + customerID + "'";
		return (Customer) getSingle(sql, Customer.class);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByName(String customerName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Customer WHERE name = '" + customerName + "'";
		return (List<Customer>) getList(sql, Customer.class);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getListCustomers() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Customer";
		return (List<Customer>) getList(sql, Customer.class);
	}

	// Tạo mã tự động cho khách hàng
	public String generateCustomerID() throws RemoteException {
		
		int rowCount = countCustomer();
		String customerId = "KH";
		
		if (rowCount == 99) {
			customerId = customerId + (rowCount + 1);
		} else if (rowCount == 9) {
			customerId = customerId + "0" + (rowCount + 1);
		} else {
			customerId = customerId + "00" + (rowCount + 1);
		}

		return customerId;
	}

	public int countCustomer() {
		String sql = "SELECT COUNT(*) FROM Customer";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}
}
