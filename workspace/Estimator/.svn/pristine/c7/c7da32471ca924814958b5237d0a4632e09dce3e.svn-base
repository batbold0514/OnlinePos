package mn.infosystems.estimator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Suld <br>
 *         Эвдэрсэн эд анги
 */
@Entity
@Table(name = "BreakedPart",uniqueConstraints={@UniqueConstraint(columnNames={"partName"})})
@NamedQueries({
	@NamedQuery(name="breakerPart.id",query="select b from BreakedPart b where b.id = cast(:id as long)")
})
public class BreakedPart {
	private Long id;
	private String partName;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

}
