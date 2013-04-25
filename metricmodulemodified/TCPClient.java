import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;


public class TCPClient {

		public static void main(String[] args) throws Exception {
			String[] str = new String[3];
			String hostIP="hai";
			int count=0;
			//int[] str=new int[3];
			//String hndshk;
			try{
				Enumeration e=NetworkInterface.getNetworkInterfaces();
            			while(e.hasMoreElements())
            				{
               				 NetworkInterface n=(NetworkInterface) e.nextElement();
                			Enumeration ee = n.getInetAddresses();
                			while(ee.hasMoreElements())
               					 {
							count++;
                   					 InetAddress ipadd= (InetAddress) ee.nextElement();
		    					if(count==2)
                    						hostIP=ipadd.getHostAddress();
               					 }
           				 }
				
			}
   				catch (Exception e){
				 			System.out.println("Exception caught ="+e.getMessage());
  					}
			
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			/*BufferedReader br;
			br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the IP Address of Server");
			String IP  =  br.readLine();*/
			Socket clientSocket = new Socket("192.168.12.102", 6885);//INCLUDE THE SERVER IP ADDRESS
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			/*System.out.println("Enter the IP Address 1 : ");
			ip1 = inFromUser.readLine();
			
			
			System.out.println("Enter the IP Address 2 : ");
			ip2 = inFromUser.readLine();
			
			
			System.out.println("Enter the SubNet Mask : ");
			subnet = inFromUser.readLine();*/
			BufferedReader br1 = new BufferedReader(new FileReader("/home/desai/Desktop/metricmodulemodified/cpuvalues.txt"));
 			//String line;
			String line;			
			int i=0;
			while ((line = br1.readLine()) != null) {
   // process the line.   
				str[i]=line;
				i++;
			}
			//try{
 				 
				  //System.out.println("IP of my system is := "+ownIP.getHostAddress());

			outToServer.writeBytes(hostIP+'\n');
			outToServer.flush();
			outToServer.writeBytes(str[0] + '\n');
			outToServer.flush();  // writing Cpu-utilization
			outToServer.writeBytes(str[1] + '\n');
			outToServer.flush(); // writing Harddisk free 
			outToServer.writeBytes(str[2] + '\n');
			outToServer.flush(); // writing Ram Free
			
			//response_server = inFromServer.readLine();
			//System.out.println("FROM SERVER: " + response_server);
			
			clientSocket.close();
			
	}

}
