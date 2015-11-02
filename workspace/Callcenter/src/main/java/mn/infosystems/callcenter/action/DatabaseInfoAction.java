package mn.infosystems.callcenter.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import mn.infosystems.callcenter.model.DatabaseInfo;
import mn.infosystems.callcenter.model.PostgreSQLJDBCBat;
import mn.infosystems.callcenter.service.DatabaseInfoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class DatabaseInfoAction extends ActionSupport implements Preparable,
		ModelDriven<DatabaseInfo>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private DatabaseInfo databaseInfo = new DatabaseInfo();
	private DatabaseInfoService databaseInfoService;
	private int databaseInfoHash;
	private HttpServletRequest request;
	
	public DatabaseInfo getModel() {
		return databaseInfo;
	}

	public void prepare() throws Exception {
		if (databaseInfo != null && databaseInfo.getId() != null) {
			this.databaseInfo = databaseInfoService.get(databaseInfo.getId());
			this.databaseInfoHash = databaseInfo.hashCode();
		}
	}

	public DatabaseInfo getDatabaseInfo() {
		return databaseInfo;
	}

	public void setDatabaseInfo(DatabaseInfo databaseInfo) {
		this.databaseInfo = databaseInfo;
	}

	public void setDatabaseInfoService(
			final DatabaseInfoService databaseInfoService) {
		this.databaseInfoService = databaseInfoService;
	}

	@Action(value = "dataDownload", results = { @Result(name = "success", type = "tiles", location = "/database-info.tiles") })
	public String list() throws Exception {
		return SUCCESS;
	}
	
	@Action(value="database-result-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/databaseinfo/databaseInfo-list.jsp")})
	public String list_ajax() throws Exception{
		return SUCCESS;
	}
	@Action(value = "changeIndexNow",  results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/databaseinfo/databaseInfo-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/databaseinfo/databaseInfo-result.jsp") }
	)
	public String changeIndexNow(){
		PostgreSQLJDBCBat db = new PostgreSQLJDBCBat();
		List<String> callQuantity = new LinkedList<String>();
		try {
			db.createConnection();
			db.openConnection();
			callQuantity.add(db.select("callquantity", 0).get(1).getValue());
			db.execute("updatedtaxpayerzero");
			db.execute("updatebalance",callQuantity);
			db.execute("updatecallindex",callQuantity);
			db.execute("updatedateindex",callQuantity);
			db.execute("updatedebttype",callQuantity);
			
			
			/*
			db.execute("updatedtaxpayerzero");
			db.execute("updatebalance",callQuantity);
			db.execute("updatecallindex",callQuantity);
			db.execute("updatedateindex",callQuantity);
			db.execute("updatedebttype",callQuantity);
			db.execute("updateavgdate");*/
			request.setAttribute("dbinfo", "success");
		} catch (SQLException e) {
			addFieldError("username", e.toString());
		}finally{
			db.closeConnection();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "save-databaseinfo-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/databaseinfo/databaseInfo-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/databaseinfo/databaseInfo-result.jsp") })
	public String save() throws Exception {
		if (databaseInfo != null && databaseInfo.hashCode() != databaseInfoHash) {
			if (databaseInfo.getDownloadTime().equals("")
					|| databaseInfo.getPassword().equals("")
					|| databaseInfo.getUrl().equals("")
					|| databaseInfo.getUsername().equals("")) {
				return INPUT;
			}
			databaseInfoService.saveOrUpdate(databaseInfo);
			request.setAttribute("dbinfo", "success");
			Properties prop = new Properties();
			OutputStream output = null;
		 
			try {
				output = new FileOutputStream(System.getProperty("user.dir")+"/src/main/resources/locale/message/connections.properties");
		 
				// set the properties value
				prop.setProperty("url", databaseInfo.getUrl().replace("\\", ""));
				prop.setProperty("username", databaseInfo.getUsername());
				prop.setProperty("password", databaseInfo.getPassword());
				prop.setProperty("time", databaseInfo.getDownloadTime());
		 
				// save properties to project root folder
				prop.store(output, null);
		 
			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		 
			}
			return SUCCESS;
		}
		return INPUT;
	}

	public List<DatabaseInfo> getDatabaseInfos() {
		return databaseInfoService.findAll();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
