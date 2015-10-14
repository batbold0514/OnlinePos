package mn.chinbat.surgery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Diagnosis",uniqueConstraints = @UniqueConstraint(columnNames="code",name="code"))
@NamedQueries({@NamedQuery(name="Diagnosis.checkNonId",query="select d from Diagnosis d where code like :code"),
	@NamedQuery(name="Diagnosis.checkId",query="select d from Diagnosis d where code like :code and id<>:id")})
public class Diagnosis {
	private Long id;
	private String name;
	private String code;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
