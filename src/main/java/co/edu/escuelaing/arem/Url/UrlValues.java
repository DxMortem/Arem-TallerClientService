package co.edu.escuelaing.arem.Url;

import java.net.URL;

public class UrlValues
{
    public static void main(String[] args) throws Exception {
        URL google = new URL("https://www.google.com.co:80/search?q=youtube&oq=youtube&aqs=chrome..69i57j69i60j69i65l3j69i60.1623j0j9&sourceid=chrome&ie=UTF-8#YouTube");
        try {
            System.out.println("Protocol "+google.getProtocol());
            System.out.println("Authority "+google.getAuthority());
            System.out.println("Host "+google.getHost());
            System.out.println("Port "+google.getPort());
            System.out.println("Path "+google.getPath());
            System.out.println("Query "+google.getQuery());
            System.out.println("File "+google.getFile());
            System.out.println("Ref "+google.getRef());
        } catch (Exception x) {
            System.err.println(x);
        }
    }
}
