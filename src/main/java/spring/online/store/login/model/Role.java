package spring.online.store.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(catalog = "login", name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "role_id")
	@NotNull(message = "id cannot be null")
	private int role_Id;
	@Column(name = "role")
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
