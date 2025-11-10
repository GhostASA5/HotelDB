CREATE OR REPLACE VIEW hotel.room_type_statistics AS
SELECT
    rt.type_name AS room_type,
    COUNT(b.booking_id) AS total_bookings,
    SUM(b.total_price) AS total_revenue,
    ROUND(AVG(b.total_price), 2) AS avg_booking_price
FROM hotel.room_types rt
    JOIN hotel.rooms r ON rt.type_id = r.type_id
    LEFT JOIN hotel.bookings b ON r.room_id = b.room_id
GROUP BY rt.type_name
ORDER BY total_revenue DESC;

CREATE OR REPLACE VIEW hotel.monthly_revenue AS
SELECT
    TO_CHAR(b.check_in_date, 'YYYY-MM') AS month,
    COUNT(b.booking_id) AS total_bookings,
    SUM(b.total_price) AS total_revenue,
    ROUND(AVG(b.total_price), 2) AS avg_price_per_booking
FROM hotel.bookings b
GROUP BY TO_CHAR(b.check_in_date, 'YYYY-MM')
ORDER BY month DESC;
