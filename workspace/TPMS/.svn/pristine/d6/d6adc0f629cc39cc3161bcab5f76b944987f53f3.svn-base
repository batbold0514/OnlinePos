package mn.threesor.tims.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "StollPrice")
@NamedQueries({
		@NamedQuery(name = "StollPrice.getLastStollPrice", query = "SELECT stoll FROM StollPrice stoll WHERE id = (SELECT MAX(id) FROM StollPrice)"),
		@NamedQuery(name = "StollPrice.getRealStollPrice", query = "SELECT stoll FROM StollPrice stoll WHERE status = 'true'") })
public class StollPrice {
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int costPrice;
	private int sellPrice;
	private boolean status;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RequiredStringValidator(key = "validation.required")
	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public void setCostPrice(String costPrice) {
		costPrice = costPrice.trim();
		if (costPrice.equals("")) {
			this.costPrice = 0;
		} else {
			this.costPrice = Integer.parseInt(costPrice);
		}
	}

	@RequiredStringValidator(key = "validation.required")
	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		sellPrice =sellPrice.trim();
		if (sellPrice.equals("")) {
			this.sellPrice = 0;
		} else {
			this.sellPrice = Integer.parseInt(sellPrice);
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
