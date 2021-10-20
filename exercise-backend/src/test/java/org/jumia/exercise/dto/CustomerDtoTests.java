package org.jumia.exercise.dto;

import org.jumia.exercise.domain.CustomerEntity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDtoTests {
    @Test
    void testConvertToCustomerDTO() {
        List<CustomerDTO> customerDTOS = CustomerDTO.convertToCustomerDTO(getFakeCustomerEntityList());
        assertThat(customerDTOS).isNotNull();
        assertThat(customerDTOS.get(0)).isNotNull();
        assertThat(customerDTOS.get(0).getCode()).isEqualTo("212");
        assertThat(customerDTOS.get(0).getCountry()).isEqualTo("Morocco");
        assertThat(customerDTOS.get(0).isValid()).isEqualTo(false);
        assertThat(customerDTOS.get(1).isValid()).isEqualTo(true);


    }

    private List<CustomerEntity> getFakeCustomerEntityList() {
        CustomerEntity entity1 = new CustomerEntity();
        entity1.setId(1l);
        entity1.setName("testName1");
        entity1.setPhone("(212) 12345678");
        CustomerEntity entity2 = new CustomerEntity();
        entity2.setId(2l);
        entity2.setName("testName2");
        entity2.setPhone("(258) 846565883");
        /*CustomerEntity entity3 = new CustomerEntity();
        entity1.setId(3l);
        entity1.setName("testName3");
        entity1.setPhone("testPhone3");*/
        return Arrays.asList(entity1, entity2);
    }
}
