package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ProductType;

public interface ProductTypeDAO extends Remote{
	public boolean addProductType(ProductType productType) throws RemoteException;
	public boolean updateProductType(ProductType productType) throws RemoteException;
	public boolean deleteProductType(String productType) throws RemoteException;
	public ProductType getProductTypeByID(String productTypeID) throws RemoteException;
	public List<ProductType> getProductTypeByName(String productTypeName) throws RemoteException;
	public List<ProductType> getListProductTypes() throws RemoteException;
	public String generateProductTypeID() throws RemoteException;
	public String getNameProductTypeByID(String productTypeID) throws RemoteException;
	public String getIDProductTypeByName(String productTypeName) throws RemoteException;
}
