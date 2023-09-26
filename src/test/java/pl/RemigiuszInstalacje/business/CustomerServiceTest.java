package pl.RemigiuszInstalacje.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.RemigiuszInstalacje.business.dao.CustomerDao;
import pl.RemigiuszInstalacje.domain.Customer;
import pl.RemigiuszInstalacje.domain.exception.ResourceNotExistException;
import pl.RemigiuszInstalacje.util.DomainFixtures;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findCustomerByIdShouldReturnWhenCustomerIsFound(){
        //given
        Integer id = 1;
        Customer customer = DomainFixtures.someCustomer();

        //when
        Mockito.when(customerDao.findCustomerById(id)).thenReturn(customer);
        Customer customerFound = customerService.findCustomerById(id);

        //then
        Assertions.assertEquals(customer, customerFound);
    }

    @Test
    void findCustomerByIdShouldThrowWhenCustomerNotFound(){
        //given
        Integer id = 1;
        String message = "Customer with id [%d] not exist".formatted(id);

        //when
        Mockito.when(customerDao.findCustomerById(id)).thenThrow();
        ResourceNotExistException exception =
                Assertions.assertThrows(ResourceNotExistException.class, () -> customerService.findCustomerById(id));

        //then
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    void updateCustomerShouldUpdateWhenCustomerExist(){
        //given
        Customer customer = DomainFixtures.someCustomer();
        String newName = "newName";
        Customer expectCustomer = customer.withName(newName);

        //when
        Mockito.when(customerDao.updateCustomer(expectCustomer)).thenReturn(expectCustomer);

        Customer result = customerService.updateCustomer(customer.id(), expectCustomer);

        //then
        Assertions.assertEquals(expectCustomer, result);
        Assertions.assertEquals(newName, result.name());
    }

}