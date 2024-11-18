import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JPanel panel1;
    private JTextField nombreTFA;
    private JTextField cantidadTFA;
    private JTextField precioTFA;
    private JTextField IDTFA;
    private JButton agregarButton;
    private JTextField nombreTFE;
    private JTextField IDTFE;
    private JButton eliminarButton;
    private JTextField IDTFB;
    private JTextField nombreTFB;
    private JButton buscarButton;
    private JLabel debugLabel;
    private JButton listarElInventarioButton;
    private ArbolBinarioDeBusqueda inv;
    public Ventana() {
        setContentPane(panel1);
        setTitle("Inventario tienda de mascotas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450,350);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        inv = new ArbolBinarioDeBusqueda();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreTFA.getText().length() != 0
                        && IDTFA.getText().length() != 0
                        && precioTFA.getText().length() != 0
                        && cantidadTFA.getText().length() != 0) {
                    int intIDTFA;
                    try {
                        intIDTFA = Integer.parseInt(IDTFA.getText());
                    }
                    catch (NumberFormatException f){
                        intIDTFA = 0;
                    }
                    int intprecioTFA;
                    try {
                        intprecioTFA = Integer.parseInt(precioTFA.getText());
                    }
                    catch (NumberFormatException f){
                        intprecioTFA = 0;
                    }
                    int intcantidadTFA;
                    try {
                        intcantidadTFA = Integer.parseInt(cantidadTFA.getText());
                    }
                    catch (NumberFormatException f){
                        intcantidadTFA = 0;
                    }
                    inv.insertar(new Producto(nombreTFA.getText(),
                            intIDTFA,
                            intprecioTFA,
                            intcantidadTFA));
                    nombreTFA.setText("");
                    IDTFA.setText("");
                    precioTFA.setText("");
                    cantidadTFA.setText("");
                    debugLabel.setText("se agrego el producto");
                    System.out.println(inv);
                }else{
                    debugLabel.setText("Porfavor llene todos los campos de agregar producto");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreTFE.getText().length() != 0
                        && IDTFE.getText().length() != 0){
                    int intIDTFE;
                    try {
                        intIDTFE = Integer.parseInt(IDTFE.getText());
                    }
                    catch (NumberFormatException f){
                        intIDTFE = 0;
                    }
                    inv.eliminar(new Producto(intIDTFE));
                    inv.eliminar(new Producto(nombreTFE.getText()));
                    nombreTFE.setText("");
                    IDTFE.setText("");
                    debugLabel.setText("se elimino el producto");
                    System.out.println(inv);
                }else{
                    debugLabel.setText("Porfavor llene todos los campos de eliminar producto");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreTFB.getText().length() != 0
                        && IDTFB.getText().length() != 0){
                    int intIDTFB;
                    try {
                        intIDTFB = Integer.parseInt(IDTFB.getText());
                    }
                    catch (NumberFormatException f){
                        intIDTFB = 0;
                    }
                    if((inv.buscar(new Producto(intIDTFB)) || inv.buscar(new Producto(nombreTFB.getText())))){
                        debugLabel.setText(inv.buscar2(new Producto(intIDTFB)));
                        nombreTFB.setText("");
                        IDTFB.setText("");
                    }else{
                        debugLabel.setText("no se encontro el producto con nombre: " + nombreTFB.getText() + " e ID: " + intIDTFB);
                        nombreTFB.setText("");
                        IDTFB.setText("");
                    }
                }else{
                    debugLabel.setText("Porfavor llene todos los campos de Busqueda de producto");
                }
            }
        });
        listarElInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            debugLabel.setText(inv.recorrerEnOrden());
            }
        });
    }
}