package mn.chinbat.surgery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	private Long id;
	private String city; // хот
	private String destrict;// дүүрэг
	private String section;// хороо
//	private String part;// хэсэг
//	private String street;// гудамж
	private String apartment;// байр

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDestrict() {
		return destrict;
	}

	public void setDestrict(String destrict) {
		this.destrict = destrict;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	/*public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
*/
	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

}
