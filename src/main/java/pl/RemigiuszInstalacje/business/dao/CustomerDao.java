package pl.RemigiuszInstalacje.business.dao;

import pl.RemigiuszInstalacje.domain.Customer;

public interface CustomerDao {
    Customer findCustomerById(Integer id);

    Customer updateCustomer(Customer customer);

    Customer saveCustomer(Customer customer);

    Customer findCustomerByEmail(String email);
}
