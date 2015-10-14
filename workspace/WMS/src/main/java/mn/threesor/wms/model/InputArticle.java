package mn.threesor.wms.model;

import java.util.Date;

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
@Table(name="InputArticle")
@NamedQueries({@NamedQuery(name = "InputArticleList", query = "select IA from InputArticle IA where article.id = :articleId"),
	@NamedQuery(name = "InputArticle.update",query="update InputArticle ia set ia.article.id = :id1 where ia.article.id = :id2"),
	@NamedQuery(name = "InputArticle.getByYear",query="select ia from InputArticle ia where inDate between :date1 and :date2")})
public class InputArticle {
	private Long id;
	private Article article;
	private Date inDate;
	private Employee inReciever;
	private String writer;
	private double addCount;
	private String fromSb;
	private Customer customer;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@ManyToOne
	public Employee getInReciever() {
		return inReciever;
	}
	public void setInReciever(Employee inReciever) {
		this.inReciever = inReciever;
	}
	public double getAddCount() {
		return addCount;
	}
	public void setAddCount(double addCount) {
		this.addCount = addCount;
	}
	public String getFromSb() {
		return fromSb;
	}
	public void setFromSb(String fromSb) {
		this.fromSb = fromSb;
	}
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
