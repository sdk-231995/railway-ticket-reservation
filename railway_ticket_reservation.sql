create database railway_ticket_reservation;
use railway_ticket_reservation;
CREATE TABLE login_credentials (
    login_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE passenger_info (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    srl_no INT NOT NULL,
    passenger_name VARCHAR(100) NOT NULL,
    passenger_age INT NOT NULL,
    email VARCHAR (50) NOT NULL,
    mobileNumber INT NULL,
    passenger_gender VARCHAR(10) NOT NULL,
    fare DECIMAL(10, 2),
    seat_no VARCHAR(10),
    login_id VARCHAR(50),
    FOREIGN KEY (login_id) REFERENCES login_credentials(login_id)
);

-- Login credentials
INSERT INTO login_credentials (login_id, password)
VALUES 
('john123', 'john123'),
('sara456', 'sara456');

-- PAX info
INSERT INTO passenger_info (srl_no, passenger_name, passenger_age, passenger_gender, fare, seat_no, login_id)
VALUES 
(1, 'John Doe', 34, 'Male', 525.00, 'A1-12', 'john123'),
(2, 'Sara Lee', 28, 'Female', 480.00, 'B2-05', 'sara456');

CREATE TABLE zone (
    zone_id INT PRIMARY KEY,
    zone_name VARCHAR(100),
    zone_code VARCHAR(10)
);

CREATE TABLE station (
    station_id INT PRIMARY KEY,
    station_code VARCHAR(10),
    station_name VARCHAR(100),
    zone_id INT,
    FOREIGN KEY (zone_id) REFERENCES zone(zone_id)
);

CREATE TABLE class (
    class_id INT PRIMARY KEY,
    coach_prefix VARCHAR(5),
    class_code VARCHAR(10),
    class_name VARCHAR(50),
    seat_per_coach INT
);

CREATE TABLE train (
    train_code VARCHAR(10) PRIMARY KEY,
    train_name VARCHAR(100),
    distance INT,
    start_time TIME,
    end_time TIME,
    start_station_code VARCHAR(10),
    end_station_code VARCHAR(10),
    frequency VARCHAR(50)
);

CREATE TABLE via_details (
    details_id INT PRIMARY KEY AUTO_INCREMENT,
    train_code VARCHAR(10),
    via_station_code VARCHAR(10),
    km_from_origin INT,
    reach_time TIME,
    FOREIGN KEY (train_code) REFERENCES train(train_code)
);


INSERT INTO zone VALUES (1, 'Northern Railway', 'NR');
INSERT INTO station VALUES (101, 'NDLS', 'New Delhi', 1), (102, 'BCT', 'Mumbai Central', 1);

INSERT INTO class VALUES 
(1, 'A1', '1AC', 'First AC', 24),
(2, 'B1', '2AC', 'Second AC', 48);

INSERT INTO train VALUES
('12345', 'Rajdhani Express', 1440, '16:00:00', '08:00:00', 'NDLS', 'BCT', 'Daily');

INSERT INTO via_details (train_code, via_station_code, km_from_origin, reach_time)
VALUES ('12345', 'NDLS', 0, '16:00:00'), ('12345', 'BCT', 1440, '08:00:00');

CREATE TABLE train_fare (
    fare_id INT AUTO_INCREMENT PRIMARY KEY,
    train_code VARCHAR(10),
    class_id INT,
    from_km INT,
    to_km INT,
    from_date DATE,
    to_date DATE,
    fare DECIMAL(10,2)
);

INSERT INTO train_fare (train_code, class_id, from_km, to_km, from_date, to_date, fare) VALUES
('EXP101', 1, 0, 300, '2025-06-01', '2025-06-30', 750.00),
('EXP101', 2, 0, 300, '2025-06-01', '2025-06-30', 500.00),
('EXP202', 1, 0, 500, '2025-06-01', '2025-06-30', 1200.00);

CREATE TABLE seat_availability (
    id INT AUTO_INCREMENT PRIMARY KEY,
    train_code VARCHAR(10),
    class_code VARCHAR(10),
    no_of_seats INT
);

INSERT INTO seat_availability (train_code, class_code, no_of_seats) VALUES
('EXP101', 'SL', 120),
('EXP101', '3A', 64),
('EXP202', 'SL', 100),
('EXP202', '2A', 50);

CREATE TABLE ticket_reservation (
    pnr_no VARCHAR(12) PRIMARY KEY,
    from_date DATE,
    to_date DATE,
    from_km INT,
    to_km INT,
    from_station VARCHAR(10),
    to_station VARCHAR(10),
    train_code VARCHAR(10)
);

INSERT INTO ticket_reservation 
(pnr_no, from_date, to_date, from_km, to_km, from_station, to_station, train_code)
VALUES ('PNR123456789', '2025-06-10', '2025-06-11', 0, 300, 'NDLS', 'BCT', 'EXP101');

INSERT INTO railway_ticket_reservation.passenger_info
(pnr_no, srl_no, passenger_name, passenger_age, passenger_gender,email,mobileNumber, fare, seat_no)
VALUES ('PNR123456789', 11, 'John Doe', 30, 'M','abcd','223344', 750.00, 'S1-45');


ALTER TABLE  railway_ticket_reservation.passenger_info
ADD COLUMN mobileNumber INT NOT NULL
AFTER email;

ALTER TABLE passenger_info
ADD COLUMN pnr_no VARCHAR(12);

ALTER TABLE passenger_info
ADD CONSTRAINT fk_pnr
FOREIGN KEY (pnr_no)
REFERENCES ticket_reservation(pnr_no);







