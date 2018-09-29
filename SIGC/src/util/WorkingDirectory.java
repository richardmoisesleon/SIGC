
package util;

import java.io.File;
import java.net.URL;

public class WorkingDirectory {

    private static File WORKING_DIRECTORY;

    public static File getDirectorio(String direccion)
    {
        try {
            URL url = WorkingDirectory.class.getResource(direccion);
            System.out.println(url);
            //File f=new File(url.toURI());
            //WORKING_DIRECTORY = f;
            if (url.getProtocol().equals("file")) {
                File f = new File(url.toURI());
                //f = f.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile();
                WORKING_DIRECTORY = f;
            } else if (url.getProtocol().equals("jar")) {
                //String expected = "!"+direccion;
                String s = url.toString();
                s = s.substring(4);
                //s = s.substring(0, s.length() - expected.length());
                System.out.println("\n\n"+s+"\n\n");
                File f = new File(new URL(s).toURI());
                //f = f.getParentFile().getParentFile().getParentFile();
                WORKING_DIRECTORY = f;
            }
        } catch (Exception e) {
            WORKING_DIRECTORY = new File(".");
        }
        return WORKING_DIRECTORY;
    }
}
