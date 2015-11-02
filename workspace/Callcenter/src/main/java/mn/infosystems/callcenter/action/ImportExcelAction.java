package mn.infosystems.callcenter.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.TaxPayer;
import mn.infosystems.callcenter.service.DebtService;
import mn.infosystems.callcenter.service.DebtTypeService;
import mn.infosystems.callcenter.service.TaxPayerService;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ImportExcelAction extends ActionSupport implements
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private HttpServletRequest request;

	private TaxPayerService taxPayerService;
	private DebtService debtService;
	private DebtTypeService debtTypeService;
	
	private List<TaxPayer> taxPayerList = new LinkedList<TaxPayer>();
	private List<Debt> debtList = new LinkedList<Debt>();

	private final static int columnTaxPayerNumber = 0;
	private final static int columnTaxPayerName = 1;
	private final static int columnReactorLastName = 2;
	private final static int columnReactorFirstName = 3;
	private final static int columnDebtType = 4;
	private final static int columnDebtNumber = 5;
	private final static int columnDebtValue = 6;
	private final static int columnTicketNumber = 7;
	private final static int columnTicketDate = 8;
	private final static int columnDebtDuration = 9;
	private final static int columnPhoneNumber = 10;
	private final static int columnEmail = 11;
	private final static int columnFax = 12;

	@Action(value = "import-excel", results = { @Result(name = "success", type = "tiles", location = "/import-excel.tiles") })
	public String importExcel() {
		return SUCCESS;
	}

	@Action(value = "excel", results = { @Result(name = "success", type = "tiles", location = "/import-excel.tiles") })
	public String excel() {
		try {
			String filePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\files\\temp";
			File importFile = new File(filePath, fileUploadFileName);
			FileUtils.copyFile(fileUpload, importFile);
			String fileToParse = filePath + "\\" + fileUploadFileName;
			FileInputStream file = new FileInputStream(new File(fileToParse));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			importFromExcel(iterator);
			for(TaxPayer tp:taxPayerList){
				if(taxPayerService.getTaxPayerByNumber(tp.getRegNumber())==null)
				taxPayerService.saveOrUpdate(tp);
			}
			for(Debt d:debtList){
				debtService.saveOrUpdate(d);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return SUCCESS;
	}

	private String importFromExcel(Iterator<Row> rows) {
		try {
			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getLastCellNum() == 13) {
					if (row.getRowNum() > 0 && row.getRowNum()<2) {

						Iterator<Cell> cells = row.cellIterator();
						TaxPayer taxPayer = new TaxPayer();
						Debt debt = new Debt();
						while (cells.hasNext()) {
							Cell cell = cells.next();
							switch (cell.getColumnIndex()) {
							case columnTaxPayerNumber:
								taxPayer.setRegNumber(cell.getStringCellValue());
								break;
							case columnTaxPayerName:
								taxPayer.setCompanyName(cell
										.getStringCellValue());
								break;
							case columnReactorLastName:
								taxPayer.setRectorLastName(cell
										.getStringCellValue());
								break;
							case columnReactorFirstName:
								taxPayer.setRectorFirstName(cell
										.getStringCellValue());
								break;
							case columnDebtType:
								debt.setType(debtTypeService
										.getDebtTypeByNumber(cell
												.getStringCellValue()));
								break;
							case columnDebtNumber:
								debt.setDebtNumber(cell.getStringCellValue());
								break;
							case columnDebtValue:
								debt.setBalance(cell.getNumericCellValue());
								break;
							case columnTicketNumber:
								debt.setTicketNumber(Double.toString(cell
										.getNumericCellValue()));
								break;
							case columnTicketDate:
								debt.setStartDate(cell.getDateCellValue());
								break;
							case columnDebtDuration:
								debt.setDuration(Integer.parseInt(cell
										.getStringCellValue()));
								break;
							case columnPhoneNumber:
								taxPayer.setPhoneNumber(cell
										.getStringCellValue());
								break;
							case columnEmail:
								taxPayer.setEmail(cell.getStringCellValue());
								break;
							case columnFax:
								taxPayer.setFax(cell.getStringCellValue());
								break;

							default:
								break;
							}
						}
						TaxPayer taxPayer1 = taxPayerService.getTaxPayerByNumber(taxPayer.getRegNumber());
						if(taxPayer1 == null){
							taxPayerList.add(taxPayer);
//							TaxPayer tp = taxPayerService.saveOrUpdate(taxPayer);
							debt.setTaxPayer(taxPayer);
							debtList.add(debt);
//							Debt d1 = debtService.saveOrUpdate(debt);
							/*List<Debt> list = tp.getDebtList();
							list.add(d1);
							tp.setDebtList(list);
							taxPayerService.saveOrUpdate(tp);*/
						}else{
							debt.setTaxPayer(taxPayer1);
//							Debt d1 = debtService.saveOrUpdate(debt);
							debtList.add(debt);
						/*	List<Debt> list = taxPayer1.getDebtList();
							list.add(d1);
							taxPayer1.setDebtList(list);
							taxPayerService.saveOrUpdate(taxPayer1);*/
						}
					}
				} else {
					return "errorRowNumber";
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return null;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setTaxPayerService(final TaxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	public void setDebtService(final DebtService debtService) {
		this.debtService = debtService;
	}

	public void setDebtTypeService(final DebtTypeService debtTypeService) {
		this.debtTypeService = debtTypeService;
	}
}
