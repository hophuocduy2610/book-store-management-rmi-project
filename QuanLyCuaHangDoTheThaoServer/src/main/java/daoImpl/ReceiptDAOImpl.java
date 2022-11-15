package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.ReceiptDAO;
import entity.Receipt;
import util.HibernateUtil;

public class ReceiptDAOImpl extends AbstractDAOImpl implements ReceiptDAO{

	protected EntityManager em;

	public ReceiptDAOImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3282388203039795679L;

	public boolean addReceipt(Receipt receipt) throws RemoteException {
		// TODO Auto-generated method stub
		return add(receipt);
	}

	public boolean deleteReceipt(String receiptID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(receiptID, Receipt.class);
	}

	public Receipt getReceiptById(String receiptID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Receipt WHERE receiptID = '" + receiptID + "'";
		return (Receipt) getSingle(sql, Receipt.class);
	}

	@SuppressWarnings("unchecked")
	public List<Receipt> getListReceipts() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Receipt";
		return (List<Receipt>) getList(sql, Receipt.class);
	}

	public String generateReceiptID() throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countReceipt();
		String receiptId = "HD";
		
		if (rowCount == 99) {
			receiptId = receiptId + (rowCount + 1);
		} else if (rowCount == 9) {
			receiptId = receiptId + "0" + (rowCount + 1);
		} else {
			receiptId = receiptId + "00" + (rowCount + 1);
		}

		return receiptId;
	}
	
	public int countReceipt() {
		String sql = "SELECT COUNT(*) FROM Receipt";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}
}
