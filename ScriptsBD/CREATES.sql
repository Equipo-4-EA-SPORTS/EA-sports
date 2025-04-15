DROP TABLE enfrentamientos CASCADE CONSTRAINTS;
DROP TABLE jugadores CASCADE CONSTRAINTS;
DROP TABLE jornadas CASCADE CONSTRAINTS;
DROP TABLE equipos CASCADE CONSTRAINTS;
DROP TABLE roles CASCADE CONSTRAINTS;
DROP TABLE equipoRoles CASCADE CONSTRAINTS;
DROP TABLE competiciones CASCADE CONSTRAINTS;
DROP TABLE usuarios CASCADE CONSTRAINTS;


CREATE TABLE competiciones (
    idComp NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    estado VARCHAR2(10) DEFAULT 'cerrado',
    
    CONSTRAINT competicion_idComp_pk PRIMARY KEY (idComp),
    CONSTRAINT competicion_estado_ck CHECK(estado IN ('abierto','cerrado'))
);

CREATE TABLE jornadas(
    idJor NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    fechaInicio DATE,
    fechaFin DATE,

    CONSTRAINT jornada_idJor_pk PRIMARY KEY (idJor)
);

CREATE TABLE roles(
    idRol NUMBER GENERATED ALWAYS AS IDENTITY
    (START WITH 1 INCREMENT BY 1),
    rol VARCHAR2(50),

    CONSTRAINT roles_idRol_pk PRIMARY KEY (idRol),
    CONSTRAINT roles_rol_ck CHECK (rol IN ('Duelista','Centinela','Controlador','Iniciador','Asesino','Mago'))
);

CREATE TABLE equipos(
    idEquipo NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    nombre VARCHAR2(50),
    fechaFund DATE,
    
    CONSTRAINT equipos_idEquipo_pk PRIMARY KEY (idEquipo)
);

CREATE TABLE equipoRoles(
    idEquipoRol NUMBER GENERATED ALWAYS AS IDENTITY
    (START WITH 1 INCREMENT BY 1),

    idEquipo NUMBER,
    idRol NUMBER,

    CONSTRAINT equipoRoles_idEquipoRol_pk PRIMARY KEY (idEquipoRol),
    CONSTRAINT equipoRoles_idEquipo_fk FOREIGN KEY (idEquipo) REFERENCES equipos,
        CONSTRAINT equipoRoles_idRol_fk FOREIGN KEY (idRol) REFERENCES roles
);



CREATE TABLE jugadores(
    idJugador NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    nombre VARCHAR2(50),
    apellido VARCHAR2(50),
    nacionalidad VARCHAR2(50),
    fechaNac DATE,
    nickName VARCHAR2(50),
    sueldo FLOAT,
    rol VARCHAR2(50),
    idEquipo NUMBER,
    
    CONSTRAINT jugadores_idJugador_pk PRIMARY KEY (idJugador),
    CONSTRAINT jugadores_rol_ck CHECK(rol IN ('Duelista','Controlador','Centinela','Iniciador','Asesino','Mago')),
    CONSTRAINT jugadores_idEquipo_fk FOREIGN KEY (idEquipo) REFERENCES equipos(idEquipo) ON DELETE CASCADE
    
);

CREATE TABLE enfrentamientos(
    idEnf NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    ganadorEnf NUMBER,
    perdedorEnf NUMBER,
    hora VARCHAR(5),
    fecha DATE,
    idJornada NUMBER,
    
    CONSTRAINT enfrentamiento_idEnf_pk PRIMARY KEY (idEnf),
    CONSTRAINT enfrentamiento_ganadorEnf_fk FOREIGN KEY (ganadorEnf) REFERENCES equipos(idEquipo) ON DELETE CASCADE,
    CONSTRAINT enfrentamiento_perdedorEnf_fk FOREIGN KEY (perdedorEnf) REFERENCES equipos(idEquipo) ON DELETE CASCADE,
    CONSTRAINT enfrentamiento_idJornada_fk FOREIGN KEY (idJornada) REFERENCES jornadas(idJor) ON DELETE CASCADE
);

CREATE TABLE usuarios(
    idUsuario NUMBER GENERATED ALWAYS AS IDENTITY  
    (START WITH 1 INCREMENT BY 1),
    tipoUsuario VARCHAR2(50),
    nombre VARCHAR2(50),
    contrasena VARCHAR(50),
    
    CONSTRAINT usuarios_idUsuario_pk PRIMARY KEY (idUsuario),
    CONSTRAINT usuarios_tipoUsuario_ck CHECK(tipoUsuario IN ('administrador','usuario'))
);
