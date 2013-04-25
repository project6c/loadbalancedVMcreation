/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class VMCreator  {
    
  /*  public static void main(String args[])
    {
        VMCreator vmc=new VMCreator();
        vmc.createVM("sruthi@192.168.12.35",2.4,1);
    
    }*/
    public VMCreator()
    {
    
    }
    public void createVM(String chosen_ip,double memReq,double cpu,double cpu_total){
        
             
        
        try{
            double cpu_limit=(cpu/cpu_total)*100;
            String command="/home/sruti/NetBeansProjects/OperatingSystem/src/CentralDispatcher/creator.sh";             
            ProcessBuilder probuild=new ProcessBuilder(command,chosen_ip, memReq+"",cpu_limit+"");
          
                                    
            
            Process start=probuild.start();
              InputStream is = start.getInputStream();
            InputStream isErr = start.getErrorStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        InputStreamReader isrErr = new InputStreamReader(isErr);
                        BufferedReader br = new BufferedReader(isr);
                        BufferedReader brErr = new BufferedReader(isrErr);
                        String line;
                        String lineErr;

                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
            System.out.println("Hello");
        }
        }
        catch(Exception ex){
            System.out.println("Exception in VMCreator.java");
            //ex.printStackTrace();
        }
    }
            
    
}
