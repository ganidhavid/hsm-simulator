package com.gani.hsmsimulator.serve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    //static ServerSocket variable
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        // read port and header
        int port = Integer.parseInt(args[0]);
        String header = null;
        if (null != args[1]) {
            header = args[1];
        }

        //create the socket server object
        server = new ServerSocket(port);

        while (true) {
            System.out.println("HSM Simulator Server -- Waiting for the client request");
            //creating socket. waiting, and send to handler for client connection
            Socket client = server.accept();
            System.out.println("HSM Simulator Server -- Accepting client, send to handler");
            new RequestHandler(client, header).start();
        }
    }
}
