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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeyos
 */
public class Media extends Programa implements ImprimirDatos{
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
        double suma = 0;
        double media = 0;
            for (int i = 0; i <= n-1; i++) {
                suma += datos[i];
                 media = suma/n;
            }System.out.println("La media es: " + media);
        
        String mediatxt = " ";
        mediatxt = Double.toString(media);
 
        Path ruta = Paths.get("C:/Users/yeyos/Desktop/Proyecto POO/GuardarMedia.txt");
        OutputStream abrirArchivo;
        OutputStreamWriter escribirArchivo;
        BufferedWriter escribirTexto;
       
   
        try {
            abrirArchivo = Files.newOutputStream(ruta);
            escribirArchivo = new OutputStreamWriter(abrirArchivo);
            escribirTexto = new BufferedWriter (escribirArchivo);
            escribirTexto.write("La mediana es: " + mediatxt);
            escribirTexto.flush();
            escribirTexto.close();
        } catch (IOException ex) {
            Logger.getLogger(Mediana.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }       
}
        
