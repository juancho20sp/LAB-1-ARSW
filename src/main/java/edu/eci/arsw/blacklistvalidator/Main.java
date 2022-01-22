/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {
    
    public static void main(String a[]){
        HostBlackListsValidator hblv=new HostBlackListsValidator();

        // Part Two
        //List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55");
        //List<Integer> blackListOcurrences=hblv.checkHost("212.24.24.55", 8);

        // PART THREE
        // One Thread -> A LOT OF TIME
        // List<Integer> blackListOcurrences=hblv.checkHost("202.24.24.55", 1);

        // Threads === # Cores
        // int totalCores = Runtime.getRuntime().availableProcessors();
        // List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55", totalCores);

        // Threads ===  2 * # Cores
        // List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55", totalCores * 2);

        // 50 Threads -> No picture because it was too fast | 3.8 sec
        // List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55", 50);

        // 100 Threads -> No picture because it was too fast | 3.75 sec
         List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55", 100);

        // P === CLASES DE EQUIVALENCIA


        // PART FOUR
        /**
         * Cómo se comporta la solución usando tantos hilos de procesamiento como núcleos comparado con el resultado de usar el doble de éste?.
         *
         * Usar el doble de núcleos como número de hilos redujo a la mitad el tiempo de ejecución.
         *
         * De acuerdo con lo anterior, si para este problema en lugar de 100 hilos en una sola CPU se pudiera usar 1 hilo en cada una de 100 máquinas hipotéticas, la ley de Amdahls se aplicaría mejor?. Si en lugar de esto se usaran c hilos en 100/c máquinas distribuidas (siendo c es el número de núcleos de dichas máquinas), se mejoraría?. Explique su respuesta.
         */

        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);
    }
    
}
