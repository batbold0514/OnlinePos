package mn.threesor.tims.service;

import mn.threesor.tims.model.Customer;

public class CustomerService extends GenericEntityService<Customer, Long> implements TpmsLogger
{
	@Override
	protected Class<Customer> entityClass()
	{
		return Customer.class;
	}

	public void log(Object obj,String message) {
		Customer cstmr = (Customer) obj;
		LOG.info("Customer : "+message+" name: "+cstmr.getName());
	}
	public boolean check(String name, Long id) {
		if (id == null)
			return getCurrentSession().getNamedQuery("Customer.check")
					.setString("name", name).setLong("id", -1l).list()
					.isEmpty() ? false : true;
		return getCurrentSession().getNamedQuery("Customer.check")
				.setString("name", name).setLong("id", id).list().isEmpty() ? false
				: true;
	}
}
