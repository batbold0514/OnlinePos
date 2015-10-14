package mn.chinbat.surgery.action.json;

import javax.swing.JOptionPane;

import mn.chinbat.surgery.model.Doctor;

public class DoctorJSONEntry {
	private final String name;
	private final String id;

	public DoctorJSONEntry(final String id, final String name) {
		super();
		this.name = name;
		this.id = id;
	}
	@SuppressWarnings("deprecation")
	public DoctorJSONEntry(final Doctor doctor) {
		this.id = "" + doctor.getId();
		this.name = doctor.getName();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

}
