package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);
        boolean c = true;
        
        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // per la tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");

            while(c){
                System.out.println(br.readLine()); // ricevo: cosa vuoi fare
                String comando = tastiera.readLine();
                pr.println(comando);
                
                if(comando.equals("Q")){
                    break;
                }
                System.out.println(br.readLine());
            }
        
        pr.println("Client disconnesso");

        s.close();
    }
}
