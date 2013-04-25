/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author user
 */
public class OperatingSystem {

    /**
     * @param args the command line arguments
     */
    //  have to modify such that these values are read from a static file
   public static PhysicalMachine pm[];
   int size;

   /*= new PhysicalMachine(1, "192.16.12.35", 2, 500, 4);
    public static PhysicalMachine pm2 = new PhysicalMachine(2, "192.16.12.140", 2.5, 450, 3);
    public static PhysicalMachine pm3 = new PhysicalMachine(3, "192.16.12.102", 2, 500, 4);
*/
    // PhysicalMachine pm[];
    OperatingSystem()
    {
  //   PhysicalMachine p=new PhysicalMachine(size, null, size, size, size)
//    pm=new PhysicalMachine[size];
//    for(int i=0;i<size;i++)
//    {
//
//    pm[i] = new PhysicalMachine(j, "192.16.12.35", 2, 500, 4);
//    PhysicalMachine pm2 = new PhysicalMachine(2, "192.16.12.140", 2.5, 450, 3);
//    PhysicalMachine pm3 = new PhysicalMachine(3, "192.16.12.102", 2, 500, 4);
//
//    }
        System.out.println("We are inside OperatingSystem constructor\n");
        
        BufferedReader br=null;
        int i, count=0;
        int num;
        String line;

        try{
        
        br=new BufferedReader(new FileReader("/home/sruti/NetBeansProjects/OperatingSystem/src/CentralDispatcher/PhysicalMachines.txt"));
        
        
        line = br.readLine();
        size = Integer.parseInt(line);

        pm = new PhysicalMachine[size];

        String token[] = new String[5];
        
        for(i=0; i<size; i++){

            if((line=br.readLine())!=null){

                token = line.split(" ");
                int pmId = Integer.parseInt(token[0]);
                String ip = token[1];
                double totalCpu = Double.parseDouble(token[2]);
                double totalHdd = Double.parseDouble(token[3]);
                double totalRam = Double.parseDouble(token[4]);

                pm[i] = new PhysicalMachine(pmId, ip, totalCpu, totalHdd, totalRam);                       
                            
            }

        }

       }
         
        catch(Exception ex){
            //ex.printStackTrace();
            System.out.println("Exception in OperatingSystem.java");
        }

        for(i=0; i<size; i++){
            System.out.print(pm[i].getPmId() + " ");
            System.out.print(pm[i].getIp() + " ");
            System.out.print(pm[i].getTotalCpu() + " ");
            System.out.print(pm[i].getTotalHdd() + " ");
            System.out.println(pm[i].getTotalRam());
        }

    }
 
}
