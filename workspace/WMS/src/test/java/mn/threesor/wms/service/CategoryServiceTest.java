package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.Category;

public class CategoryServiceTest extends AbstractModelServiceSpringContextTest{
	CategoryService categoryService;
	
	@Override
	public void onSetUp() throws Exception{
		super.onSetUp();
		this.categoryService = (CategoryService) getApplicationContext().getBean("categoryService");
	}
	
	public void testServiceAvailable() throws Exception{
		assertNotNull(categoryService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			Category category = new Category();
			category.setName("өбыйөрл");
			category.setArticle_name("article_name");
			category.setArticle_size("article_size");
			Long id = categoryService.save(category);
			category = categoryService.get(id);
			assertNotNull(category.getId());
			assertEquals("өбыйөрл", category.getName());
			assertEquals("article_name", category.getArticle_name());
			assertEquals("article_size", category.getArticle_size());
			assertNull(category.getBarCode());
			assertNull(category.getBuyPrice());
			assertNull(category.getColour());
			assertNull(category.getCount());
			assertNull(category.getDescription());
			assertNull(category.getLocation());
			assertNull(category.getMeasuring_unit());
			assertNull(category.getMinCount());
			assertNull(category.getMoisture());
			assertNull(category.getOwner());
			assertNull(category.getPackageWeight());
			assertNull(category.getPartNumber());
			assertNull(category.getSellPrice());
		}finally{
			rollback();
		}
	}
}
