package mn.threesor.wms.model;

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
@Table(name = "Colour", uniqueConstraints = @UniqueConstraint(columnNames = "code", name = "code"))
@NamedQueries({@NamedQuery(name="Colour.check",query="select c from Colour c where c.code like :code and c.id!=:id")})
public class Colour {
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
	
    @RequiredStringValidator(key="colourName.required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@RequiredStringValidator(key="colourCode.required")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
