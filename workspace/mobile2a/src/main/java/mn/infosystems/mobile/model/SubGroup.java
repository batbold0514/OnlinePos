package mn.infosystems.mobile.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mn.infosystems.mobile.enums.Category;

@Entity
@Table(name = "subGroup")
@NamedQueries({@NamedQuery(name = "subGroup.category" , query = "select sub from SubGroup sub where sub.category = :category and sub.subGrouplevel = :level order by groupName" ),
	@NamedQuery(name = "subGroup.teachingAid",query = "select sub.listOfTeachingAid from SubGroup sub where sub.id = :id"),
	@NamedQuery(name = "subGroup.listSubGroup",query = "select sub.listOfSubGroup from SubGroup sub where sub.id = :id"),
	})
public class SubGroup {
	
	private Long id;
	private Category category;
	private String groupName;
	private List<SubGroup> listOfSubGroup;
	private List<TeachingAid> listOfTeachingAid;
	private int subGrouplevel;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@ManyToMany
	public List<SubGroup> getListOfSubGroup() {
		return listOfSubGroup;
	}
	public void setListOfSubGroup(List<SubGroup> listOfSubGroup) {
		this.listOfSubGroup = listOfSubGroup;
	}
	@ManyToMany
	public List<TeachingAid> getListOfTeachingAid() {
		return listOfTeachingAid;
	}
	public void setListOfTeachingAid(List<TeachingAid> listOfTeachingAid) {
		this.listOfTeachingAid = listOfTeachingAid;
	}
	public int getSubGrouplevel() {
		return subGrouplevel;
	}
	public void setSubGrouplevel(int subGrouplevel) {
		this.subGrouplevel = subGrouplevel;
	}
	
	
}
