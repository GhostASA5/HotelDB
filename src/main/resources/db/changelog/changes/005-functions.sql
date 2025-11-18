CREATE OR REPLACE FUNCTION hotel.guest_total_spent(p_guest_id BIGINT)
    RETURNS NUMERIC AS $$
DECLARE
    total NUMERIC;
BEGIN
    SELECT COALESCE(SUM(total_price), 0)
    INTO total
    FROM hotel.bookings
    WHERE guest_id = p_guest_id;

    RETURN total;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION hotel.generate_report(
    table_name TEXT,
    columns TEXT,
    filter TEXT
)
    RETURNS TABLE(result JSON)
    LANGUAGE plpgsql AS $$
DECLARE
    sql_query TEXT;
BEGIN
    sql_query := format('SELECT json_agg(t) FROM (SELECT %s FROM %I WHERE %s) t',
                        columns, table_name, filter);
    RETURN QUERY EXECUTE sql_query;
END;
$$;

