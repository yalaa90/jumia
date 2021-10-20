package org.jumia.exercise.service;

import org.jumia.exercise.domain.CustomerEntity;
import org.jumia.exercise.dto.CustomerDTO;
import org.jumia.exercise.dto.CustomerResponseBodyDTO;
import org.jumia.exercise.dto.FilterParametersDTO;
import org.jumia.exercise.repository.CustomerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Customer logic bean
 */
@Service
public class CustomerService {

    private static final String VALID = "valid";

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * return customer based on filter
     * @param filterParametersDTO
     * @return CustomerResponseBodyDTO
     */
    public CustomerResponseBodyDTO getCustomers(FilterParametersDTO filterParametersDTO) {

        Pageable page = PageRequest.of(filterParametersDTO.getPageNum(), filterParametersDTO.getPageSize());
        int start = (int) page.getOffset();
        Example<CustomerEntity> customerEntityExample = getCustomerExample(filterParametersDTO);

        List<CustomerEntity> customerEntityList = customerRepository.findAll(customerEntityExample);

        if (ValidationService.isNotNullOrNotEmptyString(filterParametersDTO.getState())) {
            customerEntityList = filterCustomerByState(filterParametersDTO.getState(), customerEntityList);
        }
        final int end = Math.min((start + page.getPageSize()), customerEntityList.size());
        System.out.println(start + " / " + end);
        return new CustomerResponseBodyDTO(customerEntityList.size(), CustomerDTO.convertToCustomerDTO(customerEntityList.subList(start, end)));
    }

    private List<CustomerEntity> filterCustomerByState(final String state, final List<CustomerEntity> customerEntityList) {
        if (VALID.equals(state)) {
            return customerEntityList.stream()
                    .filter((CustomerEntity customerEntity) -> ValidationService.isValidPhoneNumber(customerEntity.getPhone()))
                    .collect(Collectors.toList());

        } else {
            return customerEntityList.stream()
                    .filter((CustomerEntity customerEntity) -> ValidationService.isNotValidPhoneNumber(customerEntity.getPhone()))
                    .collect(Collectors.toList());
        }

    }

    private Example<CustomerEntity> getCustomerExample(FilterParametersDTO filterParametersDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPhone(filterParametersDTO.getCode());
        return Example.of(customerEntity, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreNullValues());
    }
}
