package pl.RemigiuszInstalacje.infrastructure.db.repository;

import lombok.AllArgsConstructor;
import pl.RemigiuszInstalacje.business.dao.CustomerDao;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.infrastructure.db.entity.CustomerEntity;
import pl.RemigiuszInstalacje.infrastructure.db.repository.jpa.CustomerJpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.repository.mapper.CustomerEntityMapper;

@AllArgsConstructor
public class CustomerRepository implements CustomerDao {

    private final CustomerEntityMapper customerEntityMapper;
    private final CustomerJpaRepository customerJpaRepository;
    @Override
    public Customer findCustomerById(Integer id) {
        return customerEntityMapper
                .mapFromEntity(
                        customerJpaRepository
                                .findById(id)
                                .orElseThrow(() ->
                                        new ResourceNotExistException("Customer with id [%d] not exist".formatted(id))));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        CustomerEntity buildEntity = customerEntityMapper.mapToEntity(customer);

        return customerEntityMapper.mapFromEntity(customerJpaRepository.saveAndFlush(buildEntity));
    }
}
