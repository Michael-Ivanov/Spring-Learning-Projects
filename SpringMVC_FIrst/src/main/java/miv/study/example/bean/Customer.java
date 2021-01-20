package miv.study.example.bean;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "field is required")
//    @Size(min = 1, message = "must be at least 1 symbol")
    private String lastName;

    @NotNull(message = "field is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to ten")
    private Integer freePasses;

    @NotNull(message = "field is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits/chars")
    private String postalCode;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
