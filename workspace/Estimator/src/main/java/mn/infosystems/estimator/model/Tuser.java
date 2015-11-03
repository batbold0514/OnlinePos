package mn.infosystems.estimator.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "tuser")
public class Tuser {

	@Column(name="user_name")
	private String user_name;
	@NotNull
	private String user_pass;
	
	private List<Trole> roles;
	@Id
	@PrimaryKeyJoinColumn
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	@ManyToMany
	@JoinTable(name="tuser_trole",joinColumns={
			@JoinColumn(name="user_name",nullable= true)
	})
	public List<Trole> getRoles() {
		return roles;
	}
	public void setRoles(List<Trole> roles) {
		this.roles = roles;
	}
	
	
}
