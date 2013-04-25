/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentralDispatcher;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         //Assuming the no. of physical machines & parameters are known before head:



        System.out.println("We are inside main method\n");
        //Call metric reporting module of server here
        //Call VM request module here
        try{


        OperatingSystem os = new OperatingSystem();
         
        Listener listener = new Listener();
        
       //TCPServer metricReportingServer = new TCPServer();
        System.out.println("Listener obj created.\n");
       

            //while (true) {

                listener.listenToPorts();
                System.out.println("Listener obj listening.\n");
           // }
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Exception in Main.java");
        }
    }

}
