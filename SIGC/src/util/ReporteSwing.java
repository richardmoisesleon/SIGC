package util;

import java.util.List;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteSwing {

    private JDesktopPane des;
    private List listaClases;
    private Map parametros;
    private String nombreReporte;
    private String pathReporte;

    public ReporteSwing(JDesktopPane JD) {

        this.des = JD;

        this.listaClases = null;

        this.parametros = null;

        this.nombreReporte = "";
        
        this.pathReporte = "";
        
    }

    public void imprimirReporte() throws Exception {

        JasperReport reporte = (JasperReport) JRLoader.loadObject(pathReporte + nombreReporte);

        JasperPrint jPrint = JasperFillManager.fillReport(reporte, getParametros(), new JRBeanCollectionDataSource(getListaClases()));

        jPrint.setLocaleCode("EN");

        JasperPrintManager.printReport(jPrint, true);

    }

    public void lanzarVistaReporte() throws Exception {

        JasperReport reporte = (JasperReport) JRLoader.loadObject(pathReporte + nombreReporte);

        JasperPrint jPrint = JasperFillManager.fillReport(reporte, getParametros(), new JRBeanCollectionDataSource(getListaClases()));

        jPrint.setLocaleCode("EN");

        JasperViewer jasperView = new JasperViewer(jPrint, false);

        jasperView.setZoomRatio((float)0.70);

        jasperView.setVisible(true);

    }

    //lanza la vista del reporte
    public void lanzarVistaReporteNoButtonPrint() throws Exception {
        JasperReport reporte = (JasperReport) JRLoader.loadObject(pathReporte + nombreReporte);
        System.out.println("path:"+ pathReporte + nombreReporte);        
        JasperPrint jPrint = JasperFillManager.fillReport(reporte, getParametros(), new JRBeanCollectionDataSource(getListaClases()));
        JInternalFrame viewer=new JInternalFrame("Vista previa");
        viewer.setClosable(true);
        ReporteVista jrViewer = new ReporteVista(jPrint);
        jrViewer.setPrintEnabled(false);
        viewer.add(jrViewer);
        viewer.setSize(900,550);
        new Centrar(viewer,20);
        des.add(viewer);
        viewer.setVisible(true);

    }

    public void imprimirConCopias(int nroCopias)throws Exception
    {
        
        JasperReport reporte = (JasperReport) JRLoader.loadObject(pathReporte + nombreReporte);

        JasperPrint jPrint = JasperFillManager.fillReport(reporte, getParametros(), new JRBeanCollectionDataSource(getListaClases()));

        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

        printRequestAttributeSet.add(MediaSizeName.NA_LEGAL);

        printRequestAttributeSet.add(new Copies(nroCopias));

        PrintService impresoraPredeterminada =   PrintServiceLookup.lookupDefaultPrintService();

        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);

        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);

        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresoraPredeterminada);
        
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);

        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

        exporter.exportReport();

    }

//    public static void imprimir(JasperPrint jasperPrint)  throws Exception {
//        PrintRequestAttributeSet printRequestAttributeSet =   new HashPrintRequestAttributeSet();
//        //}
//        PrintService impresoraPredeterminada =   PrintServiceLookup.lookupDefaultPrintService();
//        // Los métodos getPageWidth y getPageHeight devuelven
//        // en pixeles, de forma que hay que transformar
//        // dividiendo x 72
//        float w= jasperPrint.getPageWidth()/72f;
//        float h=jasperPrint.getPageHeight()/72f;
//        // Busco el tamaño de papel de la impresora más parecido
//        printRequestAttributeSet.add(    MediaSize.findMedia(w, h, MediaSize.INCH));
//        // Configuro el area de impresión
//        int unidad=MediaPrintableArea.INCH;
//        printRequestAttributeSet.add(   new MediaPrintableArea(0, 0, w, h, unidad));
//        printRequestAttributeSet.add(new Copies(2));
//        // Orientación
////        OrientationRequested orientation = OrientationRequested.PORTRAIT;
////        if(jasperPrint.getOrientation() == JRReport.ORIENTATION_LANDSCAPE)
////            orientation = OrientationRequested.LANDSCAPE;
////        printRequestAttributeSet.add(orientation);
//        PrintService service = impresoraPredeterminada;
//        JRExporter exporter = new JRPrintServiceExporter();
//        exporter.setParameter(   JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(   JRPrintServiceExporterParameter.PRINT_SERVICE, service);
//        exporter.setParameter(   JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,   printRequestAttributeSet);
//        exporter.exportReport();
//    }

