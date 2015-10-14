package mn.threesor.wms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "Customer")
@NamedQueries({@NamedQuery(name="Customer.check",query="select c from Customer c where c.name like :name and c.id!=:id"),
	@NamedQuery(name="Customer.getLastAdd",query="select c.id from Customer c order by id desc limit 1")})
public class Customer
{
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@RequiredStringValidator(key = "validation.required")
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}