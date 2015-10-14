package mn.threesor.wms.service;

import java.util.LinkedList;
import java.util.List;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.ArticleMin;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.InputArticle;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.OutputArticle;
import mn.threesor.wms.model.Size;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ArticleService extends GenericEntityService<Article, Long> {

	@Override
	protected Class<Article> entityClass() {
		return Article.class;
	}

	private InputArticleService inputArticleService;
	private OutputArticleService outputArticleService;

	public void setInputArticleService(
			final InputArticleService inputArticleService) {
		this.inputArticleService = inputArticleService;
	}

	public void setOutputArticleService(
			final OutputArticleService outputArticleService) {
		this.outputArticleService = outputArticleService;
	}

	@SuppressWarnings("unchecked")
	public List<Article> getAll() {
		return getCurrentSession().getNamedQuery("Article.getAll").list();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getArticleCount(String var) {
		String var1 = "select a from Article a where a.count > 0 order by "
				+ var;
		Query qr = getCurrentSession().createQuery(var1);
		return qr.list();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getMultiOutput(String var) {
		String var1 = "select a from Article a where " + var;
		Query qr = getCurrentSession().createQuery(var1);
		return qr.list();
	}

	@SuppressWarnings("unchecked")
	public Article check(Article article) {
		List<Article> list;
		if (isNullLocation(article.getLocation())
				&& isNullSize(article.getSize())
				&& isNullColour(article.getColour())) {
			list = getNamedQuery("Article.9")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode()).list();
		} else if (!isNullLocation(article.getLocation())
				&& isNullSize(article.getSize())
				&& isNullColour(article.getColour())) {
			list = getNamedQuery("Article.10")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("location", article.getLocation().getId()).list();
		} else if (!isNullLocation(article.getLocation())
				&& !isNullSize(article.getSize())
				&& isNullColour(article.getColour())) {
			list = getNamedQuery("Article.11")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("location", article.getLocation().getId())
					.setLong("size", article.getSize().getId()).list();
		} else if (!isNullLocation(article.getLocation())
				&& isNullSize(article.getSize())
				&& !isNullColour(article.getColour())) {
			list = getNamedQuery("Article.12")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("location", article.getLocation().getId())
					.setString("colour", article.getColour().getCode()).list();
		} else if (isNullLocation(article.getLocation())
				&& isNullSize(article.getSize())
				&& !isNullColour(article.getColour())) {
			list = getNamedQuery("Article.13")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setString("colour", article.getColour().getCode()).list();
		} else if (isNullLocation(article.getLocation())
				&& !isNullSize(article.getSize())
				&& !isNullColour(article.getColour())) {
			list = getNamedQuery("Article.14")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("size", article.getSize().getId())
					.setString("colour", article.getColour().getCode()).list();
		} else if (isNullLocation(article.getLocation())
				&& !isNullSize(article.getSize())
				&& isNullColour(article.getColour())) {
			list = getNamedQuery("Article.15")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("size", article.getSize().getId()).list();
		} else {
			list = getNamedQuery("Article.16")
					.setLong("category", article.getCategory().getId())
					// .setLong("unit", article.getMeasuring_unit().getId())
					.setString("name", article.getName())
					.setString("barCode", article.getBarCode())
					.setLong("size", article.getSize().getId())
					.setLong("location", article.getLocation().getId())
					.setString("colour", article.getColour().getCode()).list();
		}
		return list.isEmpty() ? null : list.get(0);
	}

	public Article saveArticle(Article article) {
		Article subArticle = check(article);
		if (subArticle == null) {
			saveOrUpdate(article);
			return article;
		} else {
			subArticle.setCount(subArticle.getCount() + article.getCount());
			saveOrUpdate(subArticle);
			return subArticle;
		}
	}

	public void changeArticle(Article article, Article a, int changeCount,
			LocationWms changeLocation, Session session) {
		session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction = session.beginTransaction();
			if (a == null) {
				if (changeCount == article.getCount()) {
					article.setLocation(changeLocation);
					saveOrUpdate(article);
				} else {
					article.setCount(article.getCount() - changeCount);
					saveOrUpdate(article);
					Article article1 = new Article(article);
					save(article1);
					article1.setLocation(changeLocation);
					article1.setCount(changeCount);
					saveOrUpdate(article1);
				}
			} else {
				if (!article.getId().equals(a.getId())) {
					if (article.getCount() != changeCount) {
						article.setCount(article.getCount() - changeCount);
						saveOrUpdate(article);
						a.setCount(a.getCount() + changeCount);
						saveOrUpdate(a);
					} else {
						@SuppressWarnings("unchecked")
						List<OutputArticle> listOut = getCurrentSession()
								.getNamedQuery("OutputArticleList")
								.setLong("articleId", article.getId()).list();
						for (OutputArticle outArt : listOut) {
							outArt.setArticle(a);
							outputArticleService.saveOrUpdate(outArt);
						}
						@SuppressWarnings("unchecked")
						List<InputArticle> listIn = getCurrentSession()
								.getNamedQuery("InputArticleList")
								.setLong("articleId", article.getId()).list();
						for (InputArticle inArt : listIn) {
							inArt.setArticle(a);
							inputArticleService.saveOrUpdate(inArt);
						}
						delete(article);
						a.setCount(a.getCount() + changeCount);
						saveOrUpdate(a);

					}
				}
			}
		} finally {
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Article> searchArticleList(String name, Long size, String code,
			Long location, String barCode) {
		if (name.equals(""))
			name = "%";
		else
			name ="%"+name+"%";
		if (barCode == null || barCode.equals(""))
			barCode = "%";
		else
			barCode = "%"+barCode+"%";
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

	// @SuppressWarnings("finally")
	public boolean transferArticle(Article article, String location,
			int transCount) {
		// try {
		if (article.getCount() < transCount)
			return false;
		else {
			Long id = article.getId();
			article = get(id);
			article.setCount(article.getCount() - transCount);
			saveOrUpdate(article);
			Article article2 = copyArticle(get(id));
			article2.setLocation((LocationWms) getCurrentSession()
					.getNamedQuery("Location.getById")
					.setString("id", location).list().get(0));
			article2.setCount(transCount);
			saveArticle(article2);
			return true;
		} /*
		 * else { article.setLocation((LocationWms) getCurrentSession()
		 * .getNamedQuery("Location.getById") .setString("id",
		 * location).list().get(0)); Article article2 = check(article); if
		 * (article2 == null) { article = get(article.getId());
		 * article.setLocation((LocationWms) getCurrentSession()
		 * .getNamedQuery("Location.getById") .setString("id",
		 * location).list().get(0)); saveOrUpdate(article); return true; } else
		 * { article2.setCount(article2.getCount() + article.getCount());
		 * saveOrUpdate(article2);
		 * getCurrentSession().getNamedQuery("InputArticle.update")
		 * .setLong("id1", article2.getId()) .setLong("id2", article.getId());
		 * getCurrentSession().getNamedQuery("OutputArticle.update")
		 * .setLong("id1", article2.getId()) .setLong("id2", article.getId());
		 * delete(get(article.getId())); return true; } }
		 */
		/*
		 * } catch (Exception e) { JOptionPane.showMessageDialog(null, e);
		 * return false; } finally { return false; }
		 */
	}

	private Article copyArticle(Article a2) {
		Article a1 = new Article();
		a1.setId(null);
		a1.setBarCode(a2.getBarCode());
		a1.setBuyPrice(a2.getBuyPrice());
		a1.setDescription(a2.getDescription());
		a1.setCategory(a2.getCategory());
		if (a2.getColour() == null || a2.getColour().getId() == null)
			a1.setColour(null);
		else
			a1.setColour(a2.getColour());
		a1.setCount(a2.getCount());
		a1.setLocation(a2.getLocation());
		a1.setMeasuring_unit(a2.getMeasuring_unit());
		a1.setMinCount(a2.getMinCount());
		a1.setMoisture(a2.getMoisture());
		a1.setName(a2.getName());
		a1.setOwner(a2.getOwner());
		a1.setPackageWeight(a2.getPackageWeight());
		a1.setPartNumber(a2.getPartNumber());
		a1.setSellPrice(a2.getSellPrice());
		a1.setSerialNumber(a2.getSerialNumber());
		a1.setSize(a2.getSize());
		a1.setMeasure(a2.getMeasure());
		return a1;
	}

	private boolean isNullSize(Size size) {
		if (size == null || size.getId() == null)
			return true;
		else
			return false;
	}

	private boolean isNullColour(Colour colour) {
		if (colour == null || colour.getId() == null)
			return true;
		else
			return false;
	}

	private boolean isNullLocation(LocationWms location) {
		if (location == null || location.getId() == null)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	public List<ArticleMin> getArticleMinList() {
		List<Article> list = getCurrentSession().getNamedQuery(
				"Article.getOrder").list();
		List<ArticleMin> listMin = new LinkedList<ArticleMin>();
		for (Article article : list) {
			listMin = addArticleToList(article, listMin);
		}
		List<ArticleMin> listMinRet = new LinkedList<ArticleMin>();
		for(ArticleMin articleMin:listMin){
			if(articleMin.getArticle().getMinCount() > articleMin.getCount()) 
				listMinRet.add(articleMin);
		}
		return listMinRet;
	}

	private List<ArticleMin> addArticleToList(Article article, List<ArticleMin> list) {
		for (ArticleMin a : list) {
			if (a.getArticle().getName() == article.getName()
					&& a.getArticle().getBarCode()==article.getBarCode()
					&& a.getArticle().getSize().getId() == article.getSize()
							.getId()
					&& a.getArticle().getColour().getId() == article
							.getColour().getId()) {
				a.setCount(a.getCount() + article.getCount());
				return list;
			}
		}
		ArticleMin amin = new ArticleMin();
		amin.setArticle(article);
		amin.setCount(article.getCount());
		list.add(amin);
		return list;
	}
}
