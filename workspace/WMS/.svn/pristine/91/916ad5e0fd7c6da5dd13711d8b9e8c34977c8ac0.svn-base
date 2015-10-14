package mn.threesor.wms.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.wms.enums.MeasuringUnit;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Category;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.model.InputArticle;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CategoryService;
import mn.threesor.wms.service.ColourService;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.InputArticleService;
import mn.threesor.wms.service.LocationWmsService;
import mn.threesor.wms.service.SizeService;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class ImportArticleAction extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private HttpServletRequest servletRequest;
	private List<Article> articleList;
	private Employee inReciever;
	private String fromSb;
	private int msgStatus = 0;
	private InputStream fileInputStream;
	
	private ArticleService articleService;
	private InputArticleService inputArticleService;
	private SizeService sizeService;
	private ColourService colourService;
	private CategoryService categoryService;
	private EmployeeService employeeService;
	private LocationWmsService locationWmsService;
	
	private final static int ColumnBARCODE = 0;
	private final static int ColumnNAME = 1;
	private final static int ColumnCATEGORY = 2;
	private final static int ColumnMINCOUNT = 3;
	private final static int ColumnCOUNT = 4;
	private final static int ColumnMEASUREUNIT = 5;
	private final static int ColumnOWNER = 6;
	private final static int ColumnLOCATION = 7;
	private final static int ColumnBUYPRICE = 8;
	private final static int ColumnSELLPRICE = 9;
	private final static int ColumnPACKAGEWEIGHT = 10;
	private final static int ColumnCOLOUR = 11;
	private final static int ColumnSIZE = 12;
	private final static int ColumnMOISTURE = 13;
	private final static int ColumnSERIALNUMBER = 14;
	private final static int ColumnPARTNUMBER = 15;
	private final static int ColumnDESCRIPTION = 16;
	
	@Action(value = "import-article", results = { @Result(name = "success", type = "tiles", location = "/import-article.tiles" ) })
	public String execute()
	{
		return SUCCESS;
	}
	
	@Action(value = "download-XLSX", results =
	{
		@Result(name = "success", type = "stream", params =
		{
			"contentType", "application/octet-stream", 
	        "inputName", "fileInputStream",
	        "bufferSize", "1024",
	        "contentDisposition", "attachment;filename=TemplateXLSX.xlsx"
	    }),
	    @Result(name = "error", type = "tiles", location = "/import-article.tiles")
	})
	public String downloadXLSXAction() throws FileNotFoundException
	{
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/") + "\\files\\TemplateXLSX.xlsx";
		try
		{
			fileInputStream = new FileInputStream(new File(filePath));
		}
		catch(Exception e)
		{
			addFieldError("fileDownload", "Алдаа: Загвар файл серверт олдсонгүй");
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Action(value = "import-articles-file", results =
	{
		@Result(name = "success", type = "redirectAction", location = "inputArticleList"),
		@Result(name = "error", type = "tiles", location = "/import-article.tiles")
	})
	public String importArticlesFileAction() throws IOException
	{
		String excelType = "";
		if (fileUpload == null)
		{
			addFieldError("fileUpload", "Орлогодох EXCEL төрлийн файлаа хуулна уу!");
			return ERROR;
		}
		
		String[] str = fileUploadFileName.split("\\.");
		if (str.length <= 1)
		{
			addFieldError("fileUpload", "Файлын төрөл тодорхой бус байна. Зөвхөн EXCEL төрлийн файл хуулна уу!");
			return ERROR;
		}
		
		if (str[str.length - 1].toLowerCase().trim().equalsIgnoreCase("xls") && fileUploadContentType.trim().equalsIgnoreCase("application/vnd.ms-excel"))
		{
			excelType = "xls";
		}
		else if (str[str.length - 1].toLowerCase().trim().equalsIgnoreCase("xlsx") && fileUploadContentType.trim().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			excelType = "xlsx";
		}
		else if (str[str.length - 1].toLowerCase().trim().equalsIgnoreCase("csv") && fileUploadContentType.trim().equalsIgnoreCase("application/vnd.ms-excel"))
		{
			excelType = "csv";
		}
		else
		{
			addFieldError("fileUpload", "Бураа файл байна. Зөвхөн CSV өргөтгөлтэй файл хуулна уу!");
			return ERROR;
		}
		
		if (inReciever.getId() == -1)
		{
			addFieldError("inReciever.id", Messages.getString("inRecieverError"));
			return ERROR;
		}
		
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/") + "\\files\\temp";
		File fileToCreate = new File(filePath, fileUploadFileName);
		FileUtils.copyFile(fileUpload, fileToCreate);
		String fileToParse = filePath + "\\" + fileUploadFileName;
		
		boolean isImportable = true;
		if (excelType.equalsIgnoreCase("xls"))
		{
			try
			{
				FileInputStream file = new FileInputStream(new File(fileToParse));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				isImportable = importExcel(rowIterator);
				file.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				isImportable = false;
				addFieldError("fileUpload", "Серверт файлыг уншихад алдаа гарлаа.");
			}
		}
		else if (excelType.equalsIgnoreCase("xlsx"))
		{
			try
			{
				FileInputStream file = new FileInputStream(new File(fileToParse));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				isImportable = importExcel(rowIterator);
				file.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				isImportable = false;
				addFieldError("fileUpload", "Серверт файлыг уншихад алдаа гарлаа.");
			}
		}
		else if (excelType.equalsIgnoreCase("csv"))
		{
			isImportable = importCSV(fileToParse);
		}
        
		if (isImportable)
		{
	        for (Article tempArticle : articleList)
	        {
	        	InputArticle inputArticle = new InputArticle();
	        	inputArticle.setInDate(new Date());
	    		inputArticle.setInReciever(inReciever);
	    		inputArticle.setWriter("User");
	    		inputArticle.setAddCount(tempArticle.getCount());
	    		inputArticle.setFromSb(fromSb);
	    		Article article = null;
	        	article = articleService.check(tempArticle);
	        	if (article == null)
	        	{
	        		articleService.save(tempArticle);
	        		inputArticle.setArticle(tempArticle);
	        		inputArticleService.save(inputArticle);
	        	}
	        	else
	        	{
	        		inputArticle.setArticle(article);
	        		inputArticleService.save(inputArticle);
	        		article.setCount(article.getCount() + tempArticle.getCount());
	        		articleService.saveOrUpdate(article);
	        	}
	        }
	        
	        msgStatus = 1;
	        FileUtils.deleteQuietly(fileToCreate);
	        return SUCCESS;
		}
		else
		{
			addFieldError("fileUpload", "Файлаас импортлох амжилтгүй боллоо. Та алдаагаа засаад дахин оролдоно уу!");
			FileUtils.deleteQuietly(fileToCreate);
			return ERROR;
		}
	}
	
	public File getFileUpload()
	{
		return fileUpload;
	}
	public void setFileUpload(File fileUpload)
	{
		this.fileUpload = fileUpload;
	}
	
	public String getFileUploadContentType()
	{
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType)
	{
		this.fileUploadContentType = fileUploadContentType;
	}
 
	public String getFileUploadFileName()
	{
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName)
	{
		this.fileUploadFileName = fileUploadFileName;
	}
	
	public Employee getInReciever()
	{
		return inReciever;
	}
	public void setInReciever(Employee inReciever)
	{
		this.inReciever = inReciever;
	}
	
	public String getFromSb()
	{
		return fromSb;
	}
	public void setFromSb(String fromSb)
	{
		this.fromSb = fromSb;
	}

	public List<Employee> getEmployeeList()
	{
		return employeeService.getAvailableEmployee();
	}

	public void setServletRequest(HttpServletRequest servletRequest)
	{
		this.servletRequest = servletRequest;
	}
	public HttpServletRequest getServletRequest()
	{
		return servletRequest;
	}

	public int getMsgStatus()
	{
		return msgStatus;
	}
	public void setMsgStatus(int msgStatus)
	{
		this.msgStatus = msgStatus;
	}
	
	public ArticleService getArticleService()
	{
		return articleService;
	}
	public void setArticleService(ArticleService articleService)
	{
		this.articleService = articleService;
	}

	public InputArticleService getInputArticleService()
	{
		return inputArticleService;
	}
	public void setInputArticleService(InputArticleService inputArticleService)
	{
		this.inputArticleService = inputArticleService;
	}

	public SizeService getSizeService()
	{
		return sizeService;
	}
	public void setSizeService(SizeService sizeService)
	{
		this.sizeService = sizeService;
	}

	public ColourService getColourService()
	{
		return colourService;
	}
	public void setColourService(ColourService colourService)
	{
		this.colourService = colourService;
	}

	public CategoryService getCategoryService()
	{
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	public EmployeeService getEmployeeService()
	{
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	public LocationWmsService getLocationWmsService()
	{
		return locationWmsService;
	}
	public void setLocationWmsService(LocationWmsService locationWmsService)
	{
		this.locationWmsService = locationWmsService;
	}

	public List<Article> getArticleList()
	{
		return articleList;
	}
	public void setArticleList(List<Article> articleList)
	{
		this.articleList = articleList;
	}
	
	public InputStream getFileInputStream()
	{
		return fileInputStream;
	}
	
	private boolean importExcel(Iterator<Row> rowIterator)
	{
		boolean isImportable = true;
		DecimalFormat formatter = new DecimalFormat("########.###");
		articleList = new ArrayList<Article>();
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			if (row.getLastCellNum() == 17)
			{
				if (row.getRowNum() > 0)
				{
					if (!isRowEmpty(row))
					{
						Article article = new Article();
						Iterator<Cell> cellIterator = row.cellIterator();
						while (cellIterator.hasNext())
						{
							Cell cell = cellIterator.next();
							switch (cell.getColumnIndex())
		                	{
		                		case ColumnBARCODE:
		                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		                			{
		                				article.setBarCode(cell.getStringCellValue().trim());
		                			}
		                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
		                			{
		                				article.setBarCode(formatter.format(cell.getNumericCellValue()).trim());
		                			}
		                			else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Баркод");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Баркод");
		                				isImportable = false;
		                			}
		                			break;
		                		case ColumnSERIALNUMBER:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				article.setSerialNumber(cell.getStringCellValue().trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setSerialNumber(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Сериал дугаар");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnSIZE:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
		                				boolean isUnknown = false;
			                			String strSize = "";
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				strSize = cell.getStringCellValue().trim();
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				strSize = formatter.format(cell.getNumericCellValue()).trim();
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Размер");
			                				isImportable = false;
			                				isUnknown = true;
			                			}
			                			
			                			if (!isUnknown)
			                			{
			                				boolean isSize = false;
			                				List<Size> sizeList = sizeService.findAll();
			                				if (sizeList != null && sizeList.size() > 0)
			                				{
			                					for (Size size : sizeList)
				                				{
				                					if (size.getSizes().equalsIgnoreCase(strSize))
				                					{
				                						isSize = true;
				                						article.setSize(size);
				                					}
				                				}
			                				}
			                				
			                				if (!isSize)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Размер", strSize);
			                					isImportable = false;
			                				}
			                			}
		                			}
		                			break;
		                		case ColumnCOLOUR:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
		                				boolean isUnknown = false;
			                			String strColour = "";
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				strColour = cell.getStringCellValue().trim();
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				strColour = formatter.format(cell.getNumericCellValue()).trim();
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Өнгө");
			                				isImportable = false;
			                				isUnknown = true;
			                			}
			                			
			                			if (!isUnknown)
			                			{
				                			boolean isColour = false;
			                				List<Colour> colourList = colourService.findAll();
			                				if (colourList != null && colourList.size() > 0)
			                				{
			                					for (Colour colour : colourList)
				                				{
				                					if (colour.getCode().equalsIgnoreCase(strColour))
				                					{
				                						isColour = true;
				                						article.setColour(colour);
				                					}
				                				}
			                				}
			                				
			                				if (!isColour)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Өнгө", strColour);
			                					isImportable = false;
			                				}
			                			}
		                			}
		                			break;
		                		case ColumnPACKAGEWEIGHT:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setPackageWeight((int)cell.getNumericCellValue());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Пакетийн жин", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Пакетийн жин");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnSELLPRICE:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setSellPrice(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Зарах үнэ", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Зарах үнэ");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnCOUNT:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Тоо хэмжээ");
		                				isImportable = false;
			                			
		                			}
		                			else
		                			{
		                				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setCount(cell.getNumericCellValue());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Тоо хэмжээ", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Тоо хэмжээ");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnDESCRIPTION:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setDescription(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				article.setDescription(cell.getStringCellValue().trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			                			{
			                				article.setDescription(String.valueOf(cell.getBooleanCellValue()).trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Тайлбар");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnNAME:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Нэр");
		                				isImportable = false;
		                			}
		                			else
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setName(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
				                			article.setName(cell.getStringCellValue().trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Нэр");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnCATEGORY:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Барааны төрөл");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isUnknown = false;
		                				String strCategory = "";
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				strCategory = cell.getStringCellValue().trim();
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				strCategory = formatter.format(cell.getNumericCellValue()).trim();
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Барааны төрөл");
			                				isImportable = false;
			                				isUnknown = true;
			                			}
			                			
			                			if (!isUnknown)
			                			{
				                			boolean isCategory = false;
			                				List<Category> categoryList = categoryService.findAll();
			                				if (categoryList != null && categoryList.size() > 0)
			                				{
			                					for (Category category : categoryList)
				                				{
				                					if (category.getName().equalsIgnoreCase(strCategory.trim()))
				                					{
				                						isCategory = true;
				                						article.setCategory(category);
				                					}
				                				}
			                				}
			                				
			                				if (!isCategory)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Барааны төрөл", strCategory);
			                					isImportable = false;
			                				}
			                			}
		                			}
		                			break;
		                		case ColumnMEASUREUNIT:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Хэмжих нэгж");
		                				isImportable = false;
		                			}
		                			else
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				boolean isUnit = false;
			                				for (int j = 0; j < MeasuringUnit.values().length; j++)
			                				{
			                					if (MeasuringUnit.values()[j].getLabel().equalsIgnoreCase(cell.getStringCellValue().trim()))
			                					{
			                						isUnit = true;
			                						article.setMeasuring_unit(MeasuringUnit.values()[j]);
			                					}
			                				}
			                				
			                				if (!isUnit)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Хэмжих нэгж", cell.getStringCellValue().trim());
			                					isImportable = false;
			                				}
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Хэмжих нэгж");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnMINCOUNT:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Доод хэмжээ");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setMinCount(cell.getNumericCellValue());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Доод хэмжээ", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Доод хэмжээ");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnBUYPRICE:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setSellPrice(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Зарах үнэ", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Зарах үнэ");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnLOCATION:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Байрлал");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isUnknown = false;
		                				String strLocation = "";
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				strLocation = cell.getStringCellValue().trim();
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				strLocation = formatter.format(cell.getStringCellValue().trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Байрлал");
			                				isImportable = false;
			                				isUnknown = true;
			                			}
			                			
			                			if (!isUnknown)
			                			{
				                			boolean isLocation = false;
			                				List<LocationWms> locationWmsList = locationWmsService.findAll();
			                				if (locationWmsList != null && locationWmsList.size() > 0)
			                				{
			                					for (LocationWms locationWms : locationWmsList)
				                				{
				                					if (locationWms.getLocationName().equalsIgnoreCase(strLocation))
				                					{
				                						isLocation = true;
				                						article.setLocation(locationWms);
				                					}
				                				}
			                				}
			                				
			                				if (!isLocation)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Байрлал", strLocation);
			                					isImportable = false;
			                				}
			                			}
		                			}
		                			break;
		                		case ColumnOWNER:
		                			if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		                			{
		                				emptyValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Эзэмшигч");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isUnknown = false;
		                				String strOwner = "";
			                			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				strOwner = cell.getStringCellValue().trim();
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				strOwner = formatter.format(cell.getStringCellValue().trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Эзэмшигч");
			                				isImportable = false;
			                				isUnknown = true;
			                			}
			                			
			                			if (!isUnknown)
			                			{
			                				boolean isOwner = false;
			                				List<Employee> employeeList = employeeService.findAll();
			                				if (employeeList != null && employeeList.size() > 0)
			                				{
			                					for (Employee employee : employeeList)
				                				{
				                					if (employee.getFirstName().equalsIgnoreCase(strOwner))
				                					{
				                						isOwner = true;
				                						article.setOwner(employee);
				                					}
				                				}
			                				}
			                				
			                				if (!isOwner)
			                				{
			                					wrongValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Эзэмшигч", strOwner);
			                					isImportable = false;
			                				}
			                			}
		                			}
		                			break;
		                		case ColumnMOISTURE:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setMoisture((int)cell.getNumericCellValue());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				numberValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Чийгшил", cell.getStringCellValue());
			                				isImportable = false;
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Чийгшил");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		case ColumnPARTNUMBER:
		                			if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
		                			{
			                			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			                			{
			                				article.setPartNumber(formatter.format(cell.getNumericCellValue()).trim());
			                			}
			                			else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			                			{
			                				article.setPartNumber(cell.getStringCellValue().trim());
			                			}
			                			else
			                			{
			                				unknownValueWarning(row.getRowNum(), cell.getColumnIndex() + 1, "Партын дугаар");
			                				isImportable = false;
			                			}
		                			}
		                			break;
		                		default:
		                			System.out.println("Warning: Something wrong in import-XSLS!");
		                			break;
		                	}
						}
						articleList.add(article);
					}
					else
					{
						break;
					}
				}
			}
			else if (row.getLastCellNum() > 17)
			{
				msgStatus = -1;
            	addFieldError("fileUpload", row.getRowNum() + "-р мөрний аль нэг багана илүү байна!");
            	isImportable = false;
			}
			else if (row.getLastCellNum() < 17)
			{
				msgStatus = -1;
            	addFieldError("fileUpload", row.getRowNum() + "-р мөрний аль нэг багана дутуу байна!");
            	isImportable = false;
			}
		}
		return isImportable;
	}

	private boolean importCSV(String fileToParse)
	{
		boolean isImportable = true;
		BufferedReader fileReader = null;
        final String DELIMITER = ";";
        try
        {
            String line = "";
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToParse), "UTF-8"));
            int row = 0;
            int rowHead = 0;
            int jump = 1;
            articleList = new ArrayList<Article>();
            while ((line = fileReader.readLine()) != null)
            {
            	String[] values = line.split(DELIMITER);
            	if (row == 0)
            	{
	            	if (values.length > 0)
	            	{
	            		if (values[0].trim().equalsIgnoreCase("Баркод"))
	            		{
	            			rowHead = 1;
	                    	jump = 0;
	            		}
	            	}
            	}
            	
            	if (row >= rowHead)
            	{
	                if (values.length != 17)
	                {
	                	msgStatus = -1;
	                	if (values.length < 17)
	                	{
	                		addFieldError("fileUpload", row + jump + "-р мөрний аль нэг багана дутуу байна!");
	                	}
	                	else
	                	{
	                		addFieldError("fileUpload", row + jump + "-р мөрний аль нэг багана илүү байна!");
	                	}
	                	isImportable = false;
	                }
	                else
	                {
	                	Article article = new Article();
	                	for (int column = 0; column < values.length; column++)
		                {
		                	switch (column)
		                	{
		                		case ColumnBARCODE:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Баркод");
		                				isImportable = false;
		                			}
		                			article.setBarCode(values[column]);
		                			break;
		                		case ColumnSERIALNUMBER:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Сериал дугаар");
		                				isImportable = false;
		                			}
		                			article.setSerialNumber(values[column]);
		                			break;
		                		case ColumnSIZE:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				boolean isSize = false;
		                				List<Size> sizeList = sizeService.findAll();
		                				if (sizeList != null && sizeList.size() > 0)
		                				{
		                					for (Size size : sizeList)
			                				{
			                					if (size.getSizes().equalsIgnoreCase(values[column].trim()))
			                					{
			                						isSize = true;
			                						article.setSize(size);
			                					}
			                				}
		                				}
		                				
		                				if (!isSize)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Размер", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnCOLOUR:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				boolean isColour = false;
		                				List<Colour> colourList = colourService.findAll();
		                				if (colourList != null && colourList.size() > 0)
		                				{
		                					for (Colour colour : colourList)
			                				{
			                					if (colour.getCode().equalsIgnoreCase(values[column].trim()))
			                					{
			                						isColour = true;
			                						article.setColour(colour);
			                					}
			                				}
		                				}
		                				
		                				if (!isColour)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Өнгө", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnPACKAGEWEIGHT:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Пакетийн жин", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setPackageWeight(Integer.parseInt(values[column]));
		                			break;
		                		case ColumnSELLPRICE:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Зарах үнэ", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setSellPrice(values[column]);
		                			break;
		                		case ColumnCOUNT:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Тоо хэмжээ");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Тоо хэмжээ", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setCount(Integer.parseInt(values[column]));
		                			break;
		                		case ColumnDESCRIPTION:
		                			article.setDescription(values[column]);
		                			break;
		                		case ColumnNAME:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Нэр");
		                				isImportable = false;
		                			}
		                			article.setName(values[column]);
		                			break;
		                		case ColumnCATEGORY:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Барааны төрөл");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isCategory = false;
		                				List<Category> categoryList = categoryService.findAll();
		                				if (categoryList != null && categoryList.size() > 0)
		                				{
		                					for (Category category : categoryList)
			                				{
			                					if (category.getName().equalsIgnoreCase(values[column].trim()))
			                					{
			                						isCategory = true;
			                						article.setCategory(category);
			                					}
			                				}
		                				}
		                				
		                				if (!isCategory)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Барааны төрөл", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnMEASUREUNIT:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Хэмжих нэгж");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isUnit = false;
		                				for (int j = 0; j < MeasuringUnit.values().length; j++)
		                				{
		                					if (MeasuringUnit.values()[j].getLabel().equalsIgnoreCase(values[column].trim()))
		                					{
		                						isUnit = true;
		                						article.setMeasuring_unit(MeasuringUnit.values()[j]);
		                					}
		                				}
		                				
		                				if (!isUnit)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Хэмжих нэгж", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnMINCOUNT:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Доод хэмжээ");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Тоо хэмжээ", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setMinCount(Integer.parseInt(values[column]));
		                			break;
		                		case ColumnBUYPRICE:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Худалдах үнэ", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setBuyPrice(values[column]);
		                			break;
		                		case ColumnLOCATION:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Байрлал");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isLocation = false;
		                				List<LocationWms> locationWmsList = locationWmsService.findAll();
		                				if (locationWmsList != null && locationWmsList.size() > 0)
		                				{
		                					for (LocationWms locationWms : locationWmsList)
			                				{
			                					if (locationWms.getLocationName().equalsIgnoreCase(values[column].trim()))
			                					{
			                						isLocation = true;
			                						article.setLocation(locationWms);
			                					}
			                				}
		                				}
		                				
		                				if (!isLocation)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Байрлал", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnOWNER:
		                			if (values[column].trim().equalsIgnoreCase(""))
		                			{
		                				emptyValueWarning(row + jump, column + 1, "Эзэмшигч");
		                				isImportable = false;
		                			}
		                			else
		                			{
		                				boolean isOwner = false;
		                				List<Employee> employeeList = employeeService.findAll();
		                				if (employeeList != null && employeeList.size() > 0)
		                				{
		                					for (Employee employee : employeeList)
			                				{
			                					if (employee.getFirstName().equalsIgnoreCase(values[column].trim()))
			                					{
			                						isOwner = true;
			                						article.setOwner(employee);
			                					}
			                				}
		                				}
		                				
		                				if (!isOwner)
		                				{
		                					wrongValueWarning(row + jump, column + 1, "Эзэмшигч", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			break;
		                		case ColumnMOISTURE:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Чийгшил", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setMoisture(Integer.parseInt(values[column]));
		                			break;
		                		case ColumnPARTNUMBER:
		                			if (!values[column].trim().equalsIgnoreCase(""))
		                			{
		                				try
		                				{
		                					Integer.parseInt(values[column]);
		                				}
		                				catch(NumberFormatException e)
		                				{
		                					numberValueWarning(row + jump, column + 1, "Партын дугаар", values[column]);
		                					isImportable = false;
		                				}
		                			}
		                			article.setPartNumber(values[column]);
		                			break;
		                		default:
		                			System.out.println("Warning: Something wrong in import-CSV!");
		                			break;
		                	}
		                }
	                	articleList.add(article);
	                }
            	}
                row++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            isImportable = false;
            addFieldError("fileUpload", "Серверт файлыг уншихад алдаа гарлаа.");
        }
        finally
        {
            try
            {
                fileReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                isImportable = false;
                addFieldError("fileUpload", "Серверт файлыг хаахад алдаа гарлаа.");
            }
        }
        return isImportable;
	}
	
	private void emptyValueWarning(int row, int column, String columnName)
	{
		msgStatus = -2;
    	addFieldError("fileUpload", row + "-р мөрний " + column + "-р ('" + columnName + "') баганы утга хоосон байна. '" + columnName + "' гэсэн баганы мэдээлэл заавал байх ёстой!");
	}
	
	private void numberValueWarning(int row, int column, String columnName, String value)
	{
		msgStatus = -3;
    	addFieldError("fileUpload", row + "-р мөрний " + column + "-р ('" + columnName + "') баганы утга буруу байна. '" + value + "' нь тоо биш байна!");
	}
	
	private void wrongValueWarning(int row, int column, String columnName, String value)
	{
		msgStatus = -4;
    	addFieldError("fileUpload", row + "-р мөрний " + column + "-р ('" + columnName + "') баганы мэдээлэл буруу байна. '" + value + "' гэсэн утга '" + columnName + "'-д олдохгүй байна!");
	}
	
	private void unknownValueWarning(int row, int column, String columnName)
	{
		msgStatus = -5;
    	addFieldError("fileUpload", row + "-р мөрний " + column + "-р ('" + columnName + "') баганы утга буруу байна. Програм унших боломжгүй утга байна!");
	}
	
	private boolean isRowEmpty(Row row)
	{
		for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++)
		{
			Cell cell = row.getCell(i);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
}