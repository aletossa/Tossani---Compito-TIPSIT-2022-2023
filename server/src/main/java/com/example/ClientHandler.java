package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    private boolean check = true;
    private static int qtaBiglietti = 5;

    public ClientHandler(Socket s) {
        this.s = s;
        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            
            
            System.out.println(br.readLine());

            
            while(check){
                

                pr.println("Cosa vuoi fare");
                String comando = br.readLine();

                if(comando.equals("D")){
                    pr.println("Disponibili " + qtaBiglietti + " biglietti");
                }
                if(comando.equals("A")){
                    if(qtaBiglietti == 0){
                        pr.println("Biglietti esauriti");
                    }
                    else{
                        qtaBiglietti--;
                        pr.println("Biglietto acquistato");
                    }
                    
                }
                else if(comando.equals("Q")){
                    break;
                }
            }
            System.out.println(br.readLine());
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}