package co.edu.escuelaing.arem.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerOperations {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
            System.out.println("Waiting for numbers");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine, function="cos";
        double num;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            if (inputLine.contains("fun:")){
                function=inputLine.split(":")[1];
                if(operation(1,function).equals("La funcion no es correcta")){
                    outputLine = "Función incorrecta";
                }else{
                    outputLine = "Función asignada " + function;
                }

            }else{
                num=verificacion(inputLine);
                outputLine = "Respuesta: " + operation(num,function);
            }
            out.println(outputLine);
            if (outputLine.equals("Respuesta: Bye."))
                break;

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    private static String operation(double number,String funct){
        String ans=null;
        if (funct.equals("cos")){
            ans=String.valueOf(Math.cos(number));
        }else if (funct.equals("sin")){
            ans=String.valueOf(Math.sin(number));
        }else if (funct.equals("tan")){
            ans=String.valueOf(Math.tan(number));
        }else{
            ans="La funcion no es correcta";
        }
        return ans;
    }

    private static double verificacion(String inputLine){
        float num = -1;
        if (inputLine.contains("PI")){
            if (inputLine.contains("/")){
                if (inputLine.split("PI")[0].isEmpty()){
                    num = (float)Math.PI / Float.valueOf(inputLine.split("/")[1]);
                }else {
                    num = Float.valueOf(inputLine.split("PI")[0])* (float)Math.PI / Float.valueOf(inputLine.split("/")[1]);
                }
            }else{
                if (inputLine.length()==2){
                    num = (float)Math.PI;
                }else {
                    num = Float.valueOf(inputLine.split("PI")[0])*(float)Math.PI;
                }
            }
        }else if (inputLine.contains("/")){
            num = Float.valueOf(inputLine.split("/")[0]) / Float.valueOf(inputLine.split("/")[1]);
        }else {
            num = Integer.parseInt(inputLine);
        }
        return num;
    }
}
