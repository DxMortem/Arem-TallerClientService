package co.edu.escuelaing.arem.Url;

import java.io.*;
import java.net.URL;

public class UrlReader {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("A continuación ingrese la dirección URL por ejemplo \"www.google.com\":");
        String direccion = br.readLine();
        URL url = new URL("http://"+direccion);
        try (BufferedReader reader= new BufferedReader(new InputStreamReader(url.openStream()))) {
            File archivo = new File("resultado.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                bw.write(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
