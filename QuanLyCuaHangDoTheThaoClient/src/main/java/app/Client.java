package app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProductTypeDAO;
import dao.StaffDAO;
import dao.SupplierDAO;
import gui.MainGUI;

public class Client {	
	private String ip = "192.168.100.15";
	private int port = 9999;
	private CustomerDAO customerDAO;
	private SupplierDAO supplierDAO;
	private StaffDAO staffDAO;
	private ProductTypeDAO productTypeDAO;
	private ProductDAO productDAO;
	
	public static void main(String[] args) throws IOException {
		MainGUI mainGUI = new MainGUI();
		mainGUI.setVisible(true);
	}	
	
	@SuppressWarnings({ "removal", "deprecation" })
	public Client() {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
	}
	
	public CustomerDAO getCustomerDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(customerDAO == null)
			customerDAO = (CustomerDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/customerDAO");
		return this.customerDAO;
	}
	
	public SupplierDAO getSupplierDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(supplierDAO == null)
			supplierDAO = (SupplierDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/supplierDAO");
		return this.supplierDAO;
	}
	
	public StaffDAO getStaffDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(staffDAO == null)
			staffDAO = (StaffDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/staffDAO");
		return this.staffDAO;
	}
	
	public ProductTypeDAO getProductTypeDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(productTypeDAO == null)
			productTypeDAO = (ProductTypeDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/productTypeDAO");
		return this.productTypeDAO;
	}
	
	public ProductDAO getProductDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(productDAO == null)
			productDAO = (ProductDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/productDAO");
		return this.productDAO;
	}
}
