package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Receipt;

public interface ReceiptDAO extends Remote{
	public boolean addReceipt(Receipt receipt) throws RemoteException;
	public boolean deleteReceipt(String receiptID) throws RemoteException;
	public Receipt getReceiptById(String receiptID) throws RemoteException;
	public List<Receipt> getListReceipts() throws RemoteException;
	public String generateReceiptID() throws RemoteException;
}
