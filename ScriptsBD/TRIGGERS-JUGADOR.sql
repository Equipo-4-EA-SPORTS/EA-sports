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
FOR INSERT OR UPDATE ON jugadores
COMPOUND TRIGGER

    v_idEquipo jugadores.idEquipo%TYPE;
    e_max_jugadores EXCEPTION;

BEFORE EACH ROW IS
BEGIN

    IF INSERTING OR (UPDATING AND :NEW.idEquipo != :OLD.idEquipo) THEN
        v_idEquipo := :NEW.idEquipo;
    END IF;
END BEFORE EACH ROW;

AFTER STATEMENT IS
        v_total NUMBER;
    BEGIN
        IF v_idEquipo IS NOT NULL THEN
            SELECT COUNT(*) INTO v_total
            FROM jugadores
            WHERE idEquipo = v_idEquipo;
    
            IF v_total > 6 THEN
                RAISE e_max_jugadores;
            END IF;
        END IF;
    
    EXCEPTION
        WHEN e_max_jugadores THEN
            RAISE_APPLICATION_ERROR(-20004, 'ERROR: No se pueden inscribir más jugadres en el equipo: ' || v_idEquipo || ', max jugadores: 6');
    END AFTER STATEMENT;
END maxJugadoresEquipo;

