package mn.infosystems.callcenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author Suld
 * @see Дуудлаг хийхэд алдаа гарсан шалтгаан (хэвийн, холбогдох боломжгүй, өөр хүн авсан, орох ярианы эрх хаагдсан гэх мэт)
 */
@Entity
@Table(name="reason",uniqueConstraints={@UniqueConstraint(columnNames={"description"})})
public class Reason {
	private Long id;
	/**
	 * Тайлбар
	 */
	private String description;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@RequiredStringValidator(key = "validation.userName")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
