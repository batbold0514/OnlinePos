package mn.infosystems.estimator.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import mn.infosystems.estimator.model.InfoBoard;
import mn.infosystems.estimator.service.EstimateLoggerService;
import mn.infosystems.estimator.service.InfoBoardService;
import mn.infosystems.estimator.service.UsersService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/user") ,@Namespace("/employee")})
public class InfoBoardAction extends ActionSupport implements Preparable,
		ModelDriven<InfoBoard>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private InfoBoard infoBoard = new InfoBoard();
	private InfoBoardService infoBoardService;
	private UsersService usersService;
	private List<InfoBoard> infoBoardList;
	private int infoBoardHash;
	private HttpServletRequest request;
	private String dateStr;
	private String idstr;

	@Action(value="info-board",results={@Result(name="success",type="tiles",location="/infoboard.tiles")})
	public String list(){
		this.infoBoardList = infoBoardService.findAll();
		return SUCCESS;
	}
	
	@Action(value="info-board-list",results={@Result(name="success",location="/WEB-INF/content/ajax/infoboard/infoboard-list.jsp")})
	public String listAjax(){
		this.infoBoardList = infoBoardService.findAll();
		return SUCCESS;
	}
	
	@Action(value="info-board-save",results={@Result(name="success",location="/WEB-INF/content/ajax/infoboard/infoboard-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/infoboard/infoboard-result.jsp")})
	public String save(){
		if(infoBoard!=null && infoBoard.hashCode() != infoBoardHash){
			try{
				infoBoard.setDate(new Date());
				infoBoard.setUser(usersService.getUser(request.getRemoteUser()));
			}catch(Exception e){
				return INPUT;
			}
			infoBoardService.saveOrUpdate(infoBoard);
			request.setAttribute("infoBoardSuccess", SUCCESS);
			EstimateLoggerService.writeLog(infoBoard);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="delete-infoboard",results={@Result(name="success",location="/WEB-INF/content/ajax/infoboard/infoboard-list.jsp"),
			@Result(name="success",location="/WEB-INF/content/ajax/infoboard/infoboard-list.jsp")})
	public String delete(){
		try{
			infoBoardService.delete(infoBoardService.get(Long.parseLong(idstr)));
			this.infoBoardList = infoBoardService.findAll();
		}catch(Exception e){
			return INPUT;
		}
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public InfoBoard getModel() {
		return infoBoard;
	}

	public void prepare() throws Exception {
		if (infoBoard != null && infoBoard.getId() != null) {
			this.infoBoard = infoBoardService.get(infoBoard.getId());
			this.infoBoardHash = infoBoard.hashCode();
		}
	}

	public InfoBoard getInfoBoard() {
		return infoBoard;
	}

	public void setInfoBoard(InfoBoard infoBoard) {
		this.infoBoard = infoBoard;
	}

	public List<InfoBoard> getInfoBoardList() {
		return infoBoardList;
	}

	public void setInfoBoardService(final InfoBoardService infoBoardService) {
		this.infoBoardService = infoBoardService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getIdstr() {
		return idstr;
	}

	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}

}
