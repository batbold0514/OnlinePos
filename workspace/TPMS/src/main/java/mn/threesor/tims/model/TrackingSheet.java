package mn.threesor.tims.model;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mn.threesor.tims.enums.statusTrackingSheet;

@Entity
@Table(name = "trackingsheet")
@NamedQueries({
		@NamedQuery(name = "TrackingSheet.getBackingListNumber", query = "select backingListNumber from TrackingSheet ts order by backingListNumber desc limit 1"),
		@NamedQuery(name = "TrackingSheet.getStartNumber", query = "select count(ts) from TrackingSheet ts where startDate between :date1 and :date2"),
		@NamedQuery(name = "TrackingSheet.getAllEmp", query = "select ts from TrackingSheet ts where ts.id in (select ws.tsid from WorkStep ws where emp = :emp1 and date between :date1 and :date2)"),
		@NamedQuery(name = "TrackingSheet.getRangedTs", query = "select ts from TrackingSheet ts where startDate between :date1 and :date2"),
		@NamedQuery(name = "TrackingSheet.totalReport", query = "select ts from TrackingSheet ts where startDate between :date1 and :date2"),
		@NamedQuery(name = "TrackingSheet.getEndNumber", query = "select endNumber from TrackingSheet ts where endDate between :date1 and :date2 order by endDate desc limit 1"),
		@NamedQuery(name = "TrackingSheet.yarnReport", query = "select ts from TrackingSheet ts where customer.name like :cusName and knitterSize.sizes like :sizeId and productModel.modelId like :productId and startDate between :date1 and :date2"),
		@NamedQuery(name = "TrackingSheet.reportFinish", query = "select ts from TrackingSheet ts where customer.name like :cusName and knitterSize.sizes like :sizeId and productModel.modelId like :productId and startDate between :date1 and :date2 and status = 0"),
		@NamedQuery(name = "TrackingSheet.reportUnfinish", query = "select ts from TrackingSheet ts where customer.name like :cusName and knitterSize.sizes like :sizeId and productModel.modelId like :productId and startDate between :date1 and :date2 and status = 1"),
		@NamedQuery(name = "NumberPriceReportNumberFinish", query = "select sum(ts.knitterQuantity) from TrackingSheet ts where ts.yarnColor.id like :colourId and ts.customer.id like :customerId and ts.knitterSize.id like :sizeId and ts.productModel.modelId like :productId and ts.startDate between :date1 and :date2 and status = 0 group by ts.id"),
		@NamedQuery(name = "NumberPriceReportModelFinish", query = "select ts.id from TrackingSheet ts where ts.yarnColor.id like :colourId and ts.customer.id like :customerId and ts.knitterSize.id like :sizeId and ts.productModel.modelId like :productId and ts.startDate between :date1 and :date2 and status = 0 group by ts.id"),
		@NamedQuery(name = "NumberPriceReportNumberUnFinish", query = "select sum(ts.knitterQuantity) from TrackingSheet ts where ts.yarnColor.id like :colourId and ts.customer.id like :customerId and ts.knitterSize.id like :sizeId and ts.productModel.modelId like :productId and ts.startDate between :date1 and :date2 and status = 1 group by ts.id"),
		@NamedQuery(name = "NumberPriceReportModelUnFinish", query = "select ts.id from TrackingSheet ts where ts.yarnColor.id like :colourId and ts.customer.id like :customerId and ts.knitterSize.id like :sizeId and ts.productModel.modelId like :productId and ts.startDate between :date1 and :date2 and status = 1 group by ts.id"),
		@NamedQuery(name = "TrackingSheet.getEndDate", query = "select ts from TrackingSheet ts where endDate between :date1 and :date2 order by ts.productModel.id,ts.yarnColor.id,ts.knitterSize.id"),
		@NamedQuery(name = "TrackingSheet.getProductModel", query = "select ts from TrackingSheet ts where ts.productModel.id like :id"),
		@NamedQuery(name = "TrackingSheet.getTrackingSheet", query = "select ts from TrackingSheet ts where ts.id like :id"),
		@NamedQuery(name = "TrackingSheet.DeleteAllWorkStep", query = "delete from TrackingSheet ts where ts.id like :id"),
		@NamedQuery(name = "TrackingSheet.getYarnColorList", query = "select ts.yarnColorList from TrackingSheet ts where ts.id = :id"),
		@NamedQuery(name = "TrackingSheet.getLastAddedItem", query = "select ts from TrackingSheet ts order by id desc limit 1") })
