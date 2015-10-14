package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Category;
import mn.threesor.wms.service.CategoryService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class CategoriesAction extends ActionSupport
{
	private CategoryService categoryService;
	private List<Category> categoryList;

	@Override
	@Action(value = "category-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/category-list.tiles")
	})
	public String execute()
	{
		categoryList = categoryService.findAll();
		return SUCCESS;
	}

	public CategoryService getCategoryService()
	{
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	public List<Category> getCategoryList()
	{
		return categoryList;
	}
}