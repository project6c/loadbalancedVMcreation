package CentralDispatcher;
//import PhysicalMachine;

import CentralDispatcher.OperatingSystem;
import java.io.*;
import java.net.*;

public class TCPServer {
    //OperatingSystem os=new OperatingSystem();

	//public static void main() throws Exception {
	public void statisticsReceiver(BufferedReader inFromClient){
		String cpu = "";
		String hdd = "";
		String ram = "";
		String clientIP = ""; 
                int i;
		//int count = 0;

		//ServerSocket welcomeSocket = new ServerSocket(6789);
//		while(true) {
//
//			Socket connSocket = welcomeSocket.accept();
//			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
//			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
		try{
		 clientIP=inFromClient.readLine();
                 clientIP=clientIP.substring(0);//To remove the preceding slash
                 
		 cpu = inFromClient.readLine();
		 hdd = inFromClient.readLine();
		 ram = inFromClient.readLine();
                 System.out.println("Stats from "+clientIP+"\n CPU-"+cpu+"\n HDD- "+hdd+"\n RAM-"+ram);
                   }
			//Writer writer = null;
                catch (Exception e) {
                // e.printStackTrace();
                    System.out.println("Exception in TCPServer.java while receiving statistics.");
                   }
                System.out.println("OperatingSystem.pm.length = " + OperatingSystem.pm.length);
                System.out.println("clientIP = " + clientIP);
                for(i=0; i<OperatingSystem.pm.length; i++){
                
                    String temp[] = OperatingSystem.pm[i].getIp().split("@");
                    
                if(clientIP.equalsIgnoreCase(temp[1])){
                    System.out.println("Stat values from "+clientIP+ "added to queues");
                  OperatingSystem.pm[i].cpuQueue.insert(Double.parseDouble(cpu));
                  OperatingSystem.pm[i].hddQueue.insert(Double.parseDouble(hdd));
                  OperatingSystem.pm[i].ramQueue.insert(Double.parseDouble(ram));
                  }
                
                }


        try {
             File file = new File(clientIP);
  	     boolean exist = file.createNewFile();
             BufferedWriter writer;

            if(exist){
            writer = new BufferedWriter(new FileWriter(file));
            //writer.write(cpu+"\n");
	    //writer.write(hdd+"\n");
	    //writer.write(ram+"\n");
            writer.write("cpu: " + cpu + " hdd: " + hdd + " ram: " + ram);
	    writer.write("\n");
            }
	else{
	FileOutputStream fos = new FileOutputStream(clientIP, true);
        //String strContent = "Append output to a file example";
     	String newline="\n";
        String CPU = "cpu: ";
        String HDD = " hdd: ";
        String RAM = " ram: ";
	fos.write(newline.getBytes());
	//fos.write(newline.getBytes());
        //fos.write(clientIP.getBytes());
	//fos.write(newline.getBytes());
        fos.write(CPU.getBytes());
	fos.write(cpu.getBytes());
	//fos.write(newline.getBytes());
        fos.write(HDD.getBytes());
       fos.write(hdd.getBytes());
	//fos.write(newline.getBytes());
       fos.write(RAM.getBytes());
       fos.write(ram.getBytes());
       fos.write(newline.getBytes());

         }
        }
            catch(Exception ex){
                //ex.printStackTrace();
                System.out.println("Exception in TCPServer.java while writing statistics.");
            }
       
           
       
	}

    }