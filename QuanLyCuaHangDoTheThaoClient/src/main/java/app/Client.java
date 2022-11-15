package app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProductTypeDAO;
import dao.ReceiptDAO;
import dao.ReceiptDetailDAO;
import dao.StaffDAO;
import dao.SupplierDAO;
import gui.DangNhapGUI;
import gui.MainGUI;


public class Client {	
	private String ip = "DESKTOP-4T18TEM";
	private int port = 9999;
	private CustomerDAO customerDAO;
	private SupplierDAO supplierDAO;
	private StaffDAO staffDAO;
	private ProductTypeDAO productTypeDAO;
	private ProductDAO productDAO;
	private AccountDAO accountDAO;
	private ReceiptDAO receiptDAO;
	private ReceiptDetailDAO receiptDetailDAO;
	
	public static void main(String[] args) throws IOException {
//		MainGUI mainGUI = new MainGUI();
//		mainGUI.setVisible(true);
		DangNhapGUI dangNhapGUI = new DangNhapGUI();
		dangNhapGUI.setVisible(true);
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
	
	public AccountDAO getAccountDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(accountDAO == null)
			accountDAO = (AccountDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/accountDAO");
		return this.accountDAO;
	}
	
	public ReceiptDAO getReceiptDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(receiptDAO == null)
			receiptDAO = (ReceiptDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/receiptDAO");
		return this.receiptDAO;
	}
	
	public ReceiptDetailDAO getReceiptDetailDAO() throws MalformedURLException, RemoteException, NotBoundException {
		if(receiptDetailDAO == null)
			receiptDetailDAO = (ReceiptDetailDAO) Naming.lookup("rmi://"+ ip +":"+ port +"/receiptDetailDAO");
		return this.receiptDetailDAO;
	}
}
