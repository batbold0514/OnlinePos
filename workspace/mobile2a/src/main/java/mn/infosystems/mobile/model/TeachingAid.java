package mn.infosystems.mobile.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "teachingaid")
public class TeachingAid {
	private Long id;
	private Date written;
	private Date lastUpdate;
	private String name;
	private String description;
	private List<TextUpload> listOfText;
	private List<Image> listOfImages;
	private List<SoundFilePath> listOfsounds;
	private List<VideoFilePath> ListOfvideo;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getWritten() {
		return written;
	}
	public void setWritten(Date written) {
		this.written = written;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToMany
	public List<TextUpload> getListOfText() {
		return listOfText;
	}
	public void setListOfText(List<TextUpload> listOfTtext) {
		this.listOfText = listOfTtext;
	}
	@ManyToMany
	public List<Image> getListOfImages() {
		return listOfImages;
	}
	public void setListOfImages(List<Image> listOfImages) {
		this.listOfImages = listOfImages;
	}
	@ManyToMany
	public List<SoundFilePath> getListOfsounds() {
		return listOfsounds;
	}
	public void setListOfsounds(List<SoundFilePath> listOfsounds) {
		this.listOfsounds = listOfsounds;
	}
	@ManyToMany
	public List<VideoFilePath> getListOfvideo() {
		return ListOfvideo;
	}
	public void setListOfvideo(List<VideoFilePath> listOfvideo) {
		ListOfvideo = listOfvideo;
	}
	
	
	

	
	

	
}
