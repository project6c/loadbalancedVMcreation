/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Listener extends Thread{

    ServerSocket reqSocket;
    int reqport;

    ServerSocket statSocket;
    int statport;

    Socket connSocket=null;
    Socket connSocket1=null;

    RequestReceiver reqRec;
    BufferedReader inFromPM,inFromClient;
    String clientip;
    TCPServer statRec;
    Thread thread1,thread2;
   // Socket connSocket;
    //StatReceiver obj also;
    

    public Listener() throws IOException  {

        reqport = 7821;
        statport = 6885;

        System.out.println("We are inside Listener constructor\n");
        reqSocket = new ServerSocket(reqport);
        statSocket = new ServerSocket(statport);
        System.out.println("In Listener ");
         reqRec = new RequestReceiver();
         statRec = new TCPServer();
        reqSocket.setSoTimeout(1000000000);
        statSocket.setSoTimeout(1000000000);
           thread1=new Thread() {

            @Override
            public void run() {
                                System.out.println("Listening for request");

                listenToRequest();
            }
        };
           thread2=  new Thread() {

            @Override
            public void run() {
                                System.out.println("Listening for stat");
                listenToStat();
                

            }
        };
         
    }
    public void listenToRequest()
    {
        
        try{
                connSocket     = reqSocket.accept();//Accepts VM requests
    
            //connSocket1     = reqSocket.accept();

                
            while (connSocket != null) {
                              clientip=connSocket.getInetAddress().toString();

                System.out.print("Got a req from"+clientip);
                inFromPM= new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
                int chosen_pm= reqRec.receiveRequest(inFromPM,clientip);
                  
                DataOutputStream outToClient=new DataOutputStream(connSocket.getOutputStream());
                OutputStream ostream=connSocket.getOutputStream();
                
                PrintWriter pwrite=new PrintWriter(ostream, true);
                pwrite.println(chosen_pm);
                System.out.flush();
                connSocket=null;
                connSocket     = reqSocket.accept();
              
            }
    }
        catch(Exception ex){
            
            System.out.println("Exception in Listener.java while listening to requests.");
        }
    }
    public void listenToStat(){
        
        try{
        connSocket1     = statSocket.accept();
      while(connSocket1!=null)
              {
                  
                inFromClient = new BufferedReader(new InputStreamReader(connSocket1.getInputStream()));
                statRec.statisticsReceiver(inFromClient);
                System.out.println("Got stats");
                connSocket1=null;
                connSocket1     = statSocket.accept();
              }
              }
        catch(Exception ex){
                  System.out.println("Exception in Listener.java while listening to statistics.");
              }
    
    }
    public void listenToPorts() throws IOException {
        //have to implement threading to listen to both ports
       // while (true) {
          //  try{
                // 
                     
             //   System.out.println("Listening at both ports:");
             
         thread1.start();
         thread2.start();
        }
        
        }
    

