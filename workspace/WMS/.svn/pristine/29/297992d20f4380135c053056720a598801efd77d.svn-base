package mn.threesor.wms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.InputArticle;

public class InputArticleService extends GenericEntityService<InputArticle, Long> {

	@Override
	protected Class<InputArticle> entityClass() {
		return InputArticle.class;
	}

	@SuppressWarnings("unchecked")
	public List<Article> search(String name, Long size, String code,
			Long location, String barCode) {
		if (name.equals(""))
			name = "%";
		else name+="%";
		if (barCode.equals(""))
			barCode = "%";
		else barCode+= "%";
		if (size == -1 && location == -1 && code.equals(""))
			return getNamedQuery("Article.1").setString("name", name)
					.setString("barCode", barCode).list();
		else if (size == -1 && location != -1 && code.equals(""))
			return getNamedQuery("Article.2").setString("name", name)
					.setString("barCode", barCode)
					.setString("location", location.toString()).list();
		else if (size == -1 && location == -1 && !code.equals(""))
			return getNamedQuery("Article.3").setString("name", name)
					.setString("barCode", barCode).setString("colour", code)
					.list();
		else if (size != -1 && location == -1 && code.equals(""))
			return getNamedQuery("Article.4").setString("name", name)
					.setString("barCode", barCode)
					.setString("size", size.toString()).list();
		else if (size != -1 && location != -1 && code.equals(""))
			return getNamedQuery("Article.5").setString("name", name)
					.setString("barCode", barCode)
					.setString("size", size.toString())
					.setString("location", location.toString()).list();
		else if (size != -1 && location == -1 && !code.equals(""))
			return getNamedQuery("Article.6").setString("name", name)
					.setString("barCode", barCode)
					.setString("size", size.toString())
					.setString("colour", code).list();
		else if (size == -1 && location != -1 && !code.equals(""))
			return getNamedQuery("Article.7").setString("name", name)
					.setString("barCode", barCode)
					.setString("location", location.toString())
					.setString("colour", code).list();
		else
			return getNamedQuery("Article.8").setString("name", name)
					.setString("barCode", barCode)
					.setString("location", location.toString())
					.setString("colour", code)
					.setString("size", size.toString()).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<InputArticle> getListBetweenDate(Date date1,Date date2){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate1 = formatter.format(date1)+" 00:00:00.000";
		String sdate2 = formatter.format(date2)+" 23:59:59.999";
		return getCurrentSession().getNamedQuery("InputArticle.getByYear").setString("date1", sdate1).setString("date2", sdate2).list();
	}
}
