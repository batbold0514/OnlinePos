package mn.infosystems.estimator.service;

import java.util.LinkedList;
import java.util.List;

import mn.infosystems.estimator.model.PartPrice;

public class PartPriceService extends GenericEntityService<PartPrice, Long>{

	@Override
	protected Class<PartPrice> entityClass() {
		return PartPrice.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<PartPrice> getPartPrices(String d1,String d2,Integer fd1,Integer fd2,String fid,String mid,String name){
		List<PartPrice> list = getCurrentSession().getNamedQuery("partprice.get").setString("d1", d1)
				.setString("d2", d2)
				.setString("fid", fid).setString("mid", mid)
				.setInteger("fd1", fd1).setInteger("fd2", fd2)
				.setString("name", name).list();
		return (list==null)?new LinkedList<PartPrice>():list;
	}

}
