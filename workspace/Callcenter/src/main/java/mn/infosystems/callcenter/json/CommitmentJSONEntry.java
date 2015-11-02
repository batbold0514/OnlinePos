package mn.infosystems.callcenter.json;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import mn.infosystems.callcenter.model.Commitment;

public class CommitmentJSONEntry {
	private final String yvalue;
	private final String date;
	
	public CommitmentJSONEntry(final String yvalue , final Date date) {
		super();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		this.date =""+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
		this.yvalue =yvalue;
	}

	public  CommitmentJSONEntry(final Commitment commitment) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(commitment.getPayDate());
		this.date =""+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
		this.yvalue = ""+(commitment.getPayBalance()-commitment.getValue());
	}
	

	
	public String getYvalue() {
		return yvalue;
	}
	public String getDate() {
		return date;
	}
	
	
	
	
	
}
