package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.StollPrice;

public class StollPriceService extends GenericEntityService<StollPrice, Long>
{
	@Override
	protected Class<StollPrice> entityClass()
	{
		return StollPrice.class;
	}
	
	@SuppressWarnings("unchecked")
	public StollPrice getRealPrice()
	{
		StollPrice stollPrice = null;
		List<StollPrice> stollPriceList = getCurrentSession().getNamedQuery("StollPrice.getRealStollPrice").list();
		if (stollPriceList.size() > 0)
		{
			stollPrice = stollPriceList.get(0);
		}
		return stollPrice;
	}
}