 /*TRIGGER PARA COMPROBAR EL SALARIO MINIMO
  En el caso de que se ponga un salario 
  inferior a 1184 se pondra como valor minimo dicha cantidad
*/
CREATE OR REPLACE TRIGGER salarioMin
BEFORE INSERT OR UPDATE OF sueldo ON JUGADORES
FOR EACH ROW
DECLARE
BEGIN
    IF :NEW.sueldo < 1184 THEN
        :NEW.sueldo := 1184;
    end if;
END;
/*TRIGGER PARA COMPROBAR EL NICKNAME
  En el caso de que se ponga un nickname ya 
  escogido por un jugador salta una excepcion y no deja insertar
*/

CREATE OR REPLACE TRIGGER nickNameDuplicadoJugador
    BEFORE INSERT OR UPDATE OF NICKNAME ON JUGADORES
    FOR EACH ROW
DECLARE
    e_nombreDuplicado exception;
    v_filasSeleccionadas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_filasSeleccionadas
    FROM JUGADORES
    WHERE lower(NICKNAME) = lower(:NEW.NICKNAME);
    IF v_filasSeleccionadas>0 THEN
        RAISE e_nombreDuplicado;
    end if;
EXCEPTION
    WHEN e_nombreDuplicado THEN
        RAISE_APPLICATION_ERROR(-20003,'YA EXISTE UN JUGADOR CON ESE NOMBRE');
END;

/*TRIGGER PARA COMPROBAR LA CANTIDAD DE JUGADORES POR EQUIPOS
  En el caso de que se añada un jugador con un idEquipo igual a otros 6 jugadores salta una excepcion y no deja insertar
*/

CREATE OR REPLACE TRIGGER maxJugadoresEquipo
BEFORE INSERT OR UPDATE ON JUGADORES
FOR EACH ROW
DECLARE
    v_jugadoresEquipo NUMBER;
    e_demaisadosEquipos exception;
BEGIN
    SELECT COUNT(*) INTO v_jugadoresEquipo
    FROM JUGADORES
    WHERE IDEQUIPO = :NEW.IDEQUIPO;

    IF v_jugadoresEquipo >5 THEN
        RAISE e_demaisadosEquipos;
    end if;
EXCEPTION
    WHEN e_demaisadosEquipos THEN
        RAISE_APPLICATION_ERROR(-20004,'NO SE PUEDEN INSERTAR MAS JUGADORES, MAX: 6');
END;
