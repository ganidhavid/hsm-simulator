package com.gani.hsmsimulator.serve;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class SocketServer {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port;

    public static void main(String[] args) throws IOException {
        // read properties
        //Properties prop = readProperties();
        //int port = Integer.parseInt(prop.getProperty("server.port"));
        int port = 1501;

        //create the socket server object
        server = new ServerSocket(port);

        boolean run = true;

        while (run) {
            System.out.println("Waiting for the client request");
            //creating socket. waiting, and send to handler for client connection
            new RequestHandler(server.accept()).start();
        }

    }

    private static int getMessageLength(int i0, int i1){
        // decimal to hex
        String i0Str = Integer.toHexString(i0);
        String i1Str = Integer.toHexString(i1);
        // concat
        String hexStr = i0Str + i1Str;
        // hex to decimal
        return Integer.parseInt(hexStr,16);
    }

    private static Properties readProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }
}
