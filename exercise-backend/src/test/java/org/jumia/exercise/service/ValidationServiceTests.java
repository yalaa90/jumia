package org.jumia.exercise.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationServiceTests {

    @Test
    void validPhoneTest() {
        assertThat(ValidationService.isValidPhoneNumber("")).isFalse();
        assertThat(ValidationService.isValidPhoneNumber(null)).isFalse();
        assertThat(ValidationService.isValidPhoneNumber("(258) 84330678235")).isFalse();
        assertThat(ValidationService.isValidPhoneNumber("(258) 823747618")).isTrue();
    }
    @Test
    void getCountryTest(){
        assertThat(ValidationService.getCountryName("(258) 823747618")).isEqualTo("Mozambique");
        assertThat(ValidationService.getCountryName("(237) 823747618")).isEqualTo("Cameroon");
        assertThat(ValidationService.getCountryName("(251) 823747618")).isEqualTo("Ethiopia");
        assertThat(ValidationService.getCountryName("(212) 823747618")).isEqualTo("Morocco");
        assertThat(ValidationService.getCountryName("(256) 823747618")).isEqualTo("Uganda");
        assertThat(ValidationService.getCountryName(null)).isEqualTo(null);
        assertThat(ValidationService.getCountryName("")).isEqualTo(null);
        assertThat(ValidationService.getCountryName("wrongValue")).isEqualTo(null);
    }
}
