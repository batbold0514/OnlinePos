package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.Payment;

public class PaymentServiceTest extends AbstractModelServiceSpringContextTest{
	PaymentService paymentService;
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.paymentService = (PaymentService) getApplicationContext()
				.getBean("paymentService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(paymentService);
	}
	public void testSaveAndGet() throws Exception {
		startTransaction();
		 
		try {
			Long id = paymentService.save(new Payment(PaymentMethod.CARD,5000,"хэвийн"));
			Payment payment = paymentService.get(id);
			assertNotNull(payment);
			assertEquals(PaymentMethod.CARD, payment.getPaymentMethod());
			assertEquals(5000, payment.getValue());
			assertEquals("хэвийн", payment.getDescription());
		} finally {
			rollback();
		}
	}
}
