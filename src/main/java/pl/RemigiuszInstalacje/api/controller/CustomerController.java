package pl.RemigiuszInstalacje.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.RemigiuszInstalacje.api.dto.CustomerDto;
import pl.RemigiuszInstalacje.api.dto.mapper.CustomerMapper;
import pl.RemigiuszInstalacje.business.CustomerService;
import pl.RemigiuszInstalacje.domain.Customer;

@RestController
@RequestMapping(CustomerController.CUSTOMER_API)
@AllArgsConstructor
public class CustomerController {
    public static final String CUSTOMER_API = "/customer";

    // todo should create customer here or in user create controller public static final String ADD_CUSTOMER = "/add-customer";
    public static final String UPDATE_CUSTOMER = "/update-customer{customerId}";
    public static final String GET_CUSTOMER = "/get-customer{customerId}";


    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping(GET_CUSTOMER)
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) {

        Customer customer = customerService.findCustomerById(customerId);
        CustomerDto customerDto = customerMapper.mapToDto(customer);

        return ResponseEntity.ok(customerDto);
    }

    @PatchMapping(UPDATE_CUSTOMER)
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Integer customerId,
                                                      @Valid @RequestBody CustomerDto customerDto) {

        Customer customer = customerMapper.mapFromDto(customerDto);

        Customer customerUpdated = customerService.updateCustomer(customerId, customer);
        CustomerDto customerDtoUpdated = customerMapper.mapToDto(customerUpdated);
        return ResponseEntity.ok(customerDtoUpdated);
    }


}


