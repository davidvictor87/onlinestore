package spring.online.store.login.model;

import javax.validation.constraints.NotNull;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Table("user_role")
public class UserRole {
	
	@Id
	@Column("user_id")
	@NotNull
	private int user_id;
	@Column("role_id")
	private String roleId;
	
	public UserRole() {}

	public UserRole(@NotNull int user_id, String roleId) {
		super();
		this.user_id = user_id;
		this.roleId = roleId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [user_id=" + user_id + ", roleId=" + roleId + "]";
	}
	
	

}
