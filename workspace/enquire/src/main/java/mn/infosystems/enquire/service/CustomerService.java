package mn.infosystems.enquire.service;

import java.util.List;

import mn.infosystems.enquire.model.Customer;

public class CustomerService extends GenericEntityService<Customer, Long>{

	@Override
	protected Class<Customer> entityClass() {
		// TODO Auto-generated method stub
		return Customer.class;
	}
	public Customer getCustomer(String enquireName){
		@SuppressWarnings("unchecked")
		List<Customer> list = getCurrentSession().getNamedQuery("customer.getByEnquireName").setString("enquireName", enquireName).list();
		return list.isEmpty()?null:list.get(0);
		
	}

}
