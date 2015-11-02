	package mn.infosystems.callcenter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Suld
 * @see Дуудлага
 */
@Entity
@Table(name="calls")
@NamedQueries({@NamedQuery(name="calls.getCall",query="select c from Calls c where date > cast(:d1 as timestamp)" +
		" and date < cast(:d2 as timestamp) and duration >= :duration" +
		" and cast(operator.id as string) like :opId and cast(reason.id as string) like :reasonId "),
		@NamedQuery(name = "calls.getCallBetween" , query= "select c from Calls c where date > cast(:d1 as timestamp)" +
		" and date < cast(:d2 as timestamp)"),
		@NamedQuery(name = "calls.getConnectePerson" , query= "select c from Calls c where date > cast(:d1 as timestamp)" +
				" and date < cast(:d2 as timestamp) and cast(c.person.id as string) like :person"),
			@NamedQuery(name = "calls.getReason" , query= "select c from Calls c where date > cast(:d1 as timestamp)" +
					" and date < cast(:d2 as timestamp) and cast(c.reason.id as string) like :reason")
		})
public class Calls {
	private Long id;
	/**
	 * Дуудлага хийсэн огноо
	 */
	private Date date;
	/**
	 * файлын нэр
	 */
	private String fileName;
	/**
	 * Дуудлага хийсэн хугацаа секундээр
	 */
	private int duration;
	/**
	 * Дуудлага хийсэн оператор
	 */
	private Users operator;
	/**
	 * Дуудлагын төлөв (хэвийн,холбогдох боломжгүй г.м)
	 */
	private Reason reason;
	
	/**
	 * Татвар төлөгч
	 */
	private TaxPayer taxPayer;
	
	/**
	 * Холбогдсон этгээд
	 */
	private ConnectedPerson person;
	
	public Calls(){
		
	}
	public Calls(Reason reason , Users users){
		this.date = new Date();
		this.reason =reason;
		this.operator = users;
		this.duration = users.getDurationNumber();
	}
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@ManyToOne
	public Users getOperator() {
		return operator;
	}
	public void setOperator(Users operator) {
		this.operator = operator;
	}
	@ManyToOne
	public Reason getReason() {
		return reason;
	}
	public void setReason(Reason reason) {
		this.reason = reason;
	}
	@ManyToOne
	public TaxPayer getTaxPayer() {
		return taxPayer;
	}
	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}
	@ManyToOne
	public ConnectedPerson getPerson() {
		return person;
	}
	public void setPerson(ConnectedPerson person) {
		this.person = person;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
