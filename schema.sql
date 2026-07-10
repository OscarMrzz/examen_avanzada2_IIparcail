IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'db_dentasmart_control')
BEGIN
    CREATE DATABASE db_dentasmart_control;
END
GO

USE db_dentasmart_control;
GO

-- Tabla: dentistas
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[dentistas]') AND type in (N'U'))
BEGIN
    CREATE TABLE dentistas ( 
        id_dentista INT IDENTITY(1,1) PRIMARY KEY, 
        nombre VARCHAR(100) NOT NULL, 
        apellido VARCHAR(100) NOT NULL, 
        especialidad VARCHAR(100) NOT NULL, 
        salario_base DECIMAL(10,2) NOT NULL, 
        estado VARCHAR(20) DEFAULT 'ACTIVO' 
    );
-- Datos de ejemplo
    INSERT INTO dentistas (nombre, apellido, especialidad, salario_base) 
    VALUES ('Oscar', 'Hernandez', 'Ortodoncia', 25000.00),
           ('Genesis', 'Rodriguez', 'Endodoncia', 30000.00);
END
GO

-- Tabla: citas_medicas
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[citas_medicas]') AND type in (N'U'))
BEGIN
    CREATE TABLE citas_medicas ( 
        id_cita INT IDENTITY(1,1) PRIMARY KEY, 
        id_dentista INT NOT NULL, 
        paciente VARCHAR(150) NOT NULL, 
        fecha_cita DATETIME DEFAULT GETDATE(), 
        monto_procedimiento DECIMAL(10,2) NOT NULL, 
        monto_materiales DECIMAL(10,2) NOT NULL,    
        total_neto DECIMAL(10,2) NOT NULL,          
        FOREIGN KEY (id_dentista) REFERENCES dentistas(id_dentista) 
    );
END
GO