package mn.infosystems.estimator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="carmark")
@NamedQueries({@NamedQuery(name="Mark.getByFactory",query="select m from CarMark m where factory.id = :factId")})
public class CarMark {
	private Long id;
	private String mark;
	private CarFactory factory;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@ManyToOne
	public CarFactory getFactory() {
		return factory;
	}
	public void setFactory(CarFactory factory) {
		this.factory = factory;
	}
	
	
}
