package mn.infosystems.callcenter.service;

import java.util.LinkedList;
import java.util.List;

import mn.infosystems.callcenter.model.Users;

public class UsersService extends GenericEntityService<Users, Long>{

	@Override
	protected Class<Users> entityClass() {
		return Users.class;
	}
	
	/**
	 * @param name
	 * @param id
	 * @return boolean value
	 * @see Тухайн нэр болон id-тэй хэрэглэгч байгаа эсэхийг шалгана
	 */
	public boolean hasUser(String name,Long id){
		if(id==null){
			return getCurrentSession().getNamedQuery("user.name").setString("name", name).list().isEmpty()?false:true;
		}
		return getCurrentSession().getNamedQuery("user.idandname").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
	public Users getUser(String name){
		return (Users) getCurrentSession().getNamedQuery("user.name").setString("name", name.trim()).list().get(0);
	}
	
	/**
	 * @return Хэрэглчдийг жагсаалт
	 * @see Оператор эрхтэй хэрэглчдийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Users> getOperators(){
		try{
			List<Users> operators = new LinkedList<Users>();
			List<Users> users = getCurrentSession().getNamedQuery("user.getAllUsers").list();
			for(Users user:users){
				if(user.getRole().get(0).getRole().equals("operator")){
					operators.add(user);
				}
			}
			return operators;
		}catch(Exception e){
			return new LinkedList<Users>();
		}
	}
	
	/**
	 * @return Хэрэглчдийн жагсаалт
	 * @see Ахлах опероторын эрхтэй хэрэглчдийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Users> getSeniorOperators(){
		try{
			List<Users> operators = new LinkedList<Users>();
			List<Users> users = getCurrentSession().getNamedQuery("user.getAllUsers").list();
			for(Users user:users){
				if(!user.getRole().get(0).getRole().equals("operator")){
					operators.add(user);
				}
			}
			return operators;
		}catch(Exception e){
			return new LinkedList<Users>();
		}
	}
	
	/**
	 * @param senoirUserName
	 * @return Хэрэглэчдийн жагсаалт
	 * @see Тухайн ахлах операторт хамаарах операторуудыг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Users> getOperatorsOfSenior(String senoirUserName){
		return getCurrentSession().getNamedQuery("user.getOperatorsForSenior").setString("username", senoirUserName).list();
	}
	
	/**
	 * @param seniorUserName
	 * @return Хэрэглэчдийн жагсаалт
	 * @see Тухайн ахлах оперторт хамаарах дуудлага хийх операторуудыг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Users> getCallOperatorsOfSenior(String seniorUserName){
		try{
		List<Users> userList = getCurrentSession().getNamedQuery("user.getCallOperatorsForSenior").setString("username", seniorUserName).list();
		if(userList == null){
			return new LinkedList<Users>();
		}else return userList;
		}catch(Exception e){
		}
		return new LinkedList<Users>();
	}
	
	@SuppressWarnings("unchecked")
	public List<Users> getUsersByStatys(Long status){
		return getCurrentSession().getNamedQuery("user.getByStatus").setLong("stat", status).list();
	}
}

