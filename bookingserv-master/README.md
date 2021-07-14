# bookingserv


## Mahesh Comments
- I have implemented idempotency logic to avoid duplicate resource creation based on below five parameter
  1. First Name 
  2. Second Name 
  3. Date of Birth
  4. Check-in Date
  5. Check-out Date
  
- Sample POST Request Body 


  {       
        "first_name": "Jack",
        "last_name": "Denial",
        "date_of_birth": "1963-08-29",
        "check_in": "2021-09-01",
        "check_out": "2021-09-17",
        "total_price": "2000$",
        "deposit_amount": "1500$",
        "address": {
            "line1": "Flat K 654 , Pricley Land Area",
            "line2": "Pocket 6",
            "city": "Ahaura",
            "state": "South Newland",
            "country": "New zealand",
            "zip_code": "7845"
        }
    }
	
- Please note Date format is yyyy-MM-dd example 2021-07-14 is 14 July 2021

## Details Information about Error messesges 

- Major Error Messages describtion
  
#a. Case 1 :
   
   - If Check-out date is early than Check-in date then
   - Error Messege : "Check out date can not be before than check-in date so please check again and try again for booking"
   
#b. Case 2: 
   - If Duplicate Booking is already there then 
   - Error Message : "This record is already exist , please try with different booking"

#c. Case 3: 
   - If date format is not correct in request body then 
   - Error Message : "Please check the Date format and try again with booking" 

#d . Case 4 : [ Additional added for Find Booking by ID]   
   - If booking ID is not found then 
   - Error Message : "Booking is not found, please try with differnt Booking ID" 
   
## Any Query 
Please do contact me if any more information needed mahesh.1511@gmail.com


