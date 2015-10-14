package mn.chinbat.surgery.action.json;

import java.util.Date;

import mn.chinbat.surgery.model.Appointment;

public class AppointmentJSONEntry {
	private static final long MINUTE_IN_MILLIS = 1000 * 60;;
	private String title;
	private final long id;
	private final Date start;
	private final Date end;
	private final String resourceId;
	private final String body;
	private final boolean allDay;
	private String subTitle;

	public AppointmentJSONEntry(final long id, final String title,final String subTitle,
			final Date start, final Date end, String resourceId, String body,
	 final boolean allDay) {
		super();
		this.title = title;
		this.id = id;
		this.start = start;
		this.end = end;
		this.resourceId = resourceId;
		this.body = body;
	    this.allDay = allDay;
	    this.subTitle = subTitle;

	}

	@SuppressWarnings("deprecation")
	public AppointmentJSONEntry(final Appointment appointment) {
		// TODO appointment.getPatient().getDisplayname()
		// this(appointment.getId(), "Appointment #" + appointment.getId(),
		// appointment.getBegin(), new Date(appointment.getBegin().getTime()
		// + (appointment.getDuration() * MINUTE_IN_MILLIS)),
		// appointment.getUserId()/* , false */);
		this.subTitle = "";
		this.id = appointment.getId();
		Date d = new Date();
		if (appointment.getPatient() == null){
			this.subTitle = appointment.getTitle();
			this.title = "";
		}else {
			if (appointment.getSp_Deference() !=0) {
				this.title = ""+appointment.getSp_Deference();
			}else{
				this.title = "";
			}
			this.title = this.title + " "+ appointment.getPatient().getLastName()
					+ " " + appointment.getPatient().getFirstName() + " "
					+ appointment.getPatient().getMobil_1() + " "
					+ appointment.getPatient().getSex() + " "
					+ appointment.getPatient().getCardNumber();
			this.subTitle = appointment.getTitle();
			if (appointment.getPatient().getBirthday() != null) {
				this.title= this.title
						+ " "
						+ (d.getYear() - appointment.getPatient().getBirthday()
								.getYear());
			}
		}
		this.title = this.title + " "+this.subTitle;
		this.start = appointment.getBegin();
		this.end = new Date(appointment.getBegin().getTime()
				+ (appointment.getDuration() * MINUTE_IN_MILLIS));
		this.resourceId = ""+appointment.getResourceId();
		this.body = appointment.getPatientid();
		this.allDay = false;
	}

	public String getResourceId() {
		return resourceId;
	}

	public String getTitle() {
		return title;
	}
	

	public String getSubTitle() {
		return subTitle;
	}

	public long getId() {
		return id;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
	public String getBody() {
		return body;
	}

	 public boolean isAllDay() {
	 return allDay;
	 }
}
