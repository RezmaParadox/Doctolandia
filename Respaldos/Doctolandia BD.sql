

CREATE TABLE `historial` ( 
   `idHistorial` INT(15) NOT NULL,
   `edad` INT(10) NOT NULL,
   `sexo` VARCHAR(15) NOT NULL,
   `estatura` VARCHAR(15) NOT NULL,
    PRIMARY KEY `Primary key`(
   `idHistorial`
    )
);
CREATE TABLE `historialAlergia` ( 
   `alergia` VARCHAR(50) NOT NULL,
   `idHistorial` INT(15) NOT NULL
);
CREATE TABLE `historialPadecimiento` ( 
   `padecimiento` VARCHAR(100) NOT NULL,
   `idHistorial` INT(15) NOT NULL
);
CREATE TABLE `pacienteHistorial` ( 
   `idPaciente` INT NOT NULL,
   `idHistorial` INT(15) NOT NULL
);
CREATE TABLE `paciente` ( 
   `idPaciente` INT NOT NULL,
   `nombre` VARCHAR(40) NOT NULL,
   `apePa` VARCHAR(40) NOT NULL,
   `apeMa` VARCHAR(40),
   `calle` VARCHAR(50) NOT NULL,
   `numero` INT(15) NOT NULL,
   `colonia` VARCHAR(20) NOT NULL,
   `cp` INT(15) NOT NULL,
   `ciudad` VARCHAR(30) NOT NULL,
    PRIMARY KEY `Primary key`(
   `idPaciente`
    )
);
CREATE TABLE `pacienteTelefono` ( 
   `telefono` BIGINT(50) NOT NULL,
   `idPaciente` INT NOT NULL
);
CREATE TABLE `pacienteCorreo` ( 
   `correo` VARCHAR(100) NOT NULL,
   `idPaciente` INT NOT NULL
);
CREATE TABLE `pacienteCita` ( 
   `idPaciente` INT NOT NULL,
   `idCita` INT NOT NULL
);
CREATE TABLE `cita` ( 
   `idCita` INT NOT NULL,
   `fecha` DATE NOT NULL,
   `hora` TIME NOT NULL,
   `motivo` VARCHAR(40) NOT NULL,
    PRIMARY KEY `Primary key`(
   `idCita`
    )
);
CREATE TABLE `citaPrecio` ( 
   `precio` INT(10) NOT NULL,
   `idCita` INT NOT NULL
);
CREATE TABLE `empleadoCita` ( 
   `idEmpleado` INT(15) NOT NULL,
   `idCita` INT NOT NULL
);
CREATE TABLE `empleado` ( 
   `idEmpleado` INT(15) NOT NULL,
   `nombre` VARCHAR(40) NOT NULL,
   `apePa` VARCHAR(40) NOT NULL,
   `apeMa` VARCHAR(40),
   `calle` VARCHAR(50) NOT NULL,
   `numero` INT(15) NOT NULL,
   `colonia` VARCHAR(20) NOT NULL,
   `cp` INT(10) NOT NULL,
   `ciudad` VARCHAR(30) NOT NULL,
    PRIMARY KEY `Primary key`(
   `idEmpleado`
    )
);
CREATE TABLE `empleadoTelefono` ( 
   `telefono` BIGINT(50) NOT NULL,
   `idEmpleado` INT(15) NOT NULL
);
CREATE TABLE `empleadoCorreo` ( 
   `correo` VARCHAR(100) NOT NULL,
   `idEmpleado` INT(15) NOT NULL
);
CREATE TABLE `especialistaCita` ( 
   `idEspecialista` INT(15) NOT NULL,
   `idCita` INT NOT NULL
);
CREATE TABLE `especialista` ( 
   `idEspecialista` INT(15) NOT NULL,
   `nombre` VARCHAR(40) NOT NULL,
   `apePa` VARCHAR(40) NOT NULL,
   `apeMa` VARCHAR(40),
   `calle` VARCHAR(50) NOT NULL,
   `numero` INT(15) NOT NULL,
   `colonia` VARCHAR(20) NOT NULL,
   `cp` INT(15) NOT NULL,
   `ciudad` VARCHAR(30) NOT NULL,
    PRIMARY KEY `Primary key`(
   `idEspecialista`
    )
);
CREATE TABLE `especialistaTelefono` ( 
   `telefono` BIGINT(50) NOT NULL,
   `idEspecialista` INT(15) NOT NULL
);
CREATE TABLE `especialistaCorreo` ( 
   `correo` VARCHAR(100) NOT NULL,
   `idEspecialista` INT(15) NOT NULL
);
CREATE TABLE `especialistaEspecialidad` ( 
   `especialidad` VARCHAR(50) NOT NULL,
   `idEspecialista` INT(15) NOT NULL
);
ALTER TABLE `historialAlergia` 
  ADD CONSTRAINT `historial-historialAlergia`
  FOREIGN KEY ( 
   `idHistorial`
)   REFERENCES `historial`( 
   `idHistorial`
) ;


