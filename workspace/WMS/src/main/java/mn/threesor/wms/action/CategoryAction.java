package mn.threesor.wms.action;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.model.Category;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.CategoryService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class CategoryAction extends ActionSupport implements Preparable, ModelDriven<Category>
{
	private CategoryService categoryService;
	private Category category = new Category();
	private int categoryHash;

	public Category getModel()
	{
		return category;
	}

	public void prepare() throws Exception
	{
		if (category != null && category.getId() != null)
		{
			category = categoryService.get(category.getId());
			categoryHash = category.hashCode();
		}
	}
	
	@Override
	@Action(value = "category", results = { @Result(name = "success", type = "tiles", location = "/category.tiles") })
	public String execute()
	{
		return SUCCESS;
	}

	@Action(value = "category-show", results =
	{
		@Result(name = "success", type = "tiles", location = "/category-show.tiles", params = { "model.id", "${category.id}" })
	})
	public String categoryShow()
	{
		return SUCCESS;
	}

	@Action(value = "save-category", results =
	{
		@Result(name = "error", type = "tiles", location = "/licence.tiles"),
		@Result(name = "success", type = "redirectAction", location = "category-list"),
		@Result(name = "input", type = "tiles", location = "/category.tiles")
	})
	public String saveCategory()
	{
		if (category != null && categoryHash != category.hashCode())
		{	
			if (category.getName() == null || category.getName().trim().equals(""))
			{
				addFieldError("name", Messages.getString("categoryName.required"));
				return INPUT;
			}
				
			if (categoryService.check(category.getName(),category.getId()))
			{
				addFieldError("name", Messages.getString("categoryName.override"));
				return INPUT;
			}
			categoryService.saveOrUpdate(category);
			return SUCCESS;
		}
		return INPUT;
	}

	public CategoryService getCategoryService()
	{
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}
}
