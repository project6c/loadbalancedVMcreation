/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RequestReceiver_FCFS {
    
    ArrayList<VMRequest> requestQueue1;
  //  BufferedReader input;
    double hddreq;
    double ramreq;
    double cpureq;
    static int vm_no=0;
    int chosen_pm=-1;
    VMCreator vmc;
    //constraints
    public RequestReceiver_FCFS()
    {
        requestQueue1=new ArrayList<VMRequest>();
        vmc=new VMCreator();
    }
    
    public int receiveRequest(BufferedReader input,String ip) throws IOException
    {
        
			
		//	 inFromClient = new BufferedReader(new InputStreamReader(port.getInputStream()));
			//DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
        try{		
                        String xyz = input.readLine();
                       // System.out.print(xyz);
			hddreq=Double.parseDouble(xyz);
                        cpureq =Double.parseDouble(input.readLine());
                       // System.out.print(hddreq);
                       // String test=input.readLine();
                       // System.out.print(test);
			ramreq =Double.parseDouble(input.readLine());
              
               // System.out.println("ip="+ip.substring(2));
                        VMRequest vmreq=new VMRequest(vm_no,ip,hddreq,cpureq,ramreq);
			requestQueue1.add(vmreq);
                        System.out.println("Request Added to queue");
                        VMAlgorithm vma=new VMAlgorithm(vmreq);
                        int chosen_new=vma.compute();
                        
                        if(chosen_new==-1)
                               System.out.println("Sorry, cannot allocate this virtual machine");
                       // VMFCFS vmfcfs=new VMFCFS();
                        //chosen_pm=  vmfcfs.compute();
                        if(chosen_pm==-1)
                               System.out.println("Sorry, cannot allocate this virtual machine");
                        
                       System.out.println("This is the optimum PM by VMA: "+chosen_new);
                       //System.out.println("This is the optimum PM by FCFS: "+chosen_pm);
                       
                       String ip_by_FCFS=OperatingSystem.pm[chosen_pm].ip+"";
                       //String ip_by_VMOP=OperatingSystem.pm[chosen_new].ip+"";
                        double cpu_total=OperatingSystem.pm[chosen_new].totalCpu;
                     
                       vmc.createVM(ip_by_FCFS, hddreq, cpureq,cpu_total);
                       //vmc.createVM(ip_by_VMOP, hddreq, cpureq);
        }
        
         
	catch (Exception e) {
            e.printStackTrace();
        }  
    
    return chosen_pm;
    }


    
}