public class TrackingSheet {
	private Long id;
	private int backingListNumber;
	private Customer customer; // Захиалагч *
	private statusTrackingSheet status = statusTrackingSheet.stickit; // дууссан,
																		// дуусаагүй
	private Date startDate; // дагалдах хуудасны нээсэн огноо
	private Date endDate; // дагалдах хуудасны хаасан огноо
	private ProductModel productModel; // загвар *
	private Employee knitterChecker; // Сүлжихийн чанар шалгагч *
	private Colour yarnColor;
	private Size knitterSize; // размер
	private int knitterQuantity; // сүлжмэлийн тоо
	private int knitterWeight; // сүлжмэлийн жин
	private int actualWeight; // сүлжмэлийн бэлэн болсон үеийн жин
	private Employee productionStepChecker; // дамжлага дундын чанар шалгагч *
	private Employee actualChecker; // бэлэнгийн чанар шалгагч *
	private List<WorkStep> workStepList;// дамжлагуудын гүйцэтгэл
	private String startNumber; // дагалдах хуудасны эхэлсэн дугаар
	private String endNumber; // дагалдах хуудасны дууссан дугаар
	private Bonus bonus; // эх болон хөөлтөнд өгөх нэмэлт цалингийн хэмжээ
							// хувиар
	private int detailWeight; // Деталь жин
	private String barcode = "";
	private List<Colour> yarnColorList; // өнгөний алаг
	private Employee mainKnitter; // Сүлжигч

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBackingListNumber() {
		return backingListNumber;
	}

	public void setBackingListNumber(int backingListNumber) {
		this.backingListNumber = backingListNumber;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public statusTrackingSheet getStatus() {
		return status;
	}

	public void setStatus(statusTrackingSheet status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public int getKnitterQuantity() {
		return knitterQuantity;
	}

	public void setKnitterQuantity(int knitterQuantity) {
		this.knitterQuantity = knitterQuantity;
	}

	public int getKnitterWeight() {
		return knitterWeight;
	}

	public void setKnitterWeight(int knitterWeight) {
		this.knitterWeight = knitterWeight;
	}

	public int getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(int actualWeight) {
		this.actualWeight = actualWeight;
	}

	@ManyToMany
	public List<WorkStep> getWorkStepList() {
		return workStepList;
	}

	public void setWorkStepList(List<WorkStep> workStepList) {
		this.workStepList = workStepList;
	}

	@ManyToOne
	public Size getKnitterSize() {
		return knitterSize;
	}

	public void setKnitterSize(Size knitterSize) {
		this.knitterSize = knitterSize;
	}

	public String getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(String startNumber) {
		this.startNumber = startNumber;
	}

	public String getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(String endNumber) {
		this.endNumber = endNumber;
	}

	@ManyToOne
	public Employee getKnitterChecker() {
		return knitterChecker;
	}

	public void setKnitterChecker(Employee knitterChecker) {
		this.knitterChecker = knitterChecker;
	}

	@ManyToOne
	public Employee getProductionStepChecker() {
		return productionStepChecker;
	}

	public void setProductionStepChecker(Employee productionStepChecker) {
		this.productionStepChecker = productionStepChecker;
	}

	@ManyToOne
	public Employee getActualChecker() {
		return actualChecker;
	}

	public void setActualChecker(Employee actualChecker) {
		this.actualChecker = actualChecker;
	}

	@ManyToOne
	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public int getDetailWeight() {
		return detailWeight;
	}

	public void setDetailWeight(int detailWeight) {
		this.detailWeight = detailWeight;
	}

	@ManyToOne
	public Colour getYarnColor() {
		return yarnColor;
	}

	public void setYarnColor(Colour yarnColor) {
		this.yarnColor = yarnColor;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@ManyToMany
	public List<Colour> getYarnColorList() {
		return yarnColorList;
	}

	public void setYarnColorList(List<Colour> yarnColorList) {
		this.yarnColorList = yarnColorList;
	}

	@ManyToOne
	public Employee getMainKnitter() {
		return mainKnitter;
	}

	public void setMainKnitter(Employee mainKnitter) {
		this.mainKnitter = mainKnitter;
	}

	/*
	 * private Date stringToDate(String str) { SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date date = null; try { if
	 * (!str.equals("")) date = formatter.parse(str); } catch (ParseException e)
	 * { e.printStackTrace(); } return date; }
	 */
}
