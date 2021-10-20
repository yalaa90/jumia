package org.jumia.exercise.controller;

import org.jumia.exercise.domain.CustomerEntity;
import org.jumia.exercise.dto.CustomerDTO;
import org.jumia.exercise.dto.CustomerResponseBodyDTO;
import org.jumia.exercise.dto.FilterParametersDTO;
import org.jumia.exercise.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;


@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    void getCustomersTest() throws Exception {
        CustomerResponseBodyDTO customerResponseBodyDTO = new CustomerResponseBodyDTO(1, null);
        Mockito.when(customerService.getCustomers(getEmptyFilterParamDto())).thenReturn(customerResponseBodyDTO);
        mockMvc.perform(get("/customers").param("pageNum", "1").param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private FilterParametersDTO getEmptyFilterParamDto() {
        return new FilterParametersDTO(null, null, 1, 10);
    }

}
