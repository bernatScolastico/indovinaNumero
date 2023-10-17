package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
public class App 
{
    public static void main( String[] args )
    {
        try {
            //CREA LA PORTA COLLEGATA AL SERVER 3000
            ServerSocket ss = new ServerSocket(6000);
            //ACCETTA IL COLLEGAMENTO
            Socket s = ss.accept();
            //CREA IL TUBO PER MANDARE E RICEVERE 
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
            Random random = new Random();
            int number = random.nextInt(100)+ 1;
            System.out.println(number);

            do{
                int numero = Integer.parseInt(in.readLine());
                String g = " ";
                if(numero > number){
                    g = g + "MAGGIORE";
                }
                if (numero < number){
                    g = g + "MINORE";
                }
                if (numero == number){
                    g = g + "INDOVINATO";
                    break;
                }

                out.writeBytes(g + "\n");
            }while(true);
        } 
        catch (Exception e) {
            System.out.println("ERRORE");;
        }
    }
}
