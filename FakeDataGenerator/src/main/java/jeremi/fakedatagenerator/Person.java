package jeremi.fakedatagenerator;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {

    private String name;
    private String surname;
    private Date birthday;

    @Additional
    private String address;
    @Additional
    private String university;
    @Additional
    private String country;
    @Additional
    private String phone;
    @Additional
    private String email;
    @Additional
    private String index;
    @Additional
    private String employment;
    @Additional
    private String company;
    
    public List<String> getAssignedAttributes(){
        List<String> attributes = new ArrayList<>();
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(this);
                String name = f.getName();
                if (value != null){
                    attributes.add(name);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return attributes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(this);
                if (value != null){
                    // Delete all commas, because I use commas to separate values
                    value = value.toString().replace(",", "");
                    result.append(value);
                    result.append(",");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
