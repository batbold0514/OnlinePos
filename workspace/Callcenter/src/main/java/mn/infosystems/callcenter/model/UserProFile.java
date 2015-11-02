package mn.infosystems.callcenter.model;

import mn.infosystems.callcenter.enums.CallStatus;
import mn.infosystems.callcenter.enums.OperatorStatus;

public class UserProFile {

	private String image;
	private OperatorStatus status;
	private CallStatus callStatus;
	private String durationTime;
	private TaxPayer taxPayer;
	private String userName;
	private String code;
	
	public UserProFile(Users user){
		this.status = user.getStatus();
		this.callStatus = user.getCallStatus();
		this.durationTime = user.getDurationTime();
		this.userName = user.getUserName();
		this.code = user.getCode();
		this.image = "default.png";
		for(Image i:user.getImageOfList()){
				if(i.getIsMain()){
					this.image = i.getName();
					break;
				}
		}
	} 
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public OperatorStatus getStatus() {
		return status;
	}
	public void setStatus(OperatorStatus status) {
		this.status = status;
	}
	public CallStatus getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(CallStatus callStatus) {
		this.callStatus = callStatus;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	public TaxPayer getTaxPayer() {
		return taxPayer;
	}
	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
