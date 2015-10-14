package mn.chinbat.surgery.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.chinbat.surgery.action.json.DoctorJSONEntry;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.service.DoctorService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@ParentPackage("json-default")
public class DoctorsJSONAction extends ActionSupport implements
		ModelDriven<List<DoctorJSONEntry>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@Override
	@Action(value = "jsondoctors", results = { @Result(name = "success", type = "json" , params = {
			"enableGZIP", "noCache" }) })
	@SkipValidation
	public String execute() {
		return SUCCESS;
	}

	public List<DoctorJSONEntry> getModel() {
		List<Doctor> doctors = doctorService.getNormalDoctors();
		List<DoctorJSONEntry> result = new ArrayList<DoctorJSONEntry>(
				doctors.size());
		for (Doctor doctor : doctors) {
			result.add(new DoctorJSONEntry(doctor));
		}
		return result;
	}

	public void setStart(final long start) {
		// avoid error message
	}

	public void setEnd(final long end) {
		// avoid error message
	}

	public void set_(final long requestTime) {
		// avoid error message
	}

}
