package com.rukon.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5000)) {


            while(true) {
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
                new Echoer(serverSocket.accept()).start();
            }
        }
        catch (IOException exception){
            System.out.println("Server Exception " + exception.getMessage());
            exception.printStackTrace();
        }

    }
}
