package org.jumia.exercise.service;

import org.jumia.exercise.dto.CustomerResponseBodyDTO;
import org.jumia.exercise.dto.FilterParametersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceTests {
    @Autowired
    private CustomerService customerService;

    @Test
    void getCustomers() {
        FilterParametersDTO filterParametersDTO = new FilterParametersDTO(null, null, 0, 10);
        assertCustomerResult(filterParametersDTO);

    }

    @Test
    void getValidCustomers() {
        FilterParametersDTO filterParametersDTO = new FilterParametersDTO(null, "valid", 0, 10);
        assertCustomerResult(filterParametersDTO);

    }

    @Test
    void filterByCustomerCountry() {
        FilterParametersDTO filterParametersDTO = new FilterParametersDTO("(212)", null, 0, 10);
        assertCustomerResult(filterParametersDTO);
    }

    @Test
    void filterByNotValidCustomerPhone() {
        FilterParametersDTO filterParametersDTO = new FilterParametersDTO("(212)", "notValid", 0, 10);
        assertCustomerResult(filterParametersDTO);
    }

    private void assertCustomerResult(FilterParametersDTO filterParametersDTO) {
        CustomerResponseBodyDTO customerResponseBodyDTO = customerService.getCustomers(filterParametersDTO);
        assertThat(customerResponseBodyDTO).isNotNull();
        assertThat(customerResponseBodyDTO.getTotalNum()).isGreaterThan(0);
        assertThat(customerResponseBodyDTO.getCustomerDtoList()).isNotNull();
        assertThat(customerResponseBodyDTO.getCustomerDtoList()).isNotEmpty();
    }


}
