package mn.infosystems.estimator.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mn.infosystems.estimator.enums.CarType;
import mn.infosystems.estimator.enums.Confirm;
import mn.infosystems.estimator.enums.InsuranceType;

/**
 * @author Suld <br>
 *         Харилцагч
 */
@Entity
@Table(name = "customer")
@NamedQueries({@NamedQuery(name="customer.getRegister",query="select c from Customer c where regNumber like :reg"),
	@NamedQuery(name="customer.getCnumber",query="select c from Customer c where cnumber like :number"),
	@NamedQuery(name="customer.getByDate",query="select c from Customer c where date > cast(:date1 as timestamp) "
			+ "and date < cast(:date2 as timestamp) and cast(mainEmp.id as string) like :emp order by mainEmp.id, date,itype"),
	@NamedQuery(name="customer.search",query="select c from Customer c where date > cast(:date1 as timestamp)"
			+ " and date < cast(:date2 as timestamp) and cnumber like :cnum and cast(carFactory.id as string) like :factory"
			+ " and cast(carMark.id as string) like :mark and factoryDate like :factDate"),
			/*,
	@NamedQuery(name="customer.getcount",query="select c.date,count(*) as cn,sum(changeprice) as sm from Customer c where "
			+ "cast(mainEmp.id as string) like :id and c.date >= cast(:date1 as timestamp) and "
			+ "c.date <= cast(:date2 as timestamp) group by c.date")*/
})
public class Customer {
	private Long id;
	/**
	 * Үнэлгээ хийсэн огноо
	 */
	private Date date;
	/**
	 * Үнэлгээ батлагдсан эсэх
	 */
	private Confirm confirm;
	/**
	 * Үнэлгээ хийсэн компани
	 */
	private Company company;
	private CarFactory carFactory;
	private CarMark carMark;
	/**
	 * Улсын дугаар формат(4тоо3үсэг)
	 */
	private String cnumber;
	/**
	 * Үйлдвэрлэсэн он
	 */
	private String factoryDate;
	/**
	 * Орж ирсэн он
	 */
	private String importedDate;
	/**
	 * Тэмдэглэл
	 */
	private String note1;
	/**
	 * Даатгалын төрөл
	 */
	private InsuranceType itype;
	/**
	 * Өнгө
	 */
	private String color;
	/**
	 * Арлын дугаар
	 */
	private String vinNumber;
	/**
	 * Эзэмшигчийн нэр
	 */
	private String ownerName;
	/**
	 * Эзэмшигчийн хаяг
	 */
	private String ownerAddress;
	/**
	 * Эзэмшигчийн утасны дугаар
	 */
	private String ownerPhoneNumber;
	/**
	 * Үнэлгээний зорилго
	 */
	private String estPoint;
	/**
	 * Зах зээлийн үнэ
	 */
	private String marketPrice;
	/**
	 * Захиалагч
	 */
	private String consumer;
	/**
	 * Захиалагчийг төлөөлж
	 */
	private String agentConsumer;
	/**
	 * Хариуцагч
	 */
	private String defendant;
	private Employee emp1;
	private Employee emp2;
	private Employee mainEmp;

	/**
	 * Үзлэг хийж байхад ямар байсан
	 */
	private String estimateStat;
	/**
	 * Үнэлгээ хийхэд тулгуурласан материал
	 */
	private String estimateMaterial;
	/**
	 * Машины зориулалт
	 */
	private CarType carType;
	/**
	 * Үнэлгээний баталгаа
	 */
	private String estimateQuarantee;
	/**
	 * Үнэлгээг ажшиглаж болох нөхцөлүүд
	 */
	private String estimateUseState;

	/**
	 * Үнэлгээчийн мэргэжил дадлагын түвшин
	 */
	@Column(length=500)
	private String estimatorExp;

	/**
	 * Эвдэрлийн жагсаалт
	 */
	private List<Defect> defectList;
	/**
	 * зураг
	 */
	private List<Image> imageOfList;
	
	private String regNumber;
	
	private Long repairPrice = 0l;
	private Long changePrice = 0l;
	private List<Cost> costList;
	
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
	public CarFactory getCarFactory() {
		return carFactory;
	}

	public void setCarFactory(CarFactory carFactory) {
		this.carFactory = carFactory;
	}

	@ManyToOne
	public CarMark getCarMark() {
		return carMark;
	}

	public void setCarMark(CarMark carMark) {
		this.carMark = carMark;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getFactoryDate() {
		return factoryDate;
	}

	public void setFactoryDate(String factoryDate) {
		this.factoryDate = factoryDate;
	}

	public String getImportedDate() {
		return importedDate;
	}

	public void setImportedDate(String importedDate) {
		this.importedDate = importedDate;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public InsuranceType getItype() {
		return itype;
	}

	public void setItype(InsuranceType itype) {
		this.itype = itype;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}

	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		this.ownerPhoneNumber = ownerPhoneNumber;
	}

	public String getEstPoint() {
		return estPoint;
	}

	public void setEstPoint(String estPoint) {
		this.estPoint = estPoint;
	}

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getAgentConsumer() {
		return agentConsumer;
	}

	public void setAgentConsumer(String agentConsumer) {
		this.agentConsumer = agentConsumer;
	}

	public String getDefendant() {
		return defendant;
	}

	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}

	@ManyToOne
	public Employee getEmp1() {
		return emp1;
	}

	public void setEmp1(Employee emp1) {
		this.emp1 = emp1;
	}

	@ManyToOne
	public Employee getEmp2() {
		return emp2;
	}

	public void setEmp2(Employee emp2) {
		this.emp2 = emp2;
	}

	@ManyToOne
	public Employee getMainEmp() {
		return mainEmp;
	}

	public void setMainEmp(Employee mainEmp) {
		this.mainEmp = mainEmp;
	}

	public String getEstimateStat() {
		return estimateStat;
	}

	public void setEstimateStat(String estimateStat) {
		this.estimateStat = estimateStat;
	}

	public String getEstimateMaterial() {
		return estimateMaterial;
	}

	public void setEstimateMaterial(String estimateMaterial) {
		this.estimateMaterial = estimateMaterial;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getEstimateQuarantee() {
		return estimateQuarantee;
	}

	public void setEstimateQuarantee(String estimateQuarantee) {
		this.estimateQuarantee = estimateQuarantee;
	}

	public String getEstimateUseState() {
		return estimateUseState;
	}

	public void setEstimateUseState(String estimateUseState) {
		this.estimateUseState = estimateUseState;
	}

	public String getEstimatorExp() {
		return estimatorExp;
	}

	public void setEstimatorExp(String estimatorExp) {
		this.estimatorExp = estimatorExp;
	}

	@ManyToMany
	public List<Defect> getDefectList() {
		return defectList;
	}

	public void setDefectList(List<Defect> defectList) {
		this.defectList = defectList;
	}

	
	@ManyToMany
	public List<Cost> getCostList() {
		return costList;
	}

	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Confirm getConfirm() {
		return confirm;
	}

	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}

	@ManyToOne
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	@ManyToMany
	public List<Image> getImageOfList() {
		return imageOfList;
	}
	
	public void setImageOfList(List<Image> imageOfList) {
		this.imageOfList = imageOfList;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Long getRepairPrice() {
		return repairPrice;
	}

	public void setRepairPrice(Long repairPrice) {
		this.repairPrice = repairPrice;
	}

	public Long getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(Long changePrice) {
		this.changePrice = changePrice;
	}
	

}
