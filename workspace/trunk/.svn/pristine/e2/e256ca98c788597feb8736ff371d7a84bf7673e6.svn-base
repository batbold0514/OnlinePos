package mn.chinbat.surgery.service;

import java.util.Date;
import java.util.List;

import mn.chinbat.surgery.model.Appointment;
import mn.chinbat.surgery.model.Messages;

import org.springframework.transaction.annotation.Transactional;

/**
 * AppointmentService.
 */
public class AppointmentService extends GenericEntityService<Appointment, Long> {

    @Override
    public Class<Appointment> entityClass() {
        return Appointment.class;
    }

    @SuppressWarnings("unchecked")
	@Transactional
    public List<Appointment> getAppointmentByRange(final Date start, final Date end) {
        return getCurrentSession().getNamedQuery(Appointment.GET_BY_RANGE_QUERY_NAME).setTimestamp("start", start)
                .setTimestamp("end", end).setString("fired",Messages.getString("fired")).list();
    }
    public void updateAppointment(String time,int dur,int userId , Long id){
    	getCurrentSession().getNamedQuery("update").setString("time", time).setInteger("dur", dur).setInteger("userId", userId).setLong("id", id).executeUpdate();
    }
    public void deleteAppointment(Long id){
    	getCurrentSession().getNamedQuery("delete").setLong("id", id).executeUpdate();
    }
}
