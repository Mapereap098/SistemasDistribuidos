package Prueba;


//Mateo Perea
//1520010091

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
 
public class server
{
    public static void main(String[] args)
    {
        int port=2050;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
 
            Socket clientSocket = serverSocket.accept();
 
            InputStream inputStream = clientSocket.getInputStream();
 
            System.out.println(inputStream);
 
            byte[] imageAr = new byte[62100];
            inputStream.read(imageAr);
 
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
 
            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "jpg", new File("C:\\Users\\Hp\\Pictures\\descarga.jfif"));
 
            inputStream.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}