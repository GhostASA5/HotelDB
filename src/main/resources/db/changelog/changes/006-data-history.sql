CREATE TABLE IF NOT EXISTS hotel.booking_audit (
    audit_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    operation VARCHAR(10) NOT NULL,
    old_data JSONB,
    new_data JSONB,
    changed_at TIMESTAMP DEFAULT now()
);

CREATE TABLE IF NOT EXISTS hotel.room_cleaning_audit (
    audit_id BIGSERIAL PRIMARY KEY,
    cleaning_id BIGINT NOT NULL,
    operation VARCHAR(10) NOT NULL,
    old_data JSONB,
    new_data JSONB,
    changed_at TIMESTAMP DEFAULT now()
);


--тригер измения данных для bookings
CREATE OR REPLACE FUNCTION hotel.bookings_audit_trigger_func()
    RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO hotel.booking_audit (booking_id, operation, new_data)
        VALUES (NEW.booking_id, 'INSERT', row_to_json(NEW));
        RETURN NEW;

    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO hotel.booking_audit (booking_id, operation, old_data, new_data)
        VALUES (OLD.booking_id, 'UPDATE', row_to_json(OLD), row_to_json(NEW));
        RETURN NEW;

    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO hotel.booking_audit (booking_id, operation, old_data)
        VALUES (OLD.booking_id, 'DELETE', row_to_json(OLD));
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER booking_history_trigger
    AFTER INSERT OR UPDATE OR DELETE
    ON hotel.bookings
    FOR EACH ROW EXECUTE FUNCTION hotel.bookings_audit_trigger_func();


--тригер измения данных для room_cleaning
CREATE OR REPLACE FUNCTION hotel.room_cleaning_audit_trigger_func()
    RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO hotel.room_cleaning_audit (cleaning_id, operation, new_data)
        VALUES (NEW.cleaning_id, 'INSERT', row_to_json(NEW));
        RETURN NEW;

    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO hotel.room_cleaning_audit (cleaning_id, operation, old_data, new_data)
        VALUES (OLD.cleaning_id, 'UPDATE', row_to_json(OLD), row_to_json(NEW));
        RETURN NEW;

    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO hotel.room_cleaning_audit (cleaning_id, operation, old_data)
        VALUES (OLD.cleaning_id, 'DELETE', row_to_json(OLD));
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER room_cleaning_history_trigger
    AFTER INSERT OR UPDATE OR DELETE
    ON hotel.room_cleaning
    FOR EACH ROW EXECUTE FUNCTION hotel.room_cleaning_audit_trigger_func();
