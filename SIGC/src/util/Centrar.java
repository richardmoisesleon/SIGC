
package util;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;

public class Centrar {
    public Centrar(JInternalFrame aThis){
        Dimension dim=aThis.getToolkit().getScreenSize();
        Rectangle rec=aThis.getBounds();
        aThis.setLocation((dim.width-rec.width)/2, (dim.height-rec.height)/2);
        aThis.requestFocus();
    }
    public Centrar(JInternalFrame aThis, int h){
        Dimension dim=aThis.getToolkit().getScreenSize();
        Rectangle rec=aThis.getBounds();
        aThis.setLocation((dim.width-rec.width)/2, h);
        aThis.requestFocus();
    }
}
