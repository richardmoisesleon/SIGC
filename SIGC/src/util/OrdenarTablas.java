/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.JXTable;


public class OrdenarTablas {

    public void asignarTamanioColumna(JXTable ojXTable, int nrocolumna, int tamanio) {
        TableColumnModel oTableColumnModel=ojXTable.getColumnModel();
        TableColumn columnaNRO = oTableColumnModel.getColumn(nrocolumna);
        columnaNRO.setPreferredWidth(tamanio);
    }

    public void centrarColumna(JXTable oJXTable, int nrocolumna) {

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        oJXTable.getColumnModel().getColumn(nrocolumna).setCellRenderer(tcr);

    }

    public void alinearIzquierdaColumna(JXTable oJXTable, int nrocolumna) {

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        oJXTable.getColumnModel().getColumn(nrocolumna).setCellRenderer(tcr);

    }

    public void alinearDerechaColumna(JXTable oJXTable, int nrocolumna) {

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        oJXTable.getColumnModel().getColumn(nrocolumna).setCellRenderer(tcr);

    }

    public void centrarCabecerasColumna(JXTable oJXTable, int nrocolumna) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.CENTER, SwingConstants.CENTER);
        oJXTable.getColumnModel().getColumn(nrocolumna).setHeaderRenderer(headerRenderer);

    }

    public void izquierdaCabecerasColumna(JXTable oJXTable, int nrocolumna) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.LEFT, SwingConstants.LEFT);
        oJXTable.getColumnModel().getColumn(nrocolumna).setHeaderRenderer(headerRenderer);

    }

    public void derechaCabecerasColumna(JXTable oJXTable, int nrocolumna) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.RIGHT, SwingConstants.RIGHT);
        oJXTable.getColumnModel().getColumn(nrocolumna).setHeaderRenderer(headerRenderer);

    }

    public void centrarCabecerasColumna(JXTable oJXTable) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.CENTER, SwingConstants.CENTER);
        for (int i = 0; i < oJXTable.getColumnCount(); i++) {
            oJXTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }


    }

    public void izquierdaCabecerasColumna(JXTable oJXTable) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.LEFT, SwingConstants.LEFT);
        for (int i = 0; i < oJXTable.getColumnCount(); i++) {
            oJXTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }


    }

    public void derechaCabecerasColumna(JXTable oJXTable) {

        MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer(
                SwingConstants.RIGHT, SwingConstants.RIGHT);
        for (int i = 0; i < oJXTable.getColumnCount(); i++) {
            oJXTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }


    }
    public void anchoColumnasAutomatico(JXTable oJXTable){
        oJXTable.getAutoResizeMode();
    }
}
