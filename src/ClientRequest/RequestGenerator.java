/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientRequest;
    import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author user
 */
public class RequestGenerator {

 //   static String serverName;
   // static int port;

	public RequestGenerator() {


	}

	public void requestSender(){

		try{

			System.out.println("Enter the required hard disk capacity");
			Scanner s=new Scanner(System.in);
			double hdd=Double.parseDouble(s.next());
			//InetAddress ip1=InetAddress.getByName(userip1);
			System.out.println("hdd req: "+hdd);

			System.out.println("Enter the required RAM amount");
			double ram=Double.parseDouble(s.next());


			//System.out.println("Enter physical machine preferences\n 1. Any machine satisying the conditions\n2.");
			//String subnet=s.next();
			//InetAddress sub=InetAddress.getByName(subnet);


			//port = 2897;
			//System.out.println("Connecting to"+serverName+"on port"+port);
			Socket client=new Socket("127.0.0.1",7821);//server ip and port
			//System.out.println("Just connected to"+client.getRemoteSocketAddress());
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream os=new DataOutputStream(outToServer);
			os.writeBytes(hdd+"\n");
			os.writeBytes(ram+"\n");

			//InputStream inFromServer=client.getInputStream();
			//DataInputStream in=new DataInputStream(inFromServer);
			//System.out.println("Server says"+in.readUTF());
			os.close();
			outToServer.close();
			//client.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
        public static void main(String[] args){
            RequestGenerator reqgen=new RequestGenerator();
            reqgen.requestSender();


        }

}



