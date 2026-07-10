# Sistema Clinica DentaSmart

## Requisitos

- Docker Desktop
- JDK 17+
- NetBeans / Cursor / IntelliJ

## Inicio rapido

1. Clonar el repositorio
2. Levantar la base de datos en segundo plano:

```bash
docker compose up -d
```

3. Verificar que este lista (debe decir `healthy`):

```bash
docker compose ps
```

4. Abrir el proyecto y ejecutar `principal.Main`

> **Importante:** Usa `-d` para que la BD siga corriendo en background. Si ejecutas `docker compose up` sin `-d` y presionas Ctrl+C, se detiene la base de datos y la app no conectara.

## Conexion BD

| Campo    | Valor                    |
|----------|--------------------------|
| Host     | localhost                |
| Puerto   | 1435                     |
| BD       | db_dentasmart_control    |
| Usuario  | sa                       |
| Password | Password12345678         |

## Detener

```bash
docker compose down
```

Para eliminar tambien los datos persistidos:

```bash
docker compose down -v
```
