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
@Table(name = "productionStep",uniqueConstraints={@UniqueConstraint(columnNames="name",name="name")})
@NamedQueries({@NamedQuery(name = "productionStep.getName", query = "select ps.name from ProductionStep ps where ps.id = :id"),
	@NamedQuery(name="ps.getWithID",query="select ps from ProductionStep ps where name like :name and id<>:id"),
	@NamedQuery(name="ps.getWithoutID",query="select ps from ProductionStep ps where name like :name")})
/*
 * Model for "��������"
 */
public class ProductionStep {
	private Long id;
	private String name;
	public ProductionStep(){
	}
	public ProductionStep(long id , String name){
		this.id = id;
		this.name = name;
	}
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@RequiredStringValidator(key = "validation.required")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
