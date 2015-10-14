package mn.chinbat.surgery.service;

import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.PaymentNumberCounter;

public class PaymentNumberService extends
		GenericEntityService<PaymentNumberCounter, Long> {

	@Override
	protected Class<PaymentNumberCounter> entityClass() {
		return PaymentNumberCounter.class;
	}

	private String getNumberWithLeadingNulls(long number) {
		
		String stringNr = String.valueOf(number);
		int size = 8-stringNr.length();
		char[] nulls = new char[size];
		for (int i = 0; i < size; i++)
			nulls[i] = '0';
		return String.valueOf(nulls)+stringNr;
	}

	public String getNextPaymentNumber(PaymentMethod paymentMethod) {
		PaymentNumberCounter counter = (PaymentNumberCounter) getCurrentSession()
				.getNamedQuery("PaymentNumberCounterQuerry").list().get(0);
		switch (paymentMethod) {
		case CASH:
			counter.setCash(counter.getCash()+1);
			return PaymentMethod.CASH.getPrefix()+ getNumberWithLeadingNulls(counter.getCash());
		case CARD:
			counter.setCard(counter.getCard()+1);
			return PaymentMethod.CARD.getPrefix()+ getNumberWithLeadingNulls(counter.getCard());
		case TRANSFER:
			counter.setBankTransfer(counter.getBankTransfer()+1);
			return PaymentMethod.TRANSFER.getPrefix()+ getNumberWithLeadingNulls(counter.getBankTransfer());
		case MONEY_BACK:
			counter.setMoneyBack(counter.getMoneyBack()+1);
			return PaymentMethod.MONEY_BACK.getPrefix()+ getNumberWithLeadingNulls(counter.getMoneyBack());
		case ALL:
			return "ERROR";
		default:
			return "ERROR";
		}
	}

}
