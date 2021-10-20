package org.jumia.exercise.dto;

import org.jumia.exercise.domain.CustomerEntity;
import org.jumia.exercise.service.ValidationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Customer data transfer object
 */
public class CustomerDTO {
    private String country;
    private String code;
    private String phone;
    private boolean isValid;

    public CustomerDTO(String country, String code, String phone, boolean isValid) {
        this.country = country;
        this.code = code;
        this.phone = phone;
        this.isValid = isValid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    /**
     * convert method from List of customer entity to CustomerDTO
     * @param customerEntityList
     * @return List<CustomerDTO>
     */
    public static List<CustomerDTO> convertToCustomerDTO(List<CustomerEntity> customerEntityList) {
        return customerEntityList.stream().map((CustomerEntity cs) -> {
            return new CustomerDTO(ValidationService.getCountryName(cs.getPhone()),
                    ValidationService.getCountryCode(cs.getPhone()),
                    cs.getPhone(), ValidationService.isValidPhoneNumber(cs.getPhone())
            );
        }).collect(Collectors.toList());
    }
}
