package org.jumia.exercise.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Customer Entity
 */
@Entity(name = "Customer")
public class CustomerEntity {
    @Id
    private Long id;
    private String name;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}