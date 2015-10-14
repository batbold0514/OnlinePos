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
@Table(name = "Measure", uniqueConstraints = @UniqueConstraint(columnNames = "measuringUnit"))
@NamedQueries({@NamedQuery(name="measure.checkWithID",query="select m from Measure m where id <> :id and measuringUnit like :unit"),
	@NamedQuery(name="measure.checkWithoutnID",query="select m from Measure m where measuringUnit like :unit")})
public class Measure {
	private Long id;
	private String measuringUnit;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="measuringUnit")
	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measureingUnit) {
		this.measuringUnit = measureingUnit;
	}


}