ALTER TABLE `historialPadecimiento` 
  ADD CONSTRAINT `historial-historialPadecimiento`
  FOREIGN KEY ( 
   `idHistorial`
)   REFERENCES `historial`( 
   `idHistorial`
) ;


ALTER TABLE `pacienteHistorial` 
  ADD CONSTRAINT `paciente-pacienteHistorial`
  FOREIGN KEY ( 
   `idPaciente`
)   REFERENCES `paciente`( 
   `idPaciente`
) ;


ALTER TABLE `pacienteHistorial` 
  ADD CONSTRAINT `historial-pacienteHistorial`
  FOREIGN KEY ( 
   `idHistorial`
)   REFERENCES `historial`( 
   `idHistorial`
) ;


ALTER TABLE `pacienteTelefono` 
  ADD CONSTRAINT `paciente-pacienteTelefono`
  FOREIGN KEY ( 
   `idPaciente`
)   REFERENCES `paciente`( 
   `idPaciente`
) ;


ALTER TABLE `pacienteCorreo` 
  ADD CONSTRAINT `paciente-pacienteCorreo`
  FOREIGN KEY ( 
   `idPaciente`
)   REFERENCES `paciente`( 
   `idPaciente`
) ;


ALTER TABLE `citaPrecio` 
  ADD CONSTRAINT `cita-citaPrecio`
  FOREIGN KEY ( 
   `idCita`
)   REFERENCES `cita`( 
   `idCita`
) ;


ALTER TABLE `pacienteCita` 
  ADD CONSTRAINT `paciente-pacienteCita`
  FOREIGN KEY ( 
   `idPaciente`
)   REFERENCES `paciente`( 
   `idPaciente`
) ;


ALTER TABLE `pacienteCita` 
  ADD CONSTRAINT `cita-pacienteCita`
  FOREIGN KEY ( 
   `idCita`
)   REFERENCES `cita`( 
   `idCita`
) ;


ALTER TABLE `empleadoTelefono` 
  ADD CONSTRAINT `empleado-empleadoTelefono`
  FOREIGN KEY ( 
   `idEmpleado`
)   REFERENCES `empleado`( 
   `idEmpleado`
) ;


ALTER TABLE `empleadoCorreo` 
  ADD CONSTRAINT `empleado-empleadoCorreo`
  FOREIGN KEY ( 
   `idEmpleado`
)   REFERENCES `empleado`( 
   `idEmpleado`
) ;


ALTER TABLE `empleadoCita` 
  ADD CONSTRAINT `empleado-empleadoCita`
  FOREIGN KEY ( 
   `idEmpleado`
)   REFERENCES `empleado`( 
   `idEmpleado`
) ;


ALTER TABLE `empleadoCita` 
  ADD CONSTRAINT `cita-empleadoCita`
  FOREIGN KEY ( 
   `idCita`
)   REFERENCES `cita`( 
   `idCita`
) ;


ALTER TABLE `especialistaTelefono` 
  ADD CONSTRAINT `especialista-especialistaTelefono`
  FOREIGN KEY ( 
   `idEspecialista`
)   REFERENCES `especialista`( 
   `idEspecialista`
) ;


ALTER TABLE `especialistaCorreo` 
  ADD CONSTRAINT `especialista-especialistaCorreo`
  FOREIGN KEY ( 
   `idEspecialista`
)   REFERENCES `especialista`( 
   `idEspecialista`
) ;


ALTER TABLE `especialistaCita` 
  ADD CONSTRAINT `especialista-especialistaCita`
  FOREIGN KEY ( 
   `idEspecialista`
)   REFERENCES `especialista`( 
   `idEspecialista`
) ;


ALTER TABLE `especialistaCita` 
  ADD CONSTRAINT `cita-especialistaCita`
  FOREIGN KEY ( 
   `idCita`
)   REFERENCES `cita`( 
   `idCita`
) ;


ALTER TABLE `especialistaEspecialidad` 
  ADD CONSTRAINT `especialista-especialistaEspecialidad`
  FOREIGN KEY ( 
   `idEspecialista`
)   REFERENCES `especialista`( 
   `idEspecialista`
) ;

