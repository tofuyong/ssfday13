package ibf2022.ssf.day13.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {

    @NotEmpty(message = "First name is a mandatory field")
    @Size(min=2, max=150, message="First name must be between 2 to 100 characters")
    private String firstName;

    @NotEmpty(message = "Last name is a mandatory field")
    @Size(min=2, max=150, message="Last name must be between 2 to 100 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    // @Pattern(regexp = ".+@.+//..+", message = "Invalid email format")
    @Size(max=120)
    @NotEmpty(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "(\\8|9)[0-9]{7}", message="Invalid No. format") //no. starts with 8/9, 7 digits long
    private String phoneNo;

    @Min(value=1500, message="Min salary starts from 1500")
    @Max(value=400000, message="Max salary 400000")
    private Integer salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Birth date cannot be earlier than today")
    private Date birthDay;

    private String address;

    @Digits(fraction=0, integer=6, message="6 digit format required") //fractions not allowed, 6 digits required
    private Integer postalCode;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNo, Integer salary, Date birthDay, String address, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.birthDay = birthDay;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNo='" + getPhoneNo() + "'" +
            ", salary='" + getSalary() + "'" +
            ", birthDay='" + getBirthDay() + "'" +
            ", address='" + getAddress() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(phoneNo, employee.phoneNo) && Objects.equals(salary, employee.salary) && Objects.equals(birthDay, employee.birthDay) && Objects.equals(address, employee.address) && Objects.equals(postalCode, employee.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNo, salary, birthDay, address, postalCode);
    }
    
}
