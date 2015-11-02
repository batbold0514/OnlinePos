package mn.infosystems.callcenter.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.ConnectedPerson;
import mn.infosystems.callcenter.service.ConnectedPersonService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ConnectedPersonAction extends ActionSupport implements Preparable,ModelDriven<ConnectedPerson>,ServletRequestAware{

	private ConnectedPerson person = new ConnectedPerson();
	private ConnectedPersonService connectedPersonService;
	private HttpServletRequest request;
	private int personHash;
	private List<ConnectedPerson> listOfPeople;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ConnectedPerson getModel() {
		return person;
	}

	public void prepare() throws Exception {
		if(person!=null && person.getId()!=null){
			this.person = connectedPersonService.get(person.getId());
			this.personHash = person.hashCode();
		}
	}

	public ConnectedPerson getPerson() {
		return person;
	}

	public void setPerson(ConnectedPerson person) {
		this.person = person;
	}

	public void setConnectedPersonService(
			final ConnectedPersonService connectedPersonService) {
		this.connectedPersonService = connectedPersonService;
	}
	
	public List<ConnectedPerson> getListOfPeople() {
		return listOfPeople;
	}

	public void setListOfPeople(List<ConnectedPerson> listOfPeople) {
		this.listOfPeople = listOfPeople;
	}
	
	@Action(value="connected-people",results={@Result(name="success",type="tiles",location="/connected-people.tiles")})
	public String list(){
		this.listOfPeople = connectedPersonService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-person-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/person/person.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/person/person.jsp")})
	public String save(){
		if(person!=null && person.hashCode()!=personHash){
			connectedPersonService.saveOrUpdate(person);
			request.setAttribute("personSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="person-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/person/person-list.jsp")})
	public String list_ajax(){
		this.listOfPeople = connectedPersonService.findAll();
		return SUCCESS;
	}

}
