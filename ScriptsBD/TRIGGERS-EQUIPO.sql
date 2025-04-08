CREATE OR REPLACE TRIGGER maxEquipos
    BEFORE INSERT ON EQUIPOS
    FOR EACH ROW
    DECLARE
        v_filas NUMBER;
        e_maxEquipos exception;
    BEGIN
        Select COUNT(*) INTO v_filas
        FROM EQUIPOS;

        IF v_filas>6 THEN
            raise e_maxEquipos;
        end if;

    EXCEPTION
        WHEN e_maxEquipos THEN
            RAISE_APPLICATION_ERROR(-20001,'NO SE PUEDEN INSERTAR MAS EQUIPOS');
    END maxEquipos;

CREATE OR REPLACE TRIGGER equiposFechaFundInterval
    BEFORE INSERT OR UPDATE OF fechafund ON EQUIPOS
    FOR EACH ROW
    DECLARE
        v_fechaMin Date := to_date('02/06/2020','DD/MM/YYYY');
        e_fechaIncorrecta exception;
    BEGIN
        if :NEW.fechafund<v_fechaMin OR :NEW.fechafund>SYSDATE then
            RAISE e_fechaIncorrecta;
        end if;
        EXCEPTION
            WHEN e_fechaIncorrecta THEN
                RAISE_APPLICATION_ERROR(-20002,'LA FECHA DEBE DE ESTAR COMPRENDIDA ENTRE EL 02/06/2020 Y LA FECHA ACTUAL EXCLUIDOS AMBOS');
    END;

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
        end if;

        EXCEPTION
            WHEN e_nombreDuplicado THEN
                RAISE_APPLICATION_ERROR(-20003,'YA EXISTE UN EQUIPO CON ESE NOMBRE');
    end;

