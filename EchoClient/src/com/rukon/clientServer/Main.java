package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) {
	try(Socket socket = new Socket("localhost", 5000)) {
       socket.setSoTimeout(5000);
        BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter stringtoEcho = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        String echoString;
        String response;

        do {
            System.out.println("Enter the new line: ");
            echoString = scanner.nextLine();
          //  System.out.println("Changes in Git Hub");
            stringtoEcho.println(echoString);

            if(!echoString.equals("exit")){
                response = echoes.readLine();
                System.out.println(response);
            }


        }
        while (!echoString.equals("exit"));

    }
	catch (SocketTimeoutException e){
	    e.printStackTrace();
    }

	catch (IOException e){
        System.out.println("Exception in Client " + e.getMessage());
        e.printStackTrace();
    }
    }
}
