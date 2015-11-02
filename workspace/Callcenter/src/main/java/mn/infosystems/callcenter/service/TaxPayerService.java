package mn.infosystems.callcenter.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import mn.infosystems.callcenter.enums.TaxpayerStatus;
import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.Debtx;
import mn.infosystems.callcenter.model.PhoneNumber;
import mn.infosystems.callcenter.model.TaxPayer;

public class TaxPayerService extends GenericEntityService<TaxPayer, Long>{

	@Override
	protected Class<TaxPayer> entityClass() {
		return TaxPayer.class;
	}
	
	/**
	 * @param limit 
	 * @return эхний limit ширхэг avgPay-с буюу дээш хоногт татвараа төлдөг татвар төлөгчийн мэдээллийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<TaxPayer> getTaxPayer(int limit , int avgPay){
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(new Date());
		String dateStr1 = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH) + " 00:00:00.000";
		String dateStr2 = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH) + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("taxpayer.get").setInteger("day", avgPay).setString("d1", dateStr1).setString("d2", dateStr2).setMaxResults(limit).list();
	}
//
//
	/**
	 * @param taxPayer
	 * @return Өрийг өргөтгөсөн бүтцийн жагсаалт
	 * @see Өрүүдийн индексийг бодож буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Debtx> getDebtxList(TaxPayer taxPayer){
		List<Debtx> list = new LinkedList<Debtx>();
		for(Debt debt:taxPayer.getActiveDebtList()){
			if(debt.getPayDate()==null && debt.getStartDate().equals(TaxpayerStatus.ACTIVE)){
				Debtx debtx = new Debtx();
				debtx.setDebt(debt);
				List<Integer> listofinteger = getCurrentSession().getNamedQuery("moneyIndex.getIndex").setDouble("balance", debt.getBalance()).list();
				if(!listofinteger.isEmpty())
					debtx.setBalanceIndex(listofinteger.get(0));
				List<Integer> listofinteger1 = getCurrentSession().getNamedQuery("dateIndex.getIndex").setInteger("balance", getDifference(debt.getEndDate())).list();
				debtx.setDate(getDifference(debt.getEndDate()));
				if(!listofinteger1.isEmpty())
					debtx.setDateIndex(listofinteger1.get(0));
				list.add(debtx);
			}
		}
		return list;
	}
	
	/**
	 * @param number татвар төлөгчийн дугаар
	 * @return татвар төлөгч
	 * @see number гэсэн дугаартай татвар төлөгчийг буцаана. хэрэв олдохгүй бол null буцаана
	 */
	@SuppressWarnings("unchecked")
	public TaxPayer getTaxPayerByNumber(String number){
		List<TaxPayer> list = getCurrentSession().getNamedQuery("taxPayer.getByNumber").setString("number", number).list();
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	/**
	 * @param phone
	 * @return Татвар төлөгч
	 * @see Тухайн дугаартай татвар төлөгчийг олно
	 */
	@SuppressWarnings("unchecked")
	public TaxPayer getTaxPayer(String phone){
		List<TaxPayer> list = getCurrentSession().getNamedQuery("taxpayer.phoneNumber").setString("phoneNumber", phone).list();
		if(list.isEmpty()){
			list = getCurrentSession().getNamedQuery("phoneNumber.phoneNumber").setString("phoneNumber", phone).list();
				if(list.isEmpty()){
					return null;
				}
		}
			return list.get(0);
	}
	
	/**
	 * @param end
	 * @return өдрийн тоо
	 * @see заасан огноо болон одоогийн огнооны хоорондох өдрийн зөрүүг буцаана 
	 */
	private int getDifference(Date end){ 
		Date now = new Date();
		long diff = end.getTime()-now.getTime();
		return (int) (diff/(1000*60*60*24));
	}

}
