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

@Entity
@Table(name = "Material", uniqueConstraints = { @UniqueConstraint(columnNames = "prefix") })
@NamedQueries({@NamedQuery(name="Material.checkId",query="select m from Material m where id <> :id and prefix like :prefix"),
	@NamedQuery(name="Material.check",query="select m from Material m where prefix like :prefix")})
public class Material {
	private Long Id;
	private String prefix;
	private String description;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
