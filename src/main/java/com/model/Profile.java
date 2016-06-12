package main.java.com.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String profileName;
	private String firstname;
	private String lastName;
	private Date created;
		
	/**
	 * 
	 */
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param profileName
	 * @param firstname
	 * @param lastName
	 */
	public Profile(long id, String profileName, String firstname,
			String lastName) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstname = firstname;
		this.lastName = lastName;
		this.created = new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", profileName=" + profileName
				+ ", firstname=" + firstname + ", lastName=" + lastName
				+ ", created=" + created + "]";
	}
	
	
	

}
