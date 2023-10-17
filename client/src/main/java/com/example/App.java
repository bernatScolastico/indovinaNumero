package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class App 
{
    public static void main( String[] args )
    {
        try {
            //CREO UN SOCKET
            Socket socket = new Socket("localhost", 3000);
            //CREO IL TUBO DA DOVE MI VIENE LA RISPOSTA DAL SERVER
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
            //CREO IL TUBO DA DOVE MANDARE AL SERVER
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //CREO IL PRENDI DA TASTIERA
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

            do{
                //CHIEDO IL NUMERO ALL'UTENTE
                System.out.println("Indovina il numero generato:");
                String tentativo = tastiera.readLine();
                //INVIO IL TENTATIVO AL SERVER
                out.writeBytes(tentativo + "\n");
                //PRENDO RISPOSTA DAL SERVER E STAMPO
                String str = in.readLine();
                System.out.println("Il numero [" + tentativo + "]" + str);
            }while(true);
        }
        catch (Exception e){
            System.out.println("Errore");
        }
    }
}
