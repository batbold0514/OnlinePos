package mn.threesor.tims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "occupation", uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "name"))
@NamedQueries({@NamedQuery(name="Occupation.checkID",query="select o from Occupation o where id <> :id and name like :name"),
	@NamedQuery(name="Occupation.checkNonID",query="select o from Occupation o where name like :name")})
public class Occupation {
	private Long id;
	private String name;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@RequiredStringValidator(key="occupationinput")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