//    public ReporteSwing(JDesktopPane JD,String nombreReporte, List listaClase, Map parametros){
//        this.des=JD;
//        this.nombreR=nombreReporte;
//        this.listaClases=listaClase;
//        this.parametros=parametros;
//    }
//
//    public ReporteSwing(JDesktopPane JD, String nombreReporte, List listaClase, Map parametros, String nombre, String ruta){
//        this.des=JD;
//        this.nombreR=nombreReporte;
//        this.listaClases=listaClase;
//        this.parametros=parametros;
//        this.nombreReporte=nombre;
//        this.ruta=ruta;
//    }
//
//    public ReporteSwing(JDesktopPane JD, String nombreReporte, Map parametros, String nombre, String ruta){
//        this.des=JD;
//        this.nombreR=nombreReporte;
//        this.parametros=parametros;
//        this.nombreReporte=nombre;
//        this.ruta=ruta;
//    }
//
//    public ReporteSwing(JDesktopPane JD, String nombreReporte, Map parametros){
//        this.des=JD;
//        this.nombreR=nombreReporte;
//        this.parametros=parametros;
//    }
//
//    public ReporteSwing(JDesktopPane JD, File directorio, List oLstNotas, Map parametros) {
//        this.des=JD;
//        this.file=directorio;
//        this.listaClases=oLstNotas;
//        this.parametros=parametros;
//    }
//    public void imprimirReporte(){
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(path+nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, getParametros(),new JRBeanCollectionDataSource(getListaClases()));
//            jPrint.setLocaleCode("EN");
//            JasperPrintManager.printReport(jPrint, true);
//            //jasperView.setZoomRatio((float)0.70);
//            //jasperView.setVisible(true);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void imprimirReporteConConexion(){
//        try {
//            BaseDA oBaseDA = new BaseDA();
//            Connection cn = oBaseDA.conectar();
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(path+nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, getParametros(), cn);
//            jPrint.setLocaleCode("EN");
//            JasperPrintManager.printReport(jPrint, true);
//            oBaseDA.cerrarConexion();
//            //jasperView.setZoomRatio((float)0.70);
//            //jasperView.setVisible(true);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarVistaReporte(){
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, null,new JRBeanCollectionDataSource(getListaClases()));
//            jPrint.setLocaleCode("EN");
//            JasperViewer jasperView=new JasperViewer(jPrint, false);
//            //jasperView.setZoomRatio((float)0.70);
//            jasperView.setVisible(true);
//        } catch (Exception ex) {
//            System.out.println("Error: "+ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarVistaReporteFile(){
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(file);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, null,new JRBeanCollectionDataSource(getListaClases()));
//            jPrint.setLocaleCode("EN");
//            JasperViewer jasperView=new JasperViewer(jPrint, false);
//            //jasperView.setZoomRatio((float)0.70);
//            jasperView.setVisible(true);
//        } catch (Exception ex) {
//            System.out.println("Error: "+ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarVistaReporteStream(){
//        try {
//            InputStream fis =this.getClass().getResourceAsStream(nombreR);
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(fis);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, null,new JRBeanCollectionDataSource(getListaClases()));
//            jPrint.setLocaleCode("EN");
//            JasperViewer jasperView=new JasperViewer(jPrint, false);
//            //jasperView.setZoomRatio((float)0.70);
//            jasperView.setVisible(true);
//        } catch (Exception ex) {
//            System.out.println("Error: "+ex.getMessage());
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarVistaReporteConConexion(){
//        try {
//            BaseDA oBaseDA = new BaseDA();
//            Connection cn = oBaseDA.conectar();
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(path+nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, getParametros(), cn);
//            jPrint.setLocaleCode("EN");
//            JasperViewer jasperView=new JasperViewer(jPrint, false);
//            //jasperView.setZoomRatio((float)0.70);
//            jasperView.setVisible(true);
//            oBaseDA.cerrarConexion();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarReportePdf(){
//        try {
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(path+nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, getParametros(),new JRBeanCollectionDataSource(getListaClases()));
//            jPrint.setLocaleCode("EN");
//            JRExporter expo=new JRPdfExporter();
//            expo.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
//            expo.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(ruta+"\\"+getNombreReporte()+".pdf"));
//            expo.exportReport();
//            JOptionPane.showInternalMessageDialog(getDes(), "El reporte se exportó correctamente");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void lanzarReportePdfConConexion(){
//        try {
//            BaseDA oBaseDA = new BaseDA();
//            Connection cn = oBaseDA.conectar();
//            JasperReport reporte=(JasperReport)JRLoader.loadObject(path+nombreR);
//            JasperPrint jPrint=JasperFillManager.fillReport(reporte, getParametros(), cn);
//            jPrint.setLocaleCode("EN");
//            JRExporter expo=new JRPdfExporter();
//            expo.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
//            expo.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(ruta+"\\"+getNombreReporte()+".pdf"));
//            expo.exportReport();
//            oBaseDA.cerrarConexion();
//            JOptionPane.showInternalMessageDialog(getDes(), "El reporte se exportó correctamente");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    public JDesktopPane getDes() {
        return des;
    }

    public void setDes(JDesktopPane des) {
        this.des = des;
    }

    public List getListaClases() {
        return listaClases;
    }

    public void setListaClases(List listaClases) {
        this.listaClases = listaClases;
    }

    public Map getParametros() {
        return parametros;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public String getPathReporte() {
        return pathReporte;
    }

    public void setPathReporte(String pathReporte) {
        this.pathReporte = pathReporte;
    }
}
