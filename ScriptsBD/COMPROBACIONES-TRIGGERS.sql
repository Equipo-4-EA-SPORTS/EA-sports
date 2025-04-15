/*COMPROBACIONES TRIGGER noMasUnaCompeticion - COMPETICIONES*/
    INSERT INTO competiciones (estado) VALUES (DEFAULT); //SI DEJA POR NO HAY NINGUNA COMPETICION CREADA
    INSERT INTO competiciones (estado) VALUES (DEFAULT); //NO DEJA POR YA HAY UNA COMPETICION CREADA

/*COMPROBACIONES TRIGGER cerrarCompeticion - COMPETICIONES */
    UPDATE competiciones SET estado = 'abierto'; //Abrimos primero para luego comprobar si nos deja cerrar sin equipos
    UPDATE competiciones SET estado = 'cerrado'; //NO DEJA POR QUE NO HAY MINIMO 2 EQUIPOS
    
    // CREAMOS 2 EQUIPOS
    INSERT INTO equipos (nombre,fechafund) VALUES ('Prueba1',to_date('10/10/2020','dd/MM/yyyy'));
    INSERT INTO equipos (nombre,fechafund) VALUES ('Prueba2',to_date('10/09/2020','dd/MM/yyyy'));
    
    UPDATE competiciones SET estado = 'cerrado'; //NO DEJA POR QUE NO HAY MINIMO 2 JUGADORES POR EQUIPO
    
    // CREAMOS 1 EQUIPO MAS
    INSERT INTO equipos (nombre,fechafund) VALUES ('Prueba3',to_date('10/11/2020','dd/MM/yyyy'));
    
    UPDATE competiciones SET estado = 'cerrado'; //NO DEJA POR QUE NO HAY UN NUMERO IMPAR DE EQUIPOS
    
    // ELIMINAMOS 1 EQUIPO y AÑADIMOS 2 JUGADORES EN CADA EQUIPO
    DELETE FROM equipos WHERE lower(nombre) = 'prueba1';
    
    INSERT INTO jugadores (nombre,idEquipo) VALUES ('Prueba1',3);
    INSERT INTO jugadores (nombre,idEquipo) VALUES ('Prueba2',2);
    INSERT INTO jugadores (nombre,idEquipo) VALUES ('Prueba3',3);
    INSERT INTO jugadores (nombre,idEquipo) VALUES ('Prueba4',2);
    
    UPDATE competiciones SET estado = 'cerrado'; // SI QUE DEJA POR QUE LA COMPETICION CUMPLE CON TODOS LOS REQUISITOS
    
/*COMPROBACIONES TRIGGER cerrarCompeticionJugador - COMPETICIONES */
    INSERT INTO jugadores (nombre,idEquipo) VALUES ('Prueba5',2); //NO DEJA POR QUE LA COMPETICION ESTA CERRADA
    UPDATE jugadores set nombre = 'JugadorModificado' WHERE lower(nombre) = 'prueba4';
    DELETE FROM jugadores WHERE lower(nombre) = 'prueba1';
    /*COMPROBACIONES TRIGGER cerrarCompeticionEquipo - COMPETICIONES */
    INSERT INTO equipos (nombre,fechafund) VALUES ('Prueba1',to_date('10/10/2020','dd/MM/yyyy')); //NO DEJA POR QUE LA COMPETICION ESTA CERRADA
    UPDATE equipos set nombre = 'EquipoModificado' WHERE lower(nombre) = 'prueba3';
    DELETE FROM equipos WHERE lower(nombre) = 'prueba3';



