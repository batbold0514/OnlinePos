package mn.infosystems.callcenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ConnectedPerson")
public class ConnectedPerson {
	Long id;
	String personDescription;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPersonDescription() {
		return personDescription;
	}
	public void setPersonDescription(String personDescription) {
		this.personDescription = personDescription;
	}
	
	
}
