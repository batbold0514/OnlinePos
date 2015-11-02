package mn.infosystems.enquire.model;

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
@Table(name="EnquireType", uniqueConstraints = @UniqueConstraint(columnNames = "description", name = "description"))
@NamedQueries({
	@NamedQuery(name = "enquireType.get" , query = "select e from EnquireType e where e.description like :desc")
})
public class EnquireType {

	private Long id;
	private String description;
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
