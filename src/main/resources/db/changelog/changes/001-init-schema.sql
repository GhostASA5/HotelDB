CREATE TYPE hotel.room_type AS ENUM ('Стандарт', 'Семейный', 'Люкс');

CREATE TABLE IF NOT EXISTS hotel.room_types (
    type_id SERIAL PRIMARY KEY,
    type_name hotel.room_type NOT NULL,
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    max_guests INT NOT NULL CHECK (max_guests > 0),
    description TEXT
);

CREATE TABLE IF NOT EXISTS hotel.rooms (
    room_id SERIAL PRIMARY KEY,
    number VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    type_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (type_id) REFERENCES hotel.room_types(type_id)
);

CREATE TABLE IF NOT EXISTS hotel.amenities (
    amenity_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS hotel.room_amenities (
    room_id INT NOT NULL,
    amenity_id INT NOT NULL,
    PRIMARY KEY (room_id, amenity_id),
    FOREIGN KEY (room_id) REFERENCES hotel.rooms(room_id) ON DELETE CASCADE,
    FOREIGN KEY (amenity_id) REFERENCES hotel.amenities(amenity_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hotel.guests (
    guest_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    passport_number VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS hotel.bookings (
    booking_id SERIAL PRIMARY KEY,
    guest_id INT NOT NULL REFERENCES hotel.guests(guest_id),
    room_id INT NOT NULL REFERENCES hotel.rooms(room_id),
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    adults_count INT NOT NULL CHECK (adults_count > 0),
    children_count INT DEFAULT 0 CHECK (children_count >= 0),
    total_price DECIMAL(12, 2) NOT NULL CHECK (total_price >= 0),
    special_requests TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (check_out_date > check_in_date),
    CHECK (check_in_date >= CURRENT_DATE)
);

CREATE TYPE hotel.employee_role AS ENUM ('Администратор', 'Горничная', 'Менеджер', 'Портье');

CREATE TABLE IF NOT EXISTS hotel.employees (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(20) NOT NULL,
    role hotel.employee_role NOT NULL,
    hire_date DATE NOT NULL,
    salary DECIMAL(10, 2) CHECK (salary >= 0),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS hotel.room_cleaning (
    cleaning_id SERIAL PRIMARY KEY,
    room_id INT NOT NULL,
    employee_id INT NOT NULL,
    cleaning_time TIMESTAMP NOT NULL,
    scheduled_time TIME,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (room_id) REFERENCES hotel.rooms(room_id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES hotel.employees(employee_id),

    CHECK (cleaning_time >= CURRENT_DATE)
);