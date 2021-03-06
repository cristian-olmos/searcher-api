DROP TABLE IF EXISTS HOTELS_SERVICES;
DROP TABLE IF EXISTS ROOMS;
DROP TABLE IF EXISTS SERVICES;
DROP TABLE IF EXISTS HOTELS;

CREATE TABLE HOTELS (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  category VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
);

CREATE TABLE ROOMS (
  id VARCHAR(250) PRIMARY KEY,
  hotel_id VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  occupation INTEGER NOT NULL,
  price DECIMAL(7,2) NOT NULL,
  FOREIGN KEY (hotel_id) REFERENCES HOTELS(id)
);

CREATE TABLE SERVICES (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE HOTELS_SERVICES (
  hotel_id VARCHAR(250)  NOT NULL,
  service_id VARCHAR(250)  NOT NULL,
  FOREIGN KEY (hotel_id) REFERENCES HOTELS(id),
  FOREIGN KEY (service_id) REFERENCES SERVICES(id)
);

COMMIT;
