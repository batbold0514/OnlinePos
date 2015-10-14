package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.Article;

public class ArticleServiceTest extends AbstractModelServiceSpringContextTest{
	ArticleService articcleService;
	
	@Override
	public void onSetUp() throws Exception{
		super.onSetUp();
		this.articcleService = (ArticleService) getApplicationContext().getBean("articleService");
	}
	
	public void testServiceAvailable() throws Exception{
		assertNotNull(articcleService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			Article article = new Article();
			article.setName("article");
			Long id = articcleService.save(article);
			article = articcleService.get(id);
			assertNotNull(article.getId());
			assertEquals("article", article.getName());
			assertNull(article.getCategory());
			assertNull(article.getLocation());
			assertNull(article.getColour());
			assertNull(article.getOwner());
		}finally{
			rollback();
		}
	}
}
