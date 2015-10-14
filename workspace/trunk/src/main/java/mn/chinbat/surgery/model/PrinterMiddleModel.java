package mn.chinbat.surgery.model;

import java.util.Date;

public class PrinterMiddleModel {
	private ServicePrice servicePrice;
	private Doctor doctor;
	private Date date;

	public ServicePrice getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(ServicePrice servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
