package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.ProductTypeDAO;
import dao.StaffDAO;
import dao.SupplierDAO;
import daoImpl.CustomerDAOImpl;
import daoImpl.ProductDAOImpl;
import daoImpl.ProductTypeDAOImpl;
import daoImpl.StaffDAOImpl;
import daoImpl.SupplierDAOImpl;

public class Server {
	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			String ip = "192.168.100.15";
			String port = "9999";
			
			LocateRegistry.createRegistry(9999);
			CustomerDAO customerDAO = new CustomerDAOImpl();
			StaffDAO staffDAO = new StaffDAOImpl();
			SupplierDAO supplierDAO = new SupplierDAOImpl();
			ProductTypeDAO productTypeDAO = new ProductTypeDAOImpl();
			ProductDAO productDAO = new ProductDAOImpl();
			
			Naming.bind("rmi://" + ip + ":" + port + "/customerDAO", customerDAO);
			Naming.bind("rmi://" + ip + ":" + port + "/staffDAO", staffDAO);
			Naming.bind("rmi://" + ip + ":" + port + "/supplierDAO", supplierDAO);
			Naming.bind("rmi://" + ip + ":" + port + "/productTypeDAO", productTypeDAO);
			Naming.bind("rmi://" + ip + ":" + port + "/productDAO", productDAO);
			
			System.out.println("Server ready");
			
		}catch (Exception e) {
			
		}
	}
}
