package spring.online.store.login.model;

import java.io.Serializable;
import java.util.Set;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("user")
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column("user_id")
	@NotNull
	private int id;
	@Column("email")
	private String email;
	@Column("password")
	private String password;
	@Column("name")
	private String name;
	@Column("last_name")
	private String last_name;
	@Column("active")
	private int active;
	private Set<Role> roles;
	
	public Users() {}
	
	public Users(Users users) {}

	public Users(@NotNull int id, String email, String password, String name, String last_name, int active,
			Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.last_name = last_name;
		this.active = active;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", last_name="
				+ last_name + ", active=" + active + ", roles=" + roles + "]";
	}
	
	

}
