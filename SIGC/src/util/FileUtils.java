package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public FileUtils(){

    }

    public static List<String> leerArchivoDesdeJar(String s) {

        InputStream is = null;

        BufferedReader br = null;

        String line;

        ArrayList<String> list = new ArrayList<String>();

        try
        {
            is = FileUtils.class.getResourceAsStream(s);

            br = new BufferedReader(new InputStreamReader(is));
            
            while (null != (line = br.readLine()))
            {
                list.add(line);
            }

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally
        {
            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }

    public Configuracion leerArchivo(String Path){
        
        BufferedReader br = null;

        Configuracion oConfiguracion = new Configuracion();

        ArrayList<String> oLst=new ArrayList<String>();

        try
        {

            br = new BufferedReader(new FileReader(new File (Path)));

            String linea;

            while((linea=br.readLine())!=null)
            {
                oLst.add(linea);
            }

            oConfiguracion.setUsuario(oLst.get(0));

            oConfiguracion.setPassword(oLst.get(1));

            oConfiguracion.setHost(oLst.get(2));

            oConfiguracion.setPort(oLst.get(3));

            oConfiguracion.setBd(oLst.get(4));

            oConfiguracion.setDriver(oLst.get(5));

            oConfiguracion.setUrl(oLst.get(6));

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {

            try{
                if( null != br )
                {
                   br.close();     
                }
            }
            catch (Exception ex1)
            {
                ex1.printStackTrace();
            }
        }

        return oConfiguracion;

    }

    public void escribirArchivoConfiguracion(Configuracion oConfiguracion, String Path) {

        borrarContenidoArchivo(Path);

        BufferedWriter bw = null;

        try
        {

            bw = new BufferedWriter(new FileWriter(Path));

            bw.write(oConfiguracion.getUsuario()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getPassword()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getHost()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getPort()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getBd()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getDriver()+System.getProperty("line.separator"));

            bw.write(oConfiguracion.getUrl()+System.getProperty("line.separator"));

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != bw)
                  bw.close();
            } 
            catch (Exception ex1)
            {
                ex1.printStackTrace();
            }
        }

    }

    private void borrarContenidoArchivo(String Path)
    {
        try
        {
            File oFile=new File(Path);

            oFile.delete();

            oFile.createNewFile();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
