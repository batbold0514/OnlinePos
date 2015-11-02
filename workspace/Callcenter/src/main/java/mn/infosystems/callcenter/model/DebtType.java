package mn.infosystems.callcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import mn.infosystems.callcenter.enums.StatusEnum;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author Suld
 * @see Өрийн төрөл
 */
@Entity
@Table(name="debttype",uniqueConstraints={@UniqueConstraint(columnNames={"typeName","typeNumber"})})
@NamedQueries({@NamedQuery(name="debtType.getByNumber",query="select dt from DebtType dt where typeNumber like :number")})
public class DebtType {
	private Long id;
	/**
	 * Өрийн төрлийн нэр
	 */
	private String typeName;
	/**
	 * Өрийн төрлийн дугаар
	 */
	private String typeNumber;
	/**
	 * Өрийн төрлийн тайлбар
	 */
	private String description;
	/**
	 * Өрийн төрлийн индекс
	 */
	private int debtTypeIndex;
	
	/**
	 * Төлөв
	 */
	private StatusEnum status;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique=true)
	@RequiredStringValidator(key="debtType")
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(String typeNumber) {
		this.typeNumber = typeNumber;
	}
	public int getDebtTypeIndex() {
		return debtTypeIndex;
	}
	public void setDebtTypeIndex(int debtTypyIndex) {
		this.debtTypeIndex = debtTypyIndex;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	
}
