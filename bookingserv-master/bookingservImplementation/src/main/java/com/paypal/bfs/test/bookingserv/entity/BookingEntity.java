package com.paypal.bfs.test.bookingserv.entity;

/**
 * @author Mahesh Mishra
 * This is Entity class for Booking data
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="BOOKING")
public class BookingEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "first name must not be empty")
	@Column(name="first_name" , length = 255)
    private String firstName;
    
	@NotEmpty(message = "last name must not be empty")
    @Column(name="last_name", length = 255)
    private String lastName;
    
	@NotNull(message = "date of birth must not be empty")
    @Column (name="date_birth" ,length = 10)
    private Date datebirth;
    
	@NotNull(message = "check-in date must not be empty")
    @Column (name="check_in", length = 10)
    private Date checkIn;
    
	@NotNull(message = "check-Out date must not be empty")
    @Column (name="check_out" ,length = 10)
    private Date checkOUT;
    
	@NotEmpty(message = "Tota pricee must not be empty")
    @Column(name="total_price", length = 40)
    private String totalPrice;
    
	@NotEmpty(message = "deposit amount must not be empty")
    @Column(name="deposit_amount", length = 40)
    private String depositAmount;
    
	@NotEmpty(message = "Address Line 1 must not be empty")
    @Column(name="address_line1", length = 255)
    private String addressLine1;
    
    @Column(name="address_line2", length = 255)
    private String addressLine2;
    
    @NotEmpty(message = "City must not be empty")
    @Column(name="city", length = 255)
    private String city;
    
    @NotEmpty(message = "State must not be empty")
    @Column(name="state", length = 255)
    private String state;
    
    @NotEmpty(message = "Country must not be empty")
    @Column(name="country", length = 255)
    private String country;
    
    @NotEmpty(message = "Zip code must not be empty")
    @Column(name="zip_code", length = 255)
    private String zipCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getDoB() {
		return datebirth;
	}

	public void setDoB(Date doB) {
		datebirth = doB;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOUT() {
		return checkOUT;
	}

	public void setCheckOUT(Date checkOUT) {
		this.checkOUT = checkOUT;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "BookingEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", DoB=" + datebirth
				+ ", checkIn=" + checkIn + ", checkOUT=" + checkOUT + ", totalPrice=" + totalPrice + ", depositAmount="
				+ depositAmount + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
  
    
    
	
    

}
