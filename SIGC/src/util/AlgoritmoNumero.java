package util;

import java.util.Date;
import java.util.Random;

public class AlgoritmoNumero {

    public AlgoritmoNumero() {
    }

    Random random = new Random();

    //Retoirna un numero intero aletorio de 8 digitos
    // numeroLimite = 99999999
    public int generarNumero(int numeroLimite, int idCertificado, Date fechaEmision, int idSecretarioGeneral, int idJefeOficina, int idResponsableCertificado) {
        //numero de retorno del metodo
        int numeroRetorno;

        //los milisegundos
        long milisegundos = fechaEmision.getTime();
        //System.out.println(milisegundos);

        //obtenemos los segundos
        long segundos = milisegundos / 1000;
        //System.out.println(segundos);

        //obtenemos las horas
        long horas = segundos / 3600;
        //System.out.println(horas);

        //obtenemos el dia
        long dia = fechaEmision.getDate();
        //System.out.println(dia);
        
        //obtenemos el mes
        long mes = fechaEmision.getMonth();
        //System.out.println(mes);

        //obtenemos el nio
        long año = fechaEmision.getYear();
        //System.out.println(año);

        //construir la semilla para la generacion de numero aletorio
        int semillaFecha = (int) (milisegundos + segundos + dia + mes + año);
        int semillaCodigo = idCertificado + idJefeOficina + idResponsableCertificado + idSecretarioGeneral;
        int semillaFinal = semillaFecha + semillaCodigo;

        //ingresando la semilla final
        random.setSeed(semillaFinal);

        //COnvertimos en entero el numero aleatorio, con un limite de numero
        numeroRetorno = random.nextInt(numeroLimite);

        //numero de retorno
        return numeroRetorno;
    }
}
