package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Access {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long Accessid;
	@Persistent private String Roleid;
	@Persistent private String Resoid;
	@Persistent private boolean status = true;
	
	public Access(String role, String resource) {
		this.Roleid = role;
		this.Resoid = resource;
		}

	
	public Long getAccessid() {
		return Accessid;
	}


	public void setAccessid(Long accessid) {
		Accessid = accessid;
	}


	public String getRole() {
		return Roleid;
	}

	public void setRole(String role) {
		this.Roleid = role;
	}

	public String getResource() {
		return Resoid;
	}

	public void setResource(String resource) {
		this.Resoid = resource;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
