package pl.RemigiuszInstalacje.business;

import lombok.AllArgsConstructor;
import pl.RemigiuszInstalacje.business.dao.CustomerDao;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;

@AllArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public Customer findCustomerById(Integer customerId) {
        try {
            return customerDao.findCustomerById(customerId);
        } catch (Exception e) {
            throw new ResourceNotExistException("Customer with id [%d] not exist".formatted(customerId));
        }

    }

    public Customer updateCustomer(Integer customerId, Customer customer) {

        return null;
    }
}
