package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;

public class Utils {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatearFecha(Object fechaObj) {
        if (fechaObj == null) {
            return "";
        }

        if (fechaObj instanceof LocalDateTime) {
            return ((LocalDateTime) fechaObj).format(FORMATO);
        }

        if (fechaObj instanceof Timestamp) {
            return ((Timestamp) fechaObj).toLocalDateTime().format(FORMATO);
        }

        return fechaObj.toString();
    }
}
