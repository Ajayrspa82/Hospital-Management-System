package com.wipro.amazecare.dto;

public class PatientCreateDTO {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String phone;
    private String address;

    public PatientCreateDTO(){}

    
    
    public PatientCreateDTO(String firstName, String lastName, int age, String gender, String phone, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}



	public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}