package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionesHash {

    //public static String MD5 = "MD5";

    /***
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     * @param digest arreglo de bytes a convertir
     * @return String creado a partir de <code>digest</code>
     */
    private static String toHexadecimal(byte[] digest){
        
        String hash = "";

        for(byte aux : digest) {

            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);

        }
        return hash;
    }

    public static String funcionResumenMd5Cadena(String contrasenia) throws Exception {

        byte[] digest = null;
        byte[] buffer = contrasenia.getBytes();
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {

            System.out.println("Error creando Digest");

        }

        return toHexadecimal(digest);

    }
}
