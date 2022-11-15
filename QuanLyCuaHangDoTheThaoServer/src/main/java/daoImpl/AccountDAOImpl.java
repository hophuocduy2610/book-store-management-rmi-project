package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AccountDAO;
import entity.Account;
import util.HibernateUtil;

public class AccountDAOImpl extends AbstractDAOImpl implements AccountDAO{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9045102473280346707L;
	
	protected EntityManager em;
	
	public AccountDAOImpl() throws RemoteException{
		// TODO Auto-generated constructor stub
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addAccount(Account account) throws RemoteException {
		// TODO Auto-generated method stub
		return add(account);
	}

	public boolean updateAccount(Account account) throws RemoteException {
		// TODO Auto-generated method stub
		return update(account);
	}

	public boolean deleteAccount(String accountID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(accountID, Account.class);
	}

	public Account getAccountById(String accountID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Account WHERE staffID = '" + accountID + "'";
		return (Account) getSingle(sql, Account.class);
	}

	public Account getAccountByName(String accountName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Account WHERE username = '" + accountName + "'";
		return (Account) getSingle(sql, Account.class);
	}

	@SuppressWarnings("unchecked")
	public List<Account> getListAccounts() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Account";
		return (List<Account>) getList(sql, Account.class);
	}

	public String generateUsernameByStaffID(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countAccount();
		String username = staffID;
		
		if (rowCount == 99) {
			username = username + (rowCount + 1);
		} else if (rowCount == 9) {
			username = username + "0" + (rowCount + 1);
		} else {
			username = username + "00" + (rowCount + 1);
		}

		return username;
	}

	public int countAccount() {
		String sql = "SELECT COUNT(*) FROM Account";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}
	
	public boolean isExistAccount(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM Account WHERE userName = '" + username + "' AND passWord = '" + password + "'";
			if(em.createNativeQuery(sql).getSingleResult().equals(1)) {
				return true;
			}
			return false;
	}
}
