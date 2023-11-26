package pl.RemigiuszInstalacje.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.RemigiuszInstalacje.business.dao.CustomerDao;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;

@Service
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

    @Transactional
    public Customer updateCustomer(Integer customerId, Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Transactional
    public Customer saveCustomer(Customer customer){
        return customerDao.saveCustomer(customer);
    }
}
