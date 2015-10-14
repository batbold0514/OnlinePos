package mn.chinbat.surgery.model;

public class CompanyContact {
	
     private String companyName;
     private Contact companyContact;
	String getCompanyName() {
		return companyName;
	}
	void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	Contact getCompanyContact() {
		return companyContact;
	}
	void setCompanyContact(Contact companyContact) {
		this.companyContact = companyContact;
	}
     
}
