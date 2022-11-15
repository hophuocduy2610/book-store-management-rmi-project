package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9076762082161089218L;
	private String userName;
	
	private String passWord;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffID" ,referencedColumnName = "staffID")
	private Staff staff;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public Account(String userName, String passWord, Staff staff) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.staff = staff;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", passWord=" + passWord + ", staff=" + staff + "]";
	}		
}
