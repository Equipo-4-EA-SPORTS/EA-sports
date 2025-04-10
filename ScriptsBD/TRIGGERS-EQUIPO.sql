/*TRIGGER PARA COMPROBAR FECHA DE FUNDACION
    En el caso de que se ponga una fecha que no este
    entre el 02/06/2020 (fecha de salida de VALORANT) 
    y la fecha acutal (abmos excluidos) genera una exceptcion 
    y no deja insertar el equipo
*/
CREATE OR REPLACE TRIGGER equiposFechaFundInterval
BEFORE INSERT OR UPDATE OF fechafund ON EQUIPOS
FOR EACH ROW
DECLARE
    v_fechaMin Date := to_date('02/06/2020','DD/MM/YYYY');
    e_fechaIncorrecta exception;
BEGIN
    if :NEW.fechafund<v_fechaMin OR :NEW.fechafund>SYSDATE then
        RAISE e_fechaIncorrecta;
    END IF;
    EXCEPTION
        WHEN e_fechaIncorrecta THEN
            RAISE_APPLICATION_ERROR(-20001,'LA FECHA DEBE DE ESTAR COMPRENDIDA ENTRE EL 02/06/2020 Y LA FECHA ACTUAL EXCLUIDOS AMBOS');
END;

/*TRIGGER PARA COMPROBAR EL NOMBRE
  En el caso de que se ponga un nombre ya 
  escogido por un equipo salta una excepcion y no deja insertar
*/

CREATE OR REPLACE TRIGGER nombreDuplicadoEquipo
BEFORE INSERT OR UPDATE OF nombre ON EQUIPOS
FOR EACH ROW
DECLARE
    e_nombreDuplicado exception;
    v_filasSeleccionadas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_filasSeleccionadas
    FROM EQUIPOS
    WHERE lower(nombre) = lower(:NEW.nombre);
    
    IF v_filasSeleccionadas>0 THEN
        RAISE e_nombreDuplicado;
    END IF;

    EXCEPTION
        WHEN e_nombreDuplicado THEN
            RAISE_APPLICATION_ERROR(-20002,'YA EXISTE UN EQUIPO CON ESE NOMBRE');
END;



