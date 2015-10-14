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

import mn.threesor.wms.enums.OutputArticleActivity;

@Entity
@Table(name = "OutputArticle")
@NamedQueries({
		@NamedQuery(name = "OutputArticleList", query = "select OA from OutputArticle OA where article.id = :articleId"),
		@NamedQuery(name = "OutputArticle.update", query = "update OutputArticle oa set oa.article.id = :id1 where oa.article.id = :id2"),
		@NamedQuery(name = "OutputArticle.getUnfinish", query = "select number from OutputArticle o where status = 0 group by number"),
		@NamedQuery(name = "OutputArticle.getFinish", query = "select number from OutputArticle o where status = 1 group by number"),
		@NamedQuery(name = "OutputArticle.Invoice", query = "select o from OutputArticle o where customer.id=:cusId and outDate between :date1 and :date2"),
		@NamedQuery(name = "OutputArticle.getNumber", query = "select o from OutputArticle o where number = :numb"),
		@NamedQuery(name = "OutputArticle.getOutputArticleFinish", query = "select o from OutputArticle o where status = 1")})
public class OutputArticle {
	private Long id;
	private Article article;
	private Date outDate;
	private String reciever;
	private double outCount;
	private String writer;
	private Employee from;
	private String description;
	private Customer customer;
	private OutputArticleActivity status = OutputArticleActivity.unfinish;
	private String number;

	public OutputArticle(){}
	
	public OutputArticle(Article article) {
		this.article = article;
	}

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OutputArticleActivity getStatus() {
		return status;
	}

	public void setStatus(OutputArticleActivity status) {
		this.status = status;
	}

	@ManyToOne
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}


	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public double getOutCount() {
		return outCount;
	}

	public void setOutCount(double outCount) {
		this.outCount = outCount;
	}

	@ManyToOne
	public Employee getFrom() {
		return from;
	}

	public void setFrom(Employee from) {
		this.from = from;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
