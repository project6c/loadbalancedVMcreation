package vmRequest;
import java.net.*;
import java.io.*;
import java.lang.*;

import com.opensymphony.xwork2.ActionSupport;

public class VMModuleAction extends ActionSupport {

	public String ramreq;
	public String cpureq;
	public String hddreq;
	public String check=null;
	public String getHddreq() {
		return hddreq;
	}

	public void setHddreq(String hddreq) {
		this.hddreq = hddreq;
	}

	public int status=0;
	public String receivedPM;
	public String getReceiveMessage() {
		return receivedPM;
	}

	public void setReceiveMessage(String receivedPM) {
		this.receivedPM = receivedPM;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRamreq() {
		return ramreq;
	}

	public void setRamreq(String ramreq) {
		this.ramreq = ramreq;
	}

	public String getCpureq() {
		return cpureq;
	}

	public void setCpureq(String cpureq) {
		this.cpureq = cpureq;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public String execute(){
			
				try{

					
					//InetAddress ip1=InetAddress.getByName(userip1);
					
					System.out.println("HDD Required:"+hddreq);
					System.out.println("RAM Required:"+ramreq);
					System.out.println("CPU Required:"+cpureq);
					
					


					//System.out.println("Enter physical machine preferences\n 1. Any machine satisfying the conditions\n2.");
					//String subnet=s.next();
					//InetAddress sub=InetAddress.getByName(subnet);


					//port = 2897;
					//System.out.println("Connecting to"+serverName+"on port"+port);
					Socket client=new Socket("192.168.12.140",7821);//server ip and port
					//System.out.println("Just connected to"+client.getRemoteSocketAddress());
					OutputStream outToServer=client.getOutputStream();
					DataOutputStream os=new DataOutputStream(outToServer);
					if(!hddreq.equalsIgnoreCase(check) & !cpureq.equalsIgnoreCase(check) & !ramreq.equalsIgnoreCase(check)){
					os.writeBytes(hddreq+"\n");
					os.writeBytes(cpureq+"\n");
					os.writeBytes(ramreq+"\n");
					}
					
					
					
					
				 
					 InputStream istream = client.getInputStream();
				     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
				 
					if((receivedPM = receiveRead.readLine()) != null) 
			        {
			            System.out.println(receivedPM); 
			         }              
					
					status=1;
					
					Thread.currentThread();
					Thread.sleep(4000);
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
			
		if(status==1)
		return "success";
		
		else 
			return "failure";
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}
