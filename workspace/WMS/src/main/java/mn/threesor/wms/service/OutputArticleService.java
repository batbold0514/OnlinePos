package mn.threesor.wms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mn.threesor.wms.enums.OutputArticleActivity;
import mn.threesor.wms.model.OutputArticle;

public class OutputArticleService extends
		GenericEntityService<OutputArticle, Long> {

	@Override
	protected Class<OutputArticle> entityClass() {
		return OutputArticle.class;
	}

	private int getFinish() {
		return getCurrentSession().getNamedQuery("OutputArticle.getFinish")
				.list().size();
	}

	private int getUnfinish() {
		return getCurrentSession().getNamedQuery("OutputArticle.getUnfinish")
				.list().size();
	}

	private String getNumberWithLeadingNulls(long number) {
		String stringNr = String.valueOf(number);
		int size = 8 - stringNr.length();
		char[] nulls = new char[size];
		for (int i = 0; i < size; i++)
			nulls[i] = '0';
		return String.valueOf(nulls) + stringNr;
	}

	public String getOutputArticleNumber(OutputArticleActivity a) {
		if (a.getId() == 1l) {
			return a.getPrefix() + getNumberWithLeadingNulls(getFinish() + 1);
		} else {
			return a.getPrefix() + getNumberWithLeadingNulls(getUnfinish() + 1);
		}
	}

	@SuppressWarnings("unchecked")
	public List<OutputArticle> getInvoice(Long CusId, Date date1, Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate1 = formatter.format(date1) + " 00:00:00.000";
		String sdate2 = formatter.format(date2) + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("OutputArticle.Invoice")
				.setString("cusId", CusId.toString())
				.setString("date1", sdate1).setString("date2", sdate2).list();
	}

	@SuppressWarnings("unchecked")
	public List<OutputArticle> getNumber(String number) {
		return getCurrentSession().getNamedQuery("OutputArticle.getNumber")
				.setString("numb", number).list();
	}

	@SuppressWarnings("unchecked")
	public List<OutputArticle> getOutputArticleFinish() {
		return getCurrentSession().getNamedQuery(
				"OutputArticle.getOutputArticleFinish").list();
	}
}
