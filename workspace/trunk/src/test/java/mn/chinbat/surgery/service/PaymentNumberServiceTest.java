package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.PaymentNumberCounter;

public class PaymentNumberServiceTest extends
		AbstractModelServiceSpringContextTest {
	PaymentNumberService numberService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.numberService = (PaymentNumberService) getApplicationContext()
				.getBean("numberService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(numberService);
	}
	
	public void testCounter() throws Exception {
		startTransaction();
		try {
			Long id = numberService.save(new PaymentNumberCounter());
			PaymentNumberCounter paymentNumberCounter = numberService.get(id);
			assertNotNull(paymentNumberCounter);
			
			String nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.CASH);
			assertEquals("A-00000001", nextPaymentNumber);
			assertTrue(1==paymentNumberCounter.getCash());
			assertTrue(0==paymentNumberCounter.getCard());
			assertTrue(0==paymentNumberCounter.getBankTransfer());
			assertTrue(0==paymentNumberCounter.getMoneyBack());
			
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.CARD);
			assertEquals("B-00000001", nextPaymentNumber);
			assertTrue(1==paymentNumberCounter.getCash());
			assertTrue(1==paymentNumberCounter.getCard());
			assertTrue(0==paymentNumberCounter.getBankTransfer());
			assertTrue(0==paymentNumberCounter.getMoneyBack());
			
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.TRANSFER);
			assertEquals("C-00000001", nextPaymentNumber);
			assertTrue(1==paymentNumberCounter.getCash());
			assertTrue(1==paymentNumberCounter.getCard());
			assertTrue(1==paymentNumberCounter.getBankTransfer());
			assertTrue(0==paymentNumberCounter.getMoneyBack());
			
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.MONEY_BACK);
			assertEquals("D-00000001", nextPaymentNumber);
			assertTrue(1==paymentNumberCounter.getCash());
			assertTrue(1==paymentNumberCounter.getCard());
			assertTrue(1==paymentNumberCounter.getBankTransfer());
			assertTrue(1==paymentNumberCounter.getMoneyBack());
			
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.MONEY_BACK);
			assertEquals("D-00000002", nextPaymentNumber);
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.MONEY_BACK);
			assertEquals("D-00000003", nextPaymentNumber);
			nextPaymentNumber = numberService.getNextPaymentNumber(PaymentMethod.MONEY_BACK);
			assertEquals("D-00000004", nextPaymentNumber);
			
			assertTrue(1==paymentNumberCounter.getCash());
			assertTrue(1==paymentNumberCounter.getCard());
			assertTrue(1==paymentNumberCounter.getBankTransfer());
			assertTrue(4==paymentNumberCounter.getMoneyBack());
		} finally {
			rollback();
		}
	}

}
