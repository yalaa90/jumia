package org.jumia.exercise.controller;

import org.jumia.exercise.dto.CustomerResponseBodyDTO;
import org.jumia.exercise.dto.FilterParametersDTO;
import org.jumia.exercise.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Customer endpoint where frontend call backend
 */
@RestController
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     *
     * @param filterParametersDTO search paramaters
     * @return ResponseEntity<CustomerResponseBodyDTO>
     */
    @GetMapping("customers")
    public ResponseEntity<CustomerResponseBodyDTO> getCustomers(FilterParametersDTO filterParametersDTO) {
        return ResponseEntity.ok(customerService.getCustomers(filterParametersDTO));
    }

}
