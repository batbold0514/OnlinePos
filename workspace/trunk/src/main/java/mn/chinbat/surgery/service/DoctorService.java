package mn.chinbat.surgery.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.Messages;

public class DoctorService extends GenericEntityService<Doctor, Long> {

	@Override
	protected Class<Doctor> entityClass() {
		return Doctor.class;
	}

	public boolean existsRegistration(String registration) {
		@SuppressWarnings("unchecked")
		List<Doctor> list = getCurrentSession()
				.getNamedQuery("Doctor.registration")
				.setString("name", registration).list();
		return list.isEmpty() ? false : true;
	}

	public boolean existsId(Long id) {
		@SuppressWarnings("unchecked")
		List<Doctor> list = getCurrentSession().getNamedQuery("Doctor.id")
				.setLong("id", id).list();
		return list.isEmpty() ? false : true;
	}

	public boolean check(Long id, String reg) {
		@SuppressWarnings("unchecked")
		List<Doctor> list = getCurrentSession()
				.getNamedQuery("Doctor.registration").setString("name", reg)
				.list();
		return this.get(id).getRegistrationNumber()
				.equals(list.get(0).getRegistrationNumber()) ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Doctor> getNormalDoctors(){
		return getCurrentSession().getNamedQuery("Doctor.normal").setString("normal", Messages.getString("Doctor.normal")).list();
	}
	@SuppressWarnings("unchecked")
	public List<Doctor> getNotNormalDoctors(){
		return getCurrentSession().getNamedQuery("Doctor.notNormal").setString("fired", Messages.getString("fired")).list();
	}
	
	@SuppressWarnings("unchecked")
	public boolean hasConjuctiopn(Long id,String reg){
		if(id==null){
			return getCurrentSession().getNamedQuery("Doctor.registration").setString("name", reg).list().isEmpty()?false:true;
		}
		List<Doctor> list = getCurrentSession().getNamedQuery("Doctor.checkReg").setString("reg", reg).setLong("id", id).list();
		if(list.isEmpty()) return false;
		else return true;
	}
	
	public boolean hasUser(String id){
		return getCurrentSession().getNamedQuery("Doctor.checkUser").setLong("id", Long.parseLong(id)).list().isEmpty()?false:true;
	}
	
	@SuppressWarnings("unchecked")
	public Doctor getDoctorWithUser(String name){
		List<Doctor> list = getCurrentSession().getNamedQuery("Doctor.getDoctorWithUser").setString("name", name).list();
		return list.isEmpty()?null:list.get(0);
	}
}
