package pl.RemigiuszInstalacje.infrastructure.db.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.RemigiuszInstalacje.business.dao.CustomerDao;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.infrastructure.db.entity.CustomerEntity;
import pl.RemigiuszInstalacje.infrastructure.db.repository.jpa.CustomerJpaRepository;
import pl.RemigiuszInstalacje.infrastructure.db.repository.mapper.CustomerEntityMapper;

@AllArgsConstructor
@Repository
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

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.mapToEntity(customer);

        return customerEntityMapper.mapFromEntity(customerJpaRepository.saveAndFlush(customerEntity));
    }

    @Override
    public Customer findCustomerByEmail(String email) {

        return customerEntityMapper
                .mapFromEntity(
                        customerJpaRepository.findByEmail(email)
                                .orElseThrow(() -> new ResourceNotExistException("Customer with email [%s] not found"
                                        .formatted(email))));
    }
}
