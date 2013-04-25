import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		
		String cpu_util;
		String HD_Free;
		String RAM_Free;
		String clientIP; 
		//int[] calcip1,calcip2;
		int count = 0;

		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true) {

			Socket connSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
			
			clientIP=inFromClient.readLine();
			cpu_util = inFromClient.readLine();
			HD_Free = inFromClient.readLine();
			RAM_Free = inFromClient.readLine();
			Writer writer = null;

// below code deals with writing data into the file......make changes here 

        try {
             File file = new File(clientIP);
  	     boolean exist = file.createNewFile();
 
            if(exist){
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(cpu_util+"\n");
	    writer.write(HD_Free+"\n");
	    writer.write(RAM_Free+"\n");
	    writer.write("\n");
        } 
	else{
	FileOutputStream fos = new FileOutputStream(clientIP, true);
      //String strContent = "Append output to a file example";
     	String newline="\n";
	fos.write(newline.getBytes());
	fos.write(newline.getBytes());
       fos.write(clientIP.getBytes());
	fos.write(newline.getBytes());
	       fos.write(cpu_util.getBytes());
		fos.write(newline.getBytes());
       fos.write(HD_Free.getBytes());
	fos.write(newline.getBytes());
       fos.write(RAM_Free.getBytes());
	
     
}
}	
	catch (Exception e) {
            e.printStackTrace();
        }  
			System.out.println(clientIP);
			System.out.println(cpu_util);
			System.out.println(HD_Free);
			System.out.println(RAM_Free);
		}
	}

}
