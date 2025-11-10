INSERT INTO hotel.room_types (type_name, price, max_guests, description)
VALUES
    ('Стандарт', 2500.00, 2, 'Уютный номер для двух человек с базовыми удобствами.'),
    ('Семейный', 4200.00, 4, 'Просторный номер для всей семьи с дополнительной кроватью.'),
    ('Люкс', 7500.00, 2, 'Роскошный номер с панорамным видом и джакузи.');

INSERT INTO hotel.rooms (number, name, description, type_id)
VALUES
    ('101', 'Стандарт 101', 'С видом на сад', 1),
    ('202', 'Семейный 202', 'Две спальни, гостиная и балкон', 2),
    ('303', 'Люкс 303', 'Панорамный вид на море и джакузи', 3);

INSERT INTO hotel.amenities (name, description)
VALUES
    ('Wi-Fi', 'Бесплатный высокоскоростной интернет по всему отелю'),
    ('Завтрак', 'Включённый завтрак "шведский стол"'),
    ('Парковка', 'Бесплатная охраняемая парковка для гостей');

INSERT INTO hotel.room_amenities (room_id, amenity_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 1),
    (3, 2),
    (3, 3);

INSERT INTO hotel.guests (first_name, last_name, middle_name, passport_number, email, phone)
VALUES
    ('Иван', 'Петров', 'Алексеевич', '1234567890', 'ivan.petrov@example.com', '+79998887766'),
    ('Мария', 'Сидорова', 'Игоревна', '2345678901', 'maria.sidorova@example.com', '+79995554433'),
    ('Алексей', 'Кузнецов', 'Павлович', '3456789012', 'alex.kuz@example.com', '+79997775511');

INSERT INTO hotel.bookings (guest_id, room_id, check_in_date, check_out_date, adults_count, children_count, total_price, special_requests)
VALUES
    (1, 1, '2025-11-10', '2025-11-15', 2, 0, 12500.00, 'Без особых пожеланий'),
    (2, 2, '2025-11-12', '2025-11-18', 2, 2, 25200.00, 'Нужна детская кроватка'),
    (3, 3, '2025-12-01', '2025-12-05', 2, 0, 30000.00, 'Поздний заезд');

INSERT INTO hotel.employees (first_name, last_name, middle_name, email, phone, role, hire_date, salary, is_active)
VALUES
    ('Ольга', 'Семенова', 'Игоревна', 'olga.semenova@example.com', '+79990001122', 'Администратор', '2023-01-15', 55000.00, TRUE),
    ('Анна', 'Козлова', 'Павловна', 'anna.kozlova@example.com', '+79995556677', 'Горничная', '2022-11-10', 40000.00, TRUE),
    ('Дмитрий', 'Орлов', 'Николаевич', 'dmitry.orlov@example.com', '+79998884455', 'Менеджер', '2021-09-01', 70000.00, TRUE);

INSERT INTO hotel.room_cleaning (room_id, employee_id, cleaning_time, scheduled_time, notes)
VALUES
    (1, 2, '2025-11-10 10:00:00', '00:30:00', 'Ежедневная уборка'),
    (2, 2, '2025-11-10 11:00:00', '00:10:00', 'Замена полотенец'),
    (3, 2, '2025-11-10 12:30:00', '01:00:00', 'Генеральная уборка');
