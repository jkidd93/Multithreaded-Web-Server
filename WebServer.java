/*
    Created by Hardik Patel- 2/25/15
    
    I used http://swagdeek-pro.local:2934/index.html/ for my testing
 
    This class initiates the web server thread
 */


import java.io.*;
import java.net.*;
import java.util.*;

public final class WebServer
{
    public static void main(String argv[]) throws Exception
    {
        //Set port number
        int port = 2934;
        
        //Establish listen socket
        ServerSocket listenSocket = new ServerSocket(port);
        
        System.out.println("Starting server...\n");
        
        //Process HTTP service requests in an infinite loop
        while(true)
        {
            //Listen for a TCP connection request
            Socket TCPsocket = listenSocket.accept();
            
            //Construct an object to process the HTTP request message.
            HttpRequest request = new HttpRequest(TCPsocket);
            
            //Create a new thread to process the request.
            Thread thread = new Thread(request);
            
            System.out.println("Starting server...\n");
            
            //Start the thread.
            thread.start();
            
        }
    }
}
