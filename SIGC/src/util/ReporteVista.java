package util;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class ReporteVista extends JRViewer {

    public static int intbtnPresionado = 0;

    public ReporteVista(JasperPrint jrPrint) {
        super(jrPrint);
//        btnPrint.addActionListener(new ActionListener() {
//
//            @Override
//            //Metodo para controlar el evento click del boton guarar.
//            public void actionPerformed(ActionEvent arg0) {
//                System.out.println("presiono");
//                intbtnPresionado = 1;
//                System.out.println("Valor del la variable intbtnPresionado: " + intbtnPresionado);
//            }
//        });
    }
    ///Metodo para habilitar o deshabilitar el boton guardar

    public void setPrintEnabled(boolean enabled) {
        btnPrint.setVisible(enabled);
    }
    private static final long serialVersionUID = 1271367514255520348L;
}
