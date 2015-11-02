package mn.infosystems.callcenter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import mn.infosystems.callcenter.enums.CallStatus;
import mn.infosystems.callcenter.enums.OperatorStatus;
import mn.infosystems.callcenter.enums.PauseStatus;
import mn.infosystems.callcenter.enums.StatusEnum;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author Dell
 * @see Ð¥Ñ�Ñ€Ñ�Ð³Ð»Ñ�Ð³Ñ‡
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "userName", name = "userName"))
@NamedQueries({@NamedQuery(name = "user.name", query = "select u from Users u where userName like :name"),
	@NamedQuery(name="user.idandname",query="select u from Users u where userName like :name and id<>:id"),
	@NamedQuery(name="user.getAllUsers",query="select u from Users u"),
	@NamedQuery(name="user.getByUsername",query="select u from Users u where userName like :username"),
	@NamedQuery(name="user.getOperatorsForSenior",query="select u from Users u where senior_id in (select u.id from Users u where userName like :username) and loginStatus = 0"),
	@NamedQuery(name="user.getCallOperatorsForSenior",query="select u from Users u where status = 1 and senior_id " +
			"in (select u.id from Users u where userName like :username)"),
	@NamedQuery(name="user.getByStatus",query="select u from Users u where loginStatus = :stat")})
public class Users {
	private Long id;
	@Column(unique = true, name = "userName")
	private String userName;
	private String pwd;
	private String code;
	private List<Role> role;
	private Long senior_id;
	private String senior_code;
	private OperatorStatus status;
	private PauseStatus pauseStatus;
	private CallStatus callStatus;
	@Column(unique = true, name = "operatorLine")
	private String operatorLine;
	private String callCompany;
	private Date duration;
	private StatusEnum loginStatus;
	private String phone;
	/**
	 * зураг
	 */
	private List<Image> imageOfList;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RequiredStringValidator(key = "validation.userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator(key = "validation.password")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@ManyToMany
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSenior_id() {
		return senior_id;
	}

	public void setSenior_id(Long senior_id) {
		this.senior_id = senior_id;
	}

	public String getSenior_code() {
		return senior_code;
	}

	public void setSenior_code(String senior_code) {
		this.senior_code = senior_code;
	}

	public OperatorStatus getStatus() {
		return status;
	}

	public void setStatus(OperatorStatus status) {
		this.status = status;
	}

	public PauseStatus getPauseStatus() {
		return pauseStatus;
	}

	public void setPauseStatus(PauseStatus pauseStatus) {
		this.pauseStatus = pauseStatus;
	}

	public CallStatus getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(CallStatus callStatus) {
		this.callStatus = callStatus;
	}
	public String getOperatorLine() {
		return operatorLine;
	}

	public void setOperatorLine(String operatorLine) {
		this.operatorLine = operatorLine;
	}

	public String getCallCompany() {
		return callCompany;
	}

	public void setCallCompany(String callCompany) {
		this.callCompany = callCompany;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}
	@Transient
	public String getDurationTime(){
		String time = "";
		int secs = getDurationNumber();
		int min = (int)(secs /60);
		int sec = secs - (min * 60);
		
		if (min < 10) {time = "0" + min;}else{
			time =""+ min;
		}
		if (sec < 10) {time =time+ ":0" + sec;}else{
			time=time+":"+sec;
		}
		return time;
		
	}
	@Transient
	public int getDurationNumber(){
		Date d = new Date();
		if(duration !=null)
			return (int) ((d.getTime()-duration.getTime())/1000);
		return 0;
	}

	public StatusEnum getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(StatusEnum loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToMany
	public List<Image> getImageOfList() {
		return imageOfList;
	}

	public void setImageOfList(List<Image> imageOfList) {
		this.imageOfList = imageOfList;
	}

	
	

}
