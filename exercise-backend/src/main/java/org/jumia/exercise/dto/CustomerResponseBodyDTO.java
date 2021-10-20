package org.jumia.exercise.dto;

import java.util.List;

/**
 * Response Body
 */
public class CustomerResponseBodyDTO {
    private final int totalNum;
    private final List<CustomerDTO> CustomerDtoList;

    public CustomerResponseBodyDTO(int totalNum, List<CustomerDTO> customerDTO) {
        this.totalNum = totalNum;
        CustomerDtoList = customerDTO;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public List<CustomerDTO> getCustomerDtoList() {
        return CustomerDtoList;
    }
}
