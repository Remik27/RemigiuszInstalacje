package pl.RemigiuszInstalacje.business.dao;

import pl.RemigiuszInstalacje.domain.Customer;

public interface CustomerDao {
    Customer findCustomerById(Integer id);
}
