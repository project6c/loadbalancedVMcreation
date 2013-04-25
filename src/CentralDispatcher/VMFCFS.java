/*
 * and open the template in the editor.
 */
package CentralDispatcher;

/**
 *
 * @author user
 */

// every PM values(without any VM allocation) must be initialized only once

// This should be done long way before :-( ...i.e in PhysicalMachine.java

public class VMFCFS
{
	double cpu_remaining[]=new double[OperatingSystem.pm.length];
	double ram_remaining[]=new double[OperatingSystem.pm.length];
	double cpu_util[]=new double[OperatingSystem.pm.length];;
	double ram_util[]=new double[OperatingSystem.pm.length];
	double totalCpu[]=new double[OperatingSystem.pm.length];
	double totalRam[]=new double[OperatingSystem.pm.length];
	double Old_Node_Computing_Area[]=new double[OperatingSystem.pm.length];
	double New_Node_Computing_Area[]=new double[OperatingSystem.pm.length];		
	double cpu_remaining_if_VMAssigned[]=new double[OperatingSystem.pm.length];
	double ram_remaining_if_VMAssigned[]=new double[OperatingSystem.pm.length];
	double Area1[]=new double[OperatingSystem.pm.length];
	double Area2[]=new double[OperatingSystem.pm.length];
	double Min_Change;
	int Desired_Node,count;
	double Change_in_NCArea;
        double cpu_compute,ram_compute,new_cpu_util,new_ram_util;
	//PhysicalMachine pm=new 	PhysicalMachine();
	//VMRequest vm;
	//PhysicalMachine pm=new 	PhysicalMachine();
	VMRequest vm=new VMRequest();
	
        public	int compute()
	{
	int i,count=0;
	for(i=0;i<OperatingSystem.pm.length/*pm array*/; i++){
		if(count==1)
			break;
		cpu_util[i]=OperatingSystem.pm[i].cpuQueue.getValue();;
		ram_util[i]=OperatingSystem.pm[i].ramQueue.getValue();;
		if(vm.requestedCpu < cpu_util[i] && vm.requestedRam < ram_util[i]){
			Desired_Node=i;
			count++;
		}
	}
	
	return Desired_Node;	
	}
}

