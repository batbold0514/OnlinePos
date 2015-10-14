package mn.chinbat.surgery.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mn.chinbat.surgery.action.json.AppointmentJSONEntry;
import mn.chinbat.surgery.model.Appointment;
import mn.chinbat.surgery.service.AppointmentService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("json-default")
public class AppointmentsJSONAction extends ActionSupport implements
		ModelDriven<List<AppointmentJSONEntry>> {
	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;

	/**
	 * will be injected
	 */
	public void setAppointmentService(
			final AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@Override
	@Action(value = "appointments", results = { @Result(name = "success", type = "json", params = {
			"enableGZIP", "noCache" }) })
	@SkipValidation
	public String execute() {
		return SUCCESS;
	}

	public List<AppointmentJSONEntry> getModel() {
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		long start = 0, end = 0;
		Object s = parameters.get("start");
		Object e = parameters.get("end");
		if (s != null) {
			start = Long.parseLong(((Object[]) s)[0].toString());
		}
		if (e != null) {
			end = Long.parseLong(((Object[]) e)[0].toString());
		}
		List<Appointment> appointments = appointmentService
				.getAppointmentByRange(new Date(start * 1000l), new Date(
						end * 1000l));
		List<AppointmentJSONEntry> result = new ArrayList<AppointmentJSONEntry>(
				appointments.size());
		for (Appointment appointment : appointments) {
			result.add(new AppointmentJSONEntry(appointment));
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
