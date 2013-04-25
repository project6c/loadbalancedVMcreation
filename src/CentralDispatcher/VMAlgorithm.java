package CentralDispatcher;

import java.io.*;
// every PM values(without any VM allocation) must be initialized only once

// This should be done long way before :-( ...i.e in PhysicalMachine.java

public class VMAlgorithm
{
	double cpu_remaining[]=new double[OperatingSystem.pm.length];
	double ram_remaining[]=new double[OperatingSystem.pm.length];
	double cpu_util[]=new double[OperatingSystem.pm.length];
	double ram_util[]=new double[OperatingSystem.pm.length];
	double totalCpu[]=new double[OperatingSystem.pm.length];
	double totalRam[]=new double[OperatingSystem.pm.length];
	double Old_Node_Computing_Area[]=new double[OperatingSystem.pm.length];
	double New_Node_Computing_Area[]=new double[OperatingSystem.pm.length];		
	double cpu_remaining_if_VMAssigned[]=new double[OperatingSystem.pm.length];
	double ram_remaining_if_VMAssigned[]=new double[OperatingSystem.pm.length];
	double Area1[]=new double[OperatingSystem.pm.length];
	double Area2[]=new double[OperatingSystem.pm.length];
	double new_cpu_util[]=new double[OperatingSystem.pm.length];
	double new_ram_util[]=new double[OperatingSystem.pm.length];
	double Min_Change;
	int Desired_Node;
	double Change_in_NCArea;
        double cpu_compute,ram_compute;
	//PhysicalMachine pm=new PhysicalMachine();
	VMRequest vm;
	int VM_Allocated_status[]=new int[OperatingSystem.pm.length];
	int len;
        double old_avg_computing_area=0;
	double new_avg_computing_area=0;
	String data="data.txt";
	
    public VMAlgorithm(VMRequest request) {
        vm=request;
    	}
	
        
	int compute()
	{
		int i;
		
        	System.out.println("IN compute");
                System.out.println("Requested HDD: " + vm.requestedHdd);
                System.out.println("Requested RAM: " + vm.requestedRam);
                System.out.println("Requested CPU: " + vm.requestedCpu);

		for(i=0;i<OperatingSystem.pm.length; i++)
		{
		
		
		cpu_util[i]=OperatingSystem.pm[i].cpuQueue.getValue();
		ram_util[i]=OperatingSystem.pm[i].ramQueue.getValue();
		totalCpu[i]=OperatingSystem.pm[i].totalCpu;
		totalRam[i]=OperatingSystem.pm[i].totalRam;
		cpu_remaining[i]=totalCpu[i]*(1-cpu_util[i]);
		ram_remaining[i]=totalRam[i]*(1-ram_util[i]);
		Old_Node_Computing_Area[i]=cpu_util[i]*ram_util[i];
		Area1[i]=Old_Node_Computing_Area[i];
		old_avg_computing_area+=Area1[i]/OperatingSystem.pm.length;
                
		}

      
		Min_Change=100;
		Desired_Node=0;
	
		for(i=0;i<OperatingSystem.pm.length; i++){

		cpu_remaining_if_VMAssigned[i]=cpu_remaining[i]-(vm.requestedCpu);
		ram_remaining_if_VMAssigned[i]=ram_remaining[i]-(vm.requestedRam);
		cpu_compute=totalCpu[i]*cpu_util[i]+vm.requestedCpu;
		ram_compute=totalRam[i]*ram_util[i]+vm.requestedRam;
                if(cpu_compute<totalCpu[i] && ram_compute<totalRam[i])
                {
		new_cpu_util[i]=cpu_compute/totalCpu[i];
		new_ram_util[i]=ram_compute/totalRam[i];
                }
                else
                    continue;
		
		if(cpu_remaining_if_VMAssigned[i]>0 && ram_remaining_if_VMAssigned[i]>0){

			Area2[i]=new_cpu_util[i]*new_ram_util[i];
			Change_in_NCArea=Math.abs(Area2[i]-Area1[i]);
			if(Change_in_NCArea<Min_Change){
				Desired_Node=i;
				Min_Change=Change_in_NCArea;
				//VM_Allocated_status[i]++;
                                OperatingSystem.pm[i].noofVMs++;
			}
		}
			System.out.println("PM["+i+"]Jump: "+i+" "+Change_in_NCArea);		 		
	}

		
  		
		new_avg_computing_area=old_avg_computing_area+Min_Change/OperatingSystem.pm.length;
		old_avg_computing_area=new_avg_computing_area;
		System.out.println("Average computing area: "+new_avg_computing_area);
//****************************************************************************************************************//


        try {
             File file = new File(data);
  	     boolean exist = file.createNewFile();
             BufferedWriter writer;

             System.out.println("exist = " + exist);
            if(exist){
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(new_avg_computing_area+"\n");
            writer.write(" ");
	    writer.write(vm.requestedCpu+"\n");
            writer.write(" ");
	    writer.write(vm.requestedRam+"\n");
	    writer.write("\n");
        }
	else{
	FileOutputStream fos = new FileOutputStream(data, true);
      //String strContent = "Append output to a file example";
     	String newline="\n";
	//fos.write(newline.getBytes());
	//fos.write(newline.getBytes());
       String newAvgComputingArea = new_avg_computing_area+"";
       fos.write(newAvgComputingArea.getBytes());
       String space = " ";
       fos.write(space.getBytes());
       
       String vmRequestedCpu = vm.requestedCpu + "";
	fos.write(vmRequestedCpu.getBytes());
        fos.write(space.getBytes());
	
       String vmRequestedRam = vm.requestedRam + "";
       fos.write(vmRequestedRam.getBytes());
       fos.write(space.getBytes());
       
	fos.write(newline.getBytes());
       
       }
        }
        catch(Exception ex){
            //ex.printStackTrace();
            System.out.println("Exception in VMAlgorithm.java while writing into file.");
        }
       
//****************************************************************************************************************//

		
		
	return Desired_Node;
	}
}



