package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Customer;

public interface CustomerDAO extends Remote{
	public boolean addCustomer(Customer customer) throws RemoteException;
	public boolean udateCustomer(Customer customer) throws RemoteException;
	public boolean deleteCustomer(String customerID) throws RemoteException;
	public Customer getCustomerById(String customerID) throws RemoteException;
	public List<Customer> getCustomerByName(String customerName) throws RemoteException;
	public List<Customer> getListCustomers() throws RemoteException;
	public String generateCustomerID() throws RemoteException;
}
