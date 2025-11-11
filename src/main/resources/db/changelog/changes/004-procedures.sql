CREATE OR REPLACE PROCEDURE hotel.add_booking(
    p_guest_id BIGINT,
    p_room_id BIGINT,
    p_check_in DATE,
    p_check_out DATE,
    p_adults INT,
    p_children INT,
    p_total_price NUMERIC,
    p_special_requests TEXT
)
LANGUAGE plpgsql
AS $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM hotel.bookings b
        WHERE b.room_id = p_room_id
          AND (p_check_in, p_check_out) OVERLAPS (b.check_in_date, b.check_out_date)
    ) THEN
        RAISE EXCEPTION 'Номер % уже забронирован на указанные даты.', p_room_id;
    END IF;

    INSERT INTO hotel.bookings (
        guest_id, room_id, check_in_date, check_out_date,
        adults_count, children_count, total_price, special_requests
    ) VALUES (
         p_guest_id, p_room_id, p_check_in, p_check_out,
         p_adults, p_children, p_total_price, p_special_requests
    );
END;
$$;

CREATE OR REPLACE PROCEDURE hotel.deactivate_employee(
    p_employee_id BIGINT
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE hotel.employees
    SET is_active = FALSE
    WHERE employee_id = p_employee_id;

    RAISE NOTICE 'Сотрудник с ID % деактивирован.', p_employee_id;
END;
$$;

