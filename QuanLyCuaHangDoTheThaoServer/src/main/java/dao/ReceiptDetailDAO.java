package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ReceiptDetail;

public interface ReceiptDetailDAO extends Remote{
	public boolean addReceiptDetail(ReceiptDetail receiptDetail) throws RemoteException;
	public boolean deleteReceiptDetail(String receiptDetailID) throws RemoteException;
	public ReceiptDetail getReceiptDetailById(String receiptDetailID) throws RemoteException;
	public List<ReceiptDetail> getListReceiptDetailts() throws RemoteException;
	public List<ReceiptDetail> getListReceiptDetailtsByID(String receiptID) throws RemoteException;
}
