package daoImpl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.StaffDAO;
import entity.Staff;
import util.HibernateUtil;

public class StaffDAOImpl extends AbstractDAOImpl implements StaffDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2072867410544501232L;
	
	protected EntityManager em;
	
	public StaffDAOImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		em = HibernateUtil.getInstance().getEntityManager();

	}

	public boolean addStaff(Staff staff) throws RemoteException {
		// TODO Auto-generated method stub
		return add(staff);
	}

	public boolean updateStaff(Staff staff) throws RemoteException {
		// TODO Auto-generated method stub
		return update(staff);
	}

	public boolean deleteStaff(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		return delete(staffID, Staff.class);
	}

	public Staff getStaffById(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Staff WHERE staffID = '" + staffID + "'";
		return (Staff) getSingle(sql, Staff.class);
	}

	@SuppressWarnings("unchecked")
	public List<Staff> getStaffByName(String staffName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Staff WHERE name = '" + staffName + "'";
		return (List<Staff>) getList(sql, Staff.class);
	}

	@SuppressWarnings("unchecked")
	public List<Staff> getListStaffs() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Staff";
		return (List<Staff>) getList(sql, Staff.class);
	}

	public String generateStaffID() throws RemoteException {
		// TODO Auto-generated method stub
		int rowCount = countStaff();
		String staffId = "NV";
		
		if (rowCount == 99) {
			staffId = staffId + (rowCount + 1);
		} else if (rowCount == 9) {
			staffId = staffId + "0" + (rowCount + 1);
		} else {
			staffId = staffId + "00" + (rowCount + 1);
		}

		return staffId;
	}
	
	public int countStaff() {
		String sql = "SELECT COUNT(*) FROM Staff";
		return (Integer) em.createNativeQuery(sql).getSingleResult();
	}
}
