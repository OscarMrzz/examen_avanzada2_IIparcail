package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.util.Date;

public class Utils {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

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

    public static String unirFechaYHora(Date fecha, Date hora) {
        LocalDate ld = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime lt = hora.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        return LocalDateTime.of(ld, lt).format(FORMATO);
    }

    public static Date extraerFecha(String fechaCita) {
        LocalDateTime ldt = parsearFechaCita(fechaCita);
        return Date.from(ldt.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date extraerHora(String fechaCita) {
        LocalDateTime ldt = parsearFechaCita(fechaCita);
        LocalTime lt = ldt.toLocalTime();
        return Date.from(LocalDate.now().atTime(lt).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatearHoraTexto(String fechaCita) {
        return parsearFechaCita(fechaCita).toLocalTime().format(FORMATO_HORA);
    }

    public static String formatearFechaTexto(String fechaCita) {
        return parsearFechaCita(fechaCita).toLocalDate().format(FORMATO_FECHA);
    }

    public static String formatearFechaTexto(Date fecha) {
        LocalDate ld = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ld.format(FORMATO_FECHA);
    }

    public static String formatearHoraTexto(Date hora) {
        LocalTime lt = hora.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        return lt.format(FORMATO_HORA);
    }

    public static Date parsearFechaTexto(String fechaTexto) {
        String valor = limpiarMascara(fechaTexto);
        LocalDate ld = LocalDate.parse(valor, FORMATO_FECHA);
        return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date parsearHoraTexto(String horaTexto) {
        String valor = limpiarMascara(horaTexto);
        LocalTime lt = LocalTime.parse(valor, FORMATO_HORA);
        return Date.from(LocalDate.now().atTime(lt).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static String limpiarMascara(String texto) {
        return texto.trim().replace("_", "");
    }

    private static LocalDateTime parsearFechaCita(String fechaCita) {
        if (fechaCita == null || fechaCita.trim().isEmpty()) {
            return LocalDateTime.now();
        }
        String valor = fechaCita.trim();
        if (valor.length() > 19) {
            valor = valor.substring(0, 19);
        }
        return LocalDateTime.parse(valor, FORMATO);
    }
}
