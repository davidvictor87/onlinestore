package spring.online.store.login.model;

import javax.validation.constraints.NotNull;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;

@Table("role")
public class Role {
	
	@Id
	@Column("role_id")
	@NotNull(message = "id cannot be null")
	private int role_Id;
	@org.springframework.data.relational.core.mapping.Column("role")
	private String role;
	
	public Role() {}
	
	public int getRoleId() {
        return role_Id;
    }

    public void setRoleId(int roleId) {
        this.role_Id = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "Role [role_Id=" + role_Id + ", role=" + role + "]";
	}
    
    

}
