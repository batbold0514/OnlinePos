package mn.threesor.tims.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.ColourPersentSum;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.ModelReportModel;
import mn.threesor.tims.model.NumberAndPriceReport;
import mn.threesor.tims.model.TrackingSheet;

public class TrackingSheetService extends
		GenericEntityService<TrackingSheet, Long> implements TpmsLogger {

	@Override
	protected Class<TrackingSheet> entityClass() {
		return TrackingSheet.class;
	}

	public int getLastNumber() {
		return (Integer) getCurrentSession()
				.getNamedQuery("TrackingSheet.getBackingListNumber").list()
				.get(0);
	}

	public String getStartNumber(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = f.format(date);
		String date1 = formattedDate.substring(0, 8)
				+ Calendar.getInstance()
						.getActualMaximum(Calendar.DAY_OF_MONTH);
		String date2 = formattedDate.substring(0, 8) + "01";
		Long count = (Long) getCurrentSession()
				.getNamedQuery("TrackingSheet.getStartNumber")
				.setString("date1", date2).setString("date2", date1).list()
				.get(0);
		count++;
		return f.format(date).substring(0, 7) + " " + count;
		/*
		 * if (list.isEmpty()) { return f.format(date).substring(0, 7) + " 1"; }
		 * else { String string = list.get(0); int index =
		 * string.lastIndexOf(" "); int number =
		 * Integer.parseInt(string.substring(index + 1, string.length())) + 1;
		 * string = string.substring(0, index) + " " + Integer.toString(number);
		 * return string; }
		 */
	}

	@SuppressWarnings("unchecked")
	public String getEndNumber(Date date) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = f.format(date);
		// String date2 = date1.substring(0, 8) + "01";

		/*
		 * List<String> list = (List<String>) getCurrentSession()
		 * .getNamedQuery("TrackingSheet.getEndNumber") .setString("date1",
		 * date2).setString("date2", date1).list(); if (list.isEmpty()) { return
		 * f.format(date).substring(0, 7) + " 1"; } else { String string =
		 * list.get(0); int index = string.lastIndexOf(" "); int number =
		 * Integer.parseInt(string.substring(index + 1, string.length())) + 1;
		 * string = string.substring(0, index) + " " + Integer.toString(number);
		 * return string; }
		 */
		List<Integer> list = getCurrentSession().getNamedQuery(
				"TrackingSheet.getBackingListNumber").list();

		if (list.isEmpty()) {
			return date1.substring(0, 7) + " 1";
		} else
			return date1.substring(0, 7) + " " + (list.get(0) + 1);

	}

	public List<TrackingSheet> getAllEmp(Date date1, Date date2, Employee emp) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings({ "unchecked" })
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.getAllEmp")
				.setString("emp1", emp.getId().toString())
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		return list;
	}

	public List<TrackingSheet> findByDateRange(Date date1, Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings({ "unchecked" })
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.getRangedTs")
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public TrackingSheet getLastAddedTrackingSheet() {
		List<TrackingSheet> list = getCurrentSession().getNamedQuery(
				"TrackingSheet.getLastAddedItem").list();
		return list.get(0);
	}

	public List<TrackingSheet> getYarnReport(String knitterSize,
			String customer, String colour, String productModel, Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (knitterSize == null || knitterSize.trim().equals("-1")) {
			knitterSize = "%";
		}
		if (customer == null || customer.trim().equals("-1")) {
			customer = "%";
		}
		if (productModel == null || productModel.trim().equals("-1")) {
			productModel = "%";
		}
		@SuppressWarnings("unchecked")
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.yarnReport")
				// .setString("colourCode", colour)
				.setString("cusName", customer)
				.setString("sizeId", knitterSize)
				.setString("productId", productModel)
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		if (colour == null || colour.trim().equals("-1")) {
			return list;
		}
		List<TrackingSheet> list1 = new LinkedList<TrackingSheet>();
		boolean has = false;
		for (TrackingSheet ts : list) {
			for (Colour c : ts.getYarnColorList()) {
				if (c.getCode().equals(colour)) {
					has = true;
					break;
				}
			}
			if (has) {
				list1.add(ts);
				has = false;
			}
		}
		return list1;
	}

	public List<TrackingSheet> getYarnReportFinish(String knitterSize,
			String customer, String colour, String productModel, Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (knitterSize == null || knitterSize.trim().equals("-1")) {
			knitterSize = "%";
		}
		if (customer == null || customer.trim().equals("-1")) {
			customer = "%";
		}
		if (productModel == null || productModel.trim().equals("-1")) {
			productModel = "%";
		}
		@SuppressWarnings("unchecked")
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.reportFinish")
				// .setString("colourCode", colour)
				.setString("cusName", customer)
				.setString("sizeId", knitterSize)
				.setString("productId", productModel)
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		if (colour == null || colour.trim().equals("-1")) {
			return list;
		}
		List<TrackingSheet> list1 = new LinkedList<TrackingSheet>();
		boolean has = false;
		for (TrackingSheet ts : list) {
			for (Colour c : ts.getYarnColorList()) {
				if (c.getCode().equals(colour)) {
					has = true;
					break;
				}
			}
			if (has) {
				list1.add(ts);
				has = false;
			}
		}
		return list1;
	}

	public List<ColourPersentSum> getTotalYarnReport(Colour colour, Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("unchecked")
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.totalReport")
				// .setString("colourCode", colour)
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		List<ColourPersentSum> list1 = new LinkedList<ColourPersentSum>();
		List<Colour> listColour = new LinkedList<Colour>();
		if (colour == null || colour.equals(-1)) {
			for (TrackingSheet ts : list) {
				for (Colour c : ts.getYarnColorList()) {
					if (listColour.size() == 0) {
						listColour.add(c);
					} else {
						boolean has = false;
						for (Colour c2 : listColour) {
							if (c.equals(c2)) {
								has = true;
							}
						}
						if (has) {
						} else {
							listColour.add(c);
						}
					}
				}
			}
			for (Colour c3 : listColour) {
				colour = c3;
				double finalsum = 0;
				ColourPersentSum totalSum = new ColourPersentSum();
				for (TrackingSheet ts : list) {
					for (int k = 0; k < ts.getYarnColorList().size(); k++) {
						if (ts.getYarnColorList().get(k).equals(colour)) {
							totalSum.setColour(colour);
							finalsum = finalsum
									+ ts.getKnitterWeight()
									* ts.getProductModel().getListOfColours()
											.get(k).getPercent() / 100;
							totalSum.setSum(finalsum);
						}
					}
				}
				list1.add(totalSum);
			}
			return list1;
		} else {
			double finalsum = 0;
			ColourPersentSum totalSum = new ColourPersentSum();
			for (TrackingSheet ts : list) {
				for (int k = 0; k < ts.getYarnColorList().size(); k++) {
					if (ts.getYarnColorList().get(k).equals(colour)) {
						totalSum.setColour(colour);
						finalsum = finalsum
								+ ts.getKnitterWeight()
								* ts.getProductModel().getListOfColours()
										.get(k).getPercent() / 100;
						totalSum.setSum(finalsum);
					}
				}
			}
			list1.add(totalSum);
			return list1;
		}
	}

	public List<TrackingSheet> getYarnReportUnfinish(String knitterSize,
			String customer, String colour, String productModel, Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (knitterSize == null || knitterSize.trim().equals("-1")) {
			knitterSize = "%";
		}
		if (customer == null || customer.trim().equals("-1")) {
			customer = "%";
		}

		if (productModel == null || productModel.trim().equals("-1")) {
			productModel = "%";
		}
		@SuppressWarnings("unchecked")
		List<TrackingSheet> list = getCurrentSession()
				.getNamedQuery("TrackingSheet.reportUnfinish")
				// .setString("colourCode", colour)
				.setString("cusName", customer)
				.setString("sizeId", knitterSize)
				.setString("productId", productModel)
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		if (colour == null || colour.trim().equals("-1")) {
			return list;
		}
		List<TrackingSheet> list1 = new LinkedList<TrackingSheet>();
		boolean has = false;
		for (TrackingSheet ts : list) {
			for (Colour c : ts.getYarnColorList()) {
				if (c.getCode().equals(colour)) {
					has = true;
					break;
				}
			}
			if (has) {
				list1.add(ts);
				has = false;
			}
		}
		return list1;
	}

	/*
	 * public String generateBarcode(TrackingSheet tr) { /* int n = price /
	 * 1000; int i = price % 1000; String priceStr = Integer.toString(n); if((n
	 * / 100) == 0) { priceStr = "0" + priceStr; if((n / 10) == 0) { priceStr =
	 * "0" + priceStr; } } priceStr = priceStr + "."; String str =
	 * Integer.toString(i); if((i / 100) == 0) { priceStr = priceStr + "0";
	 * if((i / 10) == 0) { priceStr = priceStr + "0"; } } priceStr = priceStr +
	 * str + "T";
	 *//*
		 * String weight = Integer.toString(tr.getActualWeight()); if
		 * ((tr.getActualWeight() / 100) == 0) { weight = "0" + weight; if
		 * ((tr.getActualWeight() / 10) == 0) { weight = "0" + weight; } }
		 * return tr.getProductModel().getModelId() + "-" + tr.getKnitterSize()
		 * + "-" + tr.getYarnColor().substring(0, 3) + "/" +
		 * tr.getYarnColor().substring(3, 6) + "-30/2*1-" + weight +
		 * "-000.000T-" + new
		 * SimpleDateFormat("yyyyMMdd").format(tr.getEndDate()); }
		 */
	@SuppressWarnings("unchecked")
	public List<NumberAndPriceReport> getNumberAndPriceFinish(Date startDate,
			Date endDate, String customerId, String sizeId, String modelNumber,
			String colourId, TrackingSheetService trService) {
		if (colourId.equals("-1")) {
			colourId = "%";
		}
		if (customerId.equals("-1")) {
			customerId = "%";
		}
		if (sizeId.equals("-1")) {
			sizeId = "%";
		}
		List<Long> listOfInteger = getCurrentSession()
				.getNamedQuery("NumberPriceReportNumberFinish")
				.setString("colourId", colourId)
				.setString("customerId", customerId)
				.setString("sizeId", sizeId)
				.setString("productId", modelNumber)
				.setDate("date1", startDate).setDate("date2", endDate).list();
		List<NumberAndPriceReport> listOfNumberPrice = new LinkedList<NumberAndPriceReport>();
		List<Long> listOfProductModels = getCurrentSession()
				.getNamedQuery("NumberPriceReportModelFinish")
				.setString("colourId", colourId)
				.setString("customerId", customerId)
				.setString("sizeId", sizeId)
				.setString("productId", modelNumber)
				.setDate("date1", startDate).setDate("date2", endDate).list();
		for (int i = 0; i < listOfProductModels.size(); i++) {
			listOfNumberPrice.add(new NumberAndPriceReport(trService
					.get(listOfProductModels.get(i)), listOfInteger.get(i)));
		}
		return listOfNumberPrice;
	}

	@SuppressWarnings("unchecked")
	public List<NumberAndPriceReport> getNumberAndPriceUnFinish(Date startDate,
			Date endDate, String customerId, String sizeId, String modelNumber,
			String colourId, TrackingSheetService trService) {
		if (colourId.equals("-1")) {
			colourId = "%";
		}
		if (customerId.equals("-1")) {
			customerId = "%";
		}
		if (sizeId.equals("-1")) {
			sizeId = "%";
		}
		List<Long> listOfInteger = getCurrentSession()
				.getNamedQuery("NumberPriceReportNumberUnFinish")
				.setString("colourId", colourId)
				.setString("customerId", customerId)
				.setString("sizeId", sizeId)
				.setString("productId", modelNumber)
				.setDate("date1", startDate).setDate("date2", endDate).list();
		List<NumberAndPriceReport> listOfNumberPrice = new LinkedList<NumberAndPriceReport>();
		List<Long> listOfProductModels = getCurrentSession()
				.getNamedQuery("NumberPriceReportModelUnFinish")
				.setString("colourId", colourId)
				.setString("customerId", customerId)
				.setString("sizeId", sizeId)
				.setString("productId", modelNumber)
				.setDate("date1", startDate).setDate("date2", endDate).list();
		for (int i = 0; i < listOfProductModels.size(); i++) {
			listOfNumberPrice.add(new NumberAndPriceReport(trService
					.get(listOfProductModels.get(i)), listOfInteger.get(i)));
		}
		return listOfNumberPrice;
	}

	@SuppressWarnings("deprecation")
	public String getBarcode(TrackingSheet ts) {
		String barcode = "";
		if (ts.getStatus().getLabel().equalsIgnoreCase("Дууссан")) {
			String strPrice = "";
			int price = ts.getProductModel().getSellPrice();
			if (price > 0) {
				for (int i = 0; i < 6; i++) {
					int l = price % 10;
					strPrice = l + strPrice;
					price = price / 10;
					if (i == 2) {
						strPrice = "." + strPrice;
					}
				}
			} else {
				strPrice = "000.000";
			}
			strPrice = strPrice + "T";
			String colorCode1 = ts.getYarnColor().getCode().substring(0, 3);
			String colorCode2 = ts.getYarnColor().getCode().substring(3);
			String strYear = String.valueOf(ts.getEndDate().getYear() + 1900);
			String strMonth = String.valueOf(ts.getEndDate().getMonth() + 1);
			if ((ts.getEndDate().getMonth() + 1) < 10) {
				strMonth = "0" + strMonth;
			}
			String strDate = String.valueOf(ts.getEndDate().getDate());
			if (ts.getEndDate().getDate() < 10) {
				strDate = "0" + strDate;
			}
			barcode = ts.getProductModel().getModelId() + "-" + colorCode1
					+ "/" + colorCode2 + "-30/2*1-" + ts.getActualWeight()
					+ "-" + strPrice + "-" + strYear + strMonth + strDate;
		} else {
			return null;
		}
		return barcode;
	}

	private ModelReportModel trackingSheetToModelReportModel(
			TrackingSheet trackingSheet) {
		ModelReportModel modelReportModel = new ModelReportModel();
		modelReportModel.setModel(trackingSheet.getProductModel());
		modelReportModel.setColour(trackingSheet.getYarnColor());
		modelReportModel.setSizes(trackingSheet.getKnitterSize());
		modelReportModel.setQuantity(trackingSheet.getKnitterQuantity());
		modelReportModel.setBarCode(trackingSheet.getBarcode());
		modelReportModel.setWeight(trackingSheet.getActualWeight());
		modelReportModel.setCustomer(trackingSheet.getCustomer());
		return modelReportModel;
	}

	@SuppressWarnings("unchecked")
	private List<TrackingSheet> getModelReporTrackingSheetList(Date d1, Date d2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = formatter.format(d1);
		String date2 = formatter.format(d2);
		return getCurrentSession().getNamedQuery("TrackingSheet.getEndDate")
				.setString("date1", date1).setString("date2", date2).list();
	}

	private boolean hasConjuction(ModelReportModel mrm1, ModelReportModel mrm2) {
		if (mrm1.getModel().getId() == mrm2.getModel().getId()
				&& mrm1.getColour().getId() == mrm2.getColour().getId()
				&& mrm1.getSizes().getId() == mrm2.getSizes().getId()
				&& mrm1.getBarCode().equals(mrm2.getBarCode()))
			return true;
		return false;
	}

	public List<ModelReportModel> getModelReportList(Date data1, Date date2) {
		List<TrackingSheet> listTs = getModelReporTrackingSheetList(data1,
				date2);
		List<ModelReportModel> listMrm = new LinkedList<ModelReportModel>();
		int number = 0;
		for (TrackingSheet ts : listTs) {
			ModelReportModel mrm = trackingSheetToModelReportModel(ts);
			if (listMrm.isEmpty()) {
				mrm.setNumber(++number);
				listMrm.add(mrm);
			} else {
				if (hasConjuction(mrm, listMrm.get(listMrm.size() - 1))) {
					ModelReportModel mrm1 = listMrm.get(listMrm.size() - 1);
					mrm1.setQuantity(mrm1.getQuantity() + mrm.getQuantity());
				} else {
					mrm.setNumber(++number);
					listMrm.add(mrm);
				}
			}
		}
		return listMrm;
	}

	@SuppressWarnings("unchecked")
	public List<TrackingSheet> getTrackingSheetModelId(String id) {
		return getCurrentSession()
				.getNamedQuery("TrackingSheet.getTrackingSheet")
				.setString("id", id).list();
	}

	public void log(Object obj, String message) {
		TrackingSheet ts = (TrackingSheet) obj;
		LOG.info("TrackingSheet " + message + " : startnumber: "
				+ ts.getStartNumber() + sep + " quantity: "
				+ ts.getKnitterQuantity() + sep + " weight: "
				+ ts.getKnitterWeight() + sep + "model: "
				+ ts.getProductModel().getModelId() + sep + "bonus: "
				+ ts.getBonus().getName());
	}

	public List<Colour> strListToColourList(List<String> intList,
			ColourService colourService) {
		List<Colour> colours = new LinkedList<Colour>();
		for (String s : intList) {
			colours.add(colourService.get(Long.parseLong(s)));
		}
		return colours;
	}
}
