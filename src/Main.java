import Controlador.ModeloController;
import Controlador.VistaController;

public class Main {
    public static void main(String[] args) {
        ModeloController mc = new ModeloController();
        VistaController vc = new VistaController(mc);
        mc.setVistaController(vc);
    }
}