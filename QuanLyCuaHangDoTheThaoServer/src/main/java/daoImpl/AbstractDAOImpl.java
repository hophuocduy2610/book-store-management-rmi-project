package daoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.HibernateUtil;

public class AbstractDAOImpl extends UnicastRemoteObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7313385988151187235L;
	
	protected EntityManager em;

	protected AbstractDAOImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();	
	}
	
	public boolean add(Object obj) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(obj);
			em.flush();
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}

		return false;
	}
	
	public boolean update(Object obj) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(obj);
			tr.commit();

			return true;
		}catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	
	public boolean delete(String id, Class<?> classname) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(classname, id));
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public List<?> getList(String sql, Class<?> classname) throws RemoteException {
		return em.createNativeQuery(sql, classname)
				.getResultList();
	}
	
	public Object getSingle(String sql, Class<?> classname) throws RemoteException {
		return em.createNativeQuery(sql, classname)
				.getSingleResult();
	}	
	
//	public int getLastestId(String[] table, Class<?> classname) {
//		String sql = "SELECT top 1 "+ table[1] +" FROM dbo."+ table[0] +" order by " + table[1] + " desc";
//		Object obj = em.createNativeQuery(sql).getSingleResult();
//		return (Integer) obj;
//	}
}
