package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long Userid;
	@Persistent private String email;
	@Persistent private String Roleid;
	@Persistent private String birth;
	@Persistent private String gender;
	@Persistent private boolean status = true;
	
	public User( String role, String email, String birth, String gender) {
		this.Roleid = role;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	}

	
	public Long getUserid() {
		return Userid;
	}


	public void setUserid(Long userid) {
		Userid = userid;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleid() {
		return Roleid;
	}

	public void setRoleid(String role) {
		this.Roleid = role;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
