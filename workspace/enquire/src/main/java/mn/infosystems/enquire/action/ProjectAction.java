package mn.infosystems.enquire.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import mn.infosystems.enquire.model.Employee;
import mn.infosystems.enquire.model.Project;
import mn.infosystems.enquire.model.Task;
import mn.infosystems.enquire.service.EmployeeService;
import mn.infosystems.enquire.service.ProjectService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.ui.Model;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/operator"),
		@Namespace("/senior") })
public class ProjectAction extends ActionSupport implements SessionAware,
		ModelDriven<Project>, Preparable {

	private static final long serialVersionUID = 1L;
	private ProjectService projectService;
	private EmployeeService employeeService;
	private String projectManagerId;
	private String firstDateStr;
	private String endDateStr;
	private List<String> members;
	private Map<String, Object> session;
	private List<Task> tasks;
	private List<Project> projects;
	private Project project = new Project();
	private int projectHash;

	@Action(value = "create-project", results = { @Result(name = "success", type = "tiles", location = "/create-project.tiles") })
	public String createProject() {
		tasks = new LinkedList<Task>();
		session.put("tasks", tasks);
		return SUCCESS;
	}

	@Action(value = "active-project", results = { @Result(name = "success", type = "tiles", location = "/active-projects.tiles") })
	public String activeProjects() {
		setProjects(projectService.findAll());
		return SUCCESS;
	}

	@Action(value = "showProject", results = { @Result(name = "success", location = "/show-project.tiles", type = "tiles") })
	public String showProject() {
		this.project = projectService.get(project.getId());
		session.put("project", project);
		return SUCCESS;
	}

	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setProjectService(final ProjectService projectService) {
		this.projectService = projectService;
	}

	public String getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	public String getFirstDateStr() {
		return firstDateStr;
	}

	public void setFirstDateStr(String firstDateStr) {
		this.firstDateStr = firstDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void prepare() throws Exception {
		if (project != null && project.getId() != null) {
			this.project = projectService.get(project.getId());
			this.projectHash = project.hashCode();
		}
	}

	@VisitorFieldValidator(appendPrefix = false, message = "")
	public Project getModel() {
		return project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
