package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {
	@PrimaryKey
	@Persistent (valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private Long Roleid;
	@Persistent private Long Resoid;
	@Persistent private boolean status;
	
	public Access(Long RoleId , Long Resoid ){
		this.Roleid = RoleId;
		this.Resoid = Resoid;
		this.status  = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleid() {
		return Roleid;
	}

	public void setRoleid(Long roleid) {
		Roleid = roleid;
	}

	public Long getResoid() {
		return Resoid;
	}

	public void setResoid(Long resoid) {
		Resoid = resoid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
