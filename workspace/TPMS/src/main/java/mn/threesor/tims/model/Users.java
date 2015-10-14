package mn.threesor.tims.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "userName", name = "userName"))
@NamedQueries({
		@NamedQuery(name = "user.name", query = "select u from Users u where userName like :name"),
		@NamedQuery(name = "user.idandname", query = "select u from Users u where userName like :name and id<>:id"),
		@NamedQuery(name = "user.notinemployee", query = "select u from Users u where id not in (select e.empUser.id from Employee e where e.empUser is not null)") })
public class Users {
	private Long id;
	@Column(unique = true, name = "userName")
	private String userName;
	private String pwd;
	private List<Role> role;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RequiredStringValidator(key = "validation.userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator(key = "validation.password")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@ManyToMany
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

}
