package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Supplier;

public interface SupplierDAO extends Remote{
	public boolean addSupplier(Supplier supplier) throws RemoteException;
	public boolean updateSupplier(Supplier supplier) throws RemoteException;
	public boolean deleteSupplier(String supplierID) throws RemoteException;
	public Supplier getSupplierById(String supplierID) throws RemoteException;
	public List<Supplier> getSupplierByName(String supplierName) throws RemoteException;
	public List<Supplier> getListSuppliers() throws RemoteException;
	public String generateSupplierID() throws RemoteException;
	public String getNameSupplierById(String supplierID) throws RemoteException;
	public String getIDSupplierByName(String supplierName) throws RemoteException;
}
