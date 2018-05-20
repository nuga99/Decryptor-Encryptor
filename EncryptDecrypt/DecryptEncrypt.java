import xoxo.XoxoView;
import xoxo.XoxoController;


/**
 * Main class that runs the Xoxo Controller.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Muhammad Ardivan Satrio Nugroho
 */
public class DecryptEncrypt{

    /**
     * The main method.
     * @param args Argument strings.
     */
    public static void main(String[] args) {
        XoxoView view = new XoxoView();
        XoxoController controller = new XoxoController(view);
        controller.run();
    }
    
}
