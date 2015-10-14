package mn.threesor.wms.service;

import mn.threesor.wms.model.Customer;

public class CustomerService extends GenericEntityService<Customer, Long> {
	@Override
	protected Class<Customer> entityClass() {
		return Customer.class;
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
	
	public Long getLassAddId(){
		return (Long)getCurrentSession().getNamedQuery("Customer.getLastAdd").list().get(0);
	}

}
