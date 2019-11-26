package com.gani.hsmsimulator.serve;

import com.gani.hsmsimulator.controller.CommandController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(clientSocket.getInputStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(clientSocket.getOutputStream());

            int i0 = inputStream.read();
            int i1 = inputStream.read();

            int msgLength = getMessageLength(i0, i1);

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < msgLength; i++){
                stringBuffer.append((char) inputStream.read());
            }

            // process request
            String response = CommandController.processRequest(stringBuffer.toString());

            // prepare mli
            String mli = getMli(response);
            // construct response hex
            String responseHex = mli + convertStringToHex(response);
            // covert to byte arrays
            byte [] byteArrays = hexStringToByteArray(responseHex);
            // send response
            outputStream.write(byteArrays);

            // close
            outputStream.close();
            inputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
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

    private static String convertStringToHex(String str) {
        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString();
    }

    private static String getMli(String commandHexString) {
        String hexString = Integer.toHexString(commandHexString.length());
        int digit = String.valueOf(hexString).length();

        switch (digit) {
            case 1:
                hexString = "000" + hexString;
                break;
            case 2:
                hexString = "00" + hexString;
                break;
            case 3:
                hexString = "0" + hexString;
                break;
        }
        return hexString;
    }
}