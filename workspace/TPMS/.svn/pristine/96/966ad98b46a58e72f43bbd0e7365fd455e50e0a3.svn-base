package mn.threesor.tims.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mn.threesor.tims.model.TrackingSheet;

public class BarcodeService {

	@SuppressWarnings("rawtypes")
	public String getBarCode(String customer, TrackingSheet ts)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class[] types = new Class[1];
		types[0] = TrackingSheet.class;
		Method method = BarcodeService.class.getMethod(customer, types);
		BarcodeService barcodeService = new BarcodeService();
		Object[] objs = new Object[1];
		objs[0] = ts;
		Object object = method.invoke(barcodeService, objs);
		return (String) object;
	}

	@SuppressWarnings("deprecation")
	public String threeSor(TrackingSheet ts) {
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

	public String tsasSogoot(TrackingSheet ts) {
		return "";
	}

}
