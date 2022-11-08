package app;

import javax.persistence.EntityManager;

import util.HibernateUtil;

public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
	}

}
