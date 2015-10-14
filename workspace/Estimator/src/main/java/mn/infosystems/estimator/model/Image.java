package mn.infosystems.estimator.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image
{
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String contentType;
	private boolean isMain;
	
	public Image(){
		
	}
	public Image( Image image){
		this.name = image.getName();
		this.contentType = image.getContentType();
		this.isMain = image.getIsMain();
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getContentType()
	{
		return contentType;
	}
	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}
	
	public boolean getIsMain()
	{
		return isMain;
	}
	public void setIsMain(boolean isMain)
	{
		this.isMain = isMain;
	}
}

