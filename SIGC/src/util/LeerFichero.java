
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public void leer(String nombreFichero) {
        try {

            FileReader fr = new FileReader(nombreFichero);
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
            while ((sCadena = bf.readLine()) != null) {
                System.out.println(sCadena);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public Configuracion leerLineaConfiguracion(String nombreFichero) {
        Configuracion configuracion = new Configuracion();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombreFichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int contadorLinea=1 ;
            while ((linea = br.readLine()) != null) {                
                //System.out.println("liena = "+linea);
                switch(contadorLinea){
                    case 1: configuracion.setUsuario(linea); break;
                    case 2: configuracion.setPassword(linea); break;
                    case 3: configuracion.setHost(linea); break;
                    case 4: configuracion.setPort(linea); break;
                    case 5: configuracion.setBd(linea); break;
                    case 6: configuracion.setDriver(linea); break;
                    case 7: configuracion.setUrl(linea); break;
                }                                       
                contadorLinea = contadorLinea+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return configuracion;
    }
}
