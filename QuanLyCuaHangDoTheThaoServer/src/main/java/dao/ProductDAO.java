package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Product;

public interface ProductDAO extends Remote{
	public boolean addProduct(Product product) throws RemoteException;
	public boolean udateProduct(Product product) throws RemoteException;
	public boolean deleteProduct(String productID) throws RemoteException;
	public Product getProductById(String productID) throws RemoteException;
	public List<Product> getProductByName(String productName) throws RemoteException;
	public List<Product> getListProducts() throws RemoteException;
	public String generateProductID() throws RemoteException;
	public String getNameSupplierById(String supplierID) throws RemoteException;
	public String getNameProductTypeByID(String productTypeID) throws RemoteException;
}
