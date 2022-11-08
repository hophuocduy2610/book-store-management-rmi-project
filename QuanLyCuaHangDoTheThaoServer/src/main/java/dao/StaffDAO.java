package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.Staff;

public interface StaffDAO extends Remote{
	public boolean addStaff(Staff staff) throws RemoteException;
	public boolean updateStaff(Staff staff) throws RemoteException;
	public boolean deleteStaff(String staffID) throws RemoteException;
	public Staff getStaffById(String staffID) throws RemoteException;
	public List<Staff> getStaffByName(String staffName) throws RemoteException;
	public List<Staff> getListStaffs() throws RemoteException;
	public String generateStaffID() throws RemoteException;
}
