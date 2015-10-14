package mn.threesor.tims.service;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.model.Bonus;

public class BonusServiceTest extends AbstractModelServiceSpringContextTest	{
	BonusService bonusService;
	
	@Override
	protected void onSetUp() throws Exception{
		super.onSetUp();
		this.bonusService = (BonusService) getApplicationContext().getBean("bonusService");
	}
	
	public void testServiceAvailable() throws Exception{
		assertNotNull(bonusService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			Bonus bonus = new Bonus();
			bonus.setName("sample");
			bonus.setValue(11);
			Long id = bonusService.save(bonus);
			bonus = bonusService.get(id);
			assertEquals(id, bonus.getId());
			assertEquals("sample", bonus.getName());
			assertEquals(11, bonus.getValue());
		}finally{
			rollback();
		}
	}
}
