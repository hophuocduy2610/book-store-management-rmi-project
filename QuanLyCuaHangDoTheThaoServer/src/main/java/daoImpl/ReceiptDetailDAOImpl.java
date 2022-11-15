package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityTransaction;

import dao.ReceiptDetailDAO;
import entity.ReceiptDetail;

public class ReceiptDetailDAOImpl extends AbstractDAOImpl implements ReceiptDetailDAO{

	public ReceiptDetailDAOImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3457412700650715237L;

	public boolean addReceiptDetail(ReceiptDetail receiptDetail) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(receiptDetail);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();	
		}
		return false;
	}

	public boolean deleteReceiptDetail(String receiptDetailID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(receiptDetailID, ReceiptDetail.class);
	}

	public ReceiptDetail getReceiptDetailById(String receiptDetailID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ReceiptDetail WHERE receiptID = '" + receiptDetailID + "'";
		return (ReceiptDetail) getSingle(sql, ReceiptDetail.class);
	}

	@SuppressWarnings("unchecked")
	public List<ReceiptDetail> getListReceiptDetailts() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ReceiptDetail";
		return (List<ReceiptDetail>) getList(sql, ReceiptDetail.class);
	}

	@SuppressWarnings("unchecked")
	public List<ReceiptDetail> getListReceiptDetailtsByID(String receiptID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ReceiptDetail WHERE receiptID = '" + receiptID + "'";
		return  (List<ReceiptDetail>) getList(sql, ReceiptDetail.class);
	}
}
