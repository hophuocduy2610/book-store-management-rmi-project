package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Account;

public interface AccountDAO extends Remote{
	public boolean addAccount(Account account) throws RemoteException;
	public boolean updateAccount(Account account) throws RemoteException;
	public boolean deleteAccount(String accountID) throws RemoteException;
	public Account getAccountById(String accountID) throws RemoteException;
	public Account getAccountByName(String accountName) throws RemoteException;
	public List<Account> getListAccounts() throws RemoteException;
	public String generateUsernameByStaffID(String staffID) throws RemoteException;
	public boolean isExistAccount(String username, String password) throws RemoteException;
}
