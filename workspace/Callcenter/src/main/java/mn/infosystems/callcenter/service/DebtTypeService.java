package mn.infosystems.callcenter.service;

import java.util.List;

import mn.infosystems.callcenter.model.DebtType;

public class DebtTypeService extends GenericEntityService<DebtType, Long>{

	@Override
	protected Class<DebtType> entityClass() {
		return DebtType.class;
	}

	/**
	 * @param number
	 * @return өрийн төрөл
	 * @see Татварын дугаараар хайж тухайн өрийн төрлийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public DebtType getDebtTypeByNumber(String number){
		List<DebtType> list = getCurrentSession().getNamedQuery("debtType.getByNumber").setString("number", number).list();
		if(list.isEmpty()) return null;
		else return list.get(0);
	}
	/**
	 * @param id
	 * @return int 
	 * @see Тухайн татвар төлөгчид харгалзах хамгийн их залгасан тоо
	 */
	@SuppressWarnings("unchecked")
	public int getDebtMaxNumber(Long id,int callQuantity){
		List<Integer> list = getCurrentSession().getNamedQuery("debt.getMaxQuantity").setLong("id", id).setInteger("callQuantity", callQuantity).list();
		if( list.isEmpty()){
			return 0;
		}
		if(list.get(0) == null){
			return 0;
		}
		return  list.get(0);
	}
	
}
