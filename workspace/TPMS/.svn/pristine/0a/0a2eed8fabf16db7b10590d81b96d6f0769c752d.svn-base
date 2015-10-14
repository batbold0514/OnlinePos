package mn.threesor.tims.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "WorkStep")
@NamedQueries({
		@NamedQuery(name = "workStep.getByDate", query = "select ws from WorkStep ws where ws.emp.id like :empId and date between :date1 and :date2"),
		@NamedQuery(name = "workStep.getSomeStepPrice", query = "SELECT sp FROM StepPrice sp WHERE price > 0 AND productStep_id LIKE :productStep_id"),
		@NamedQuery(name = "workStep.getAllStepPrice", query = "select stepPrice from WorkStep ws where date between :date1 and :date2"),
		@NamedQuery(name = "Workstep.getStepPrice", query = "select stepPrice.productStep from WorkStep ws where ws.stepPrice.id = :id"),
		@NamedQuery(name = "workStep.getLastWorkStep", query = "SELECT ws FROM WorkStep ws WHERE id = (SELECT MAX(id) FROM WorkStep)") })
public class WorkStep {
	private Long id;
	private StepPrice stepPrice;
	private int quantity;
	private Date date;
	private Employee emp;
	private Long tsid;
	private int bonus;

	public WorkStep() {
	}

	public WorkStep(WorkStep ws) {
		this.stepPrice = ws.getStepPrice();
		this.emp = null;
		this.date = new Date();
		this.tsid = ws.getTsid();
		this.bonus = ws.bonus;
		this.quantity = 0;
	}

	public WorkStep(WorkStep ws, int quantity) {
		this.stepPrice = ws.getStepPrice();
		this.emp = null;
		this.date = null;
		this.tsid = ws.getTsid();
		this.bonus = ws.bonus;
		this.quantity = quantity;
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

	@ManyToOne
	public StepPrice getStepPrice() {
		return stepPrice;
	}

	public void setStepPrice(StepPrice stepPrice) {
		this.stepPrice = stepPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	/*public void setDate(String date) {
		this.date = stringToDate(date);
	}*/

	public void setDate(Date date) {
		this.date = date;
	}

	/*private Date stringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!str.equals(""))
				date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}*/

	@ManyToOne
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Long getTsid() {
		return tsid;
	}

	public void setTsid(Long tsid) {
		this.tsid = tsid;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
