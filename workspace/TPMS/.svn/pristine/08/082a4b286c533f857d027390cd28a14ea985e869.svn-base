package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.ProductType;

public class ProductTypeService extends GenericEntityService<ProductType, Long>
		implements TpmsLogger {

	@Override
	protected Class<ProductType> entityClass() {
		return ProductType.class;
	}

	@SuppressWarnings("unchecked")
	public List<ProductType> getActiveProductTypeList() {
		return getCurrentSession().getNamedQuery("productType.getActiveList")
				.list();
	}

	@SuppressWarnings("unchecked")
	public ProductType getProductType(String prefix) {
		List<ProductType> list = getCurrentSession()
				.getNamedQuery("productType.get").setString("prefix", prefix)
				.list();
		return list.isEmpty() ? null : list.get(0);
	}

	public void log(Object obj, String message) {
		ProductType pt = (ProductType) obj;
		LOG.info("ProductType " + message + " : " + pt.getPrefix() + " "
				+ pt.getName());
	}
}
