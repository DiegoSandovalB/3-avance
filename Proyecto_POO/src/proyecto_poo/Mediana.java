/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeyos
 */
public class Mediana extends Programa implements ImprimirDatos{
    @Override
        public void Imprimir(){
        System.out.println("Ingresa la cantidad de numeros que deseas utilizar");
        Scanner input = new Scanner(System.in);
        int n = 0;
        try{
        n = input.nextInt();
        }catch(InputMismatchException e){ 
         System.out.println("Upps!! Fallo la captura!! ");
        }
        double datos []= new double [n];
        System.out.println("ingresa los datos:");
        for(int i =0; i<= n-1 ; i++){
        datos[i] = input.nextDouble();
        }
        Arrays.sort(datos);
        double mediana;
        int mitad = n/2;
        if(n == 0){
            mediana = (datos [mitad-1] + datos [mitad])/2;
        }else{
        mediana = datos[mitad];
        }
        System.out.println("La mediana es: " + mediana);
        String medianatxt = " ";
        medianatxt = Double.toString(mediana);
 
        Path ruta = Paths.get("C:/Users/yeyos/Desktop/Proyecto POO/GuardarMediana.txt");
        OutputStream abrirArchivo;
        OutputStreamWriter escribirArchivo;
        BufferedWriter escribirTexto;
       
   
        try {
            abrirArchivo = Files.newOutputStream(ruta);
            escribirArchivo = new OutputStreamWriter(abrirArchivo);
            escribirTexto = new BufferedWriter (escribirArchivo);
            escribirTexto.write("La mediana es: " + medianatxt);
            escribirTexto.flush();
            escribirTexto.close();
        } catch (IOException ex) {
            Logger.getLogger(Mediana.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}


