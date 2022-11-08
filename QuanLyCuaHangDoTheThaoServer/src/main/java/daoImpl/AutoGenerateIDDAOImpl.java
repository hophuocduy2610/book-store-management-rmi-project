//package daoImpl;
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//
//public class AutoGenerateIDDAOImpl extends UnicastRemoteObject{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2852158033338118642L;
//	
//	private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//	
//	
//	//Tạo mã tự động cho khách hàng
//	public String generateCustomerID() throws RemoteException {
//
//		String customerID = "KH";
//		int rowCount = customerDAO.countCustomer();
//
//		boolean dup = false;
//		do {
//			if (rowCount > 99) {
//				customerID = customerID + (rowCount + 1);
//			} else if (rowCount > 9) {
//				customerID = customerID + "0" + (rowCount + 1);
//			} else {
//				customerID = customerID + "00" + (rowCount + 1);
//			}
//		} while (dup);
//		return customerID;
//	}
//	
//	protected AutoGenerateIDDAOImpl() throws RemoteException {
//	}
//	
//	
//	
//}
