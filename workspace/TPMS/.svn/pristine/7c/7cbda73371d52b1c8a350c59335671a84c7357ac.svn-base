package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.ProductModelCode;

public class ProductModelCodeService extends
		GenericEntityService<ProductModelCode, Long> {

	@Override
	protected Class<ProductModelCode> entityClass() {
		return ProductModelCode.class;
	}

	@SuppressWarnings("unchecked")
	public Long saveProductModelCode(ProductModelCode pmc)
	{
		Long id = null;
		List<ProductModelCode> list = getCurrentSession()
				.getNamedQuery("ProductModelCode.getLastModelId")
				.setString("category", pmc.getCategory())
				.setString("material", pmc.getMaterial())
				.setString("gauge", pmc.getGauge())
				.setString("productType", pmc.getProductType()).list();
		
		if(list.isEmpty())
		{
			pmc.setNumber("001");
			id = save(pmc);
		}
		else
		{
			ProductModelCode pmc1 = (ProductModelCode) list.get(0);
			int number = Integer.parseInt(pmc1.getNumber()) + 1;
			if(number < 10)
			{
				pmc.setNumber("00" + Integer.toString(number));
			}
			else if(number < 100)
			{
				pmc.setNumber("0" + Integer.toString(number));
			}
			else
			{
				pmc.setNumber(Integer.toString(number));
			}
			id = save(pmc);
		}
		return id;

	}
	
	
	@SuppressWarnings("unchecked")
	public String getNumber(ProductModelCode pmc){
		List<ProductModelCode> list = getCurrentSession()
				.getNamedQuery("ProductModelCode.getLastModelId")
				.setString("category", pmc.getCategory())
				.setString("material", pmc.getMaterial())
				.setString("gauge", pmc.getGauge())
				.setString("productType", pmc.getProductType()).list();
		if(list.isEmpty()){
			return "001";
		}
		else{
			ProductModelCode pmc1 = (ProductModelCode) list.get(0);
			int number = Integer.parseInt(pmc1.getNumber()) + 1;
			if(number < 10)
			{
				pmc.setNumber("00" + Integer.toString(number));
			}
			else if(number < 100)
			{
				pmc.setNumber("0" + Integer.toString(number));
			}
			else
			{
				pmc.setNumber(Integer.toString(number));
			}
			return pmc.getNumber();
		}
	}
	
	public String getLastAddModelCode(){
		ProductModelCode pmc = (ProductModelCode) getCurrentSession().getNamedQuery("ProductModelCode.getLastAdd").list().get(0);
		return pmc.takeProductModelCode();
	}
	@SuppressWarnings("unchecked")
	public void deleteCurrentModelCode(String model){
		List<ProductModelCode> list = getCurrentSession().getNamedQuery("ProductModelCode.getCode")
				.setString("category", model.substring(2, 3))
				.setString("material", model.substring(0, 2))
				.setString("gauge", model.substring(4, 6))
				.setString("type", model.substring(7, 9))
				.setString("number", model.substring(10))
				.list();
		if(!list.isEmpty()){
			delete(get(list.get(0).getId()));
		}
	}
	
	public boolean checkCode(ProductModelCode pmc){
		return getCurrentSession().getNamedQuery("ProductModelCode.getCode").setString("category",pmc.getCategory())
				.setString("material", pmc.getMaterial())
				.setString("gauge", pmc.getGauge())
				.setString("type", pmc.getProductType())
				.setString("number", pmc.getNumber())
				.list().isEmpty()?true:false;
	}
}