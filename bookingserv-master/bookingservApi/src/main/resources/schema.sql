DROP TABLE IF EXISTS BOOKING;
 
CREATE TABLE BOOKING (
  id INT AUTO_INCREMENT  PRIMARY KEY, 
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_birth date NOT NULL,
  check_in date NOT NULL,
  check_out date NOT NULL,
  total_price VARCHAR(255) NOT NULL,
  deposit_amount VARCHAR(255) NOT NULL,
  address_line1 VARCHAR(255) NOT NULL,
  address_line2 VARCHAR(255) DEFAULT NULL,
  city VARCHAR(255) NOT NULL,
  state VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  zip_code VARCHAR(255) NOT NULL
  
) DEFAULT CHARSET=utf8;