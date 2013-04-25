package CentralDispatcher;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author use
 */
public class PhysicalMachine //implements Queue{
{
   int pmId;
   String ip;
   double totalCpu;
   double totalHdd;
   double totalRam;
   
   public  Queue ramQueue;
   public Queue hddQueue;
   public Queue cpuQueue;
   double nodeComputingArea;
   int noofVMs;//How will the PM indicate that a VM is actually runng on it.Will it actually run them?
   
   

PhysicalMachine(int pmId,String ip,double totalCpu,double totalHdd,double totalRam)
{
    this.pmId = pmId;
    this.ip = ip;
    this.totalCpu = totalCpu;
    this.totalHdd = totalHdd;
    this.totalRam = totalRam;

    ramQueue=new Queue(10);
    hddQueue=new Queue(10);
    cpuQueue=new Queue(10);
    nodeComputingArea=0;
    noofVMs=0;
}
  public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getNodeComputingArea() {
        return nodeComputingArea;
    }

    public void setNodeComputingArea(double nodeComputingArea) {
        this.nodeComputingArea = nodeComputingArea;
    }

    public int getNoofVMs() {
        return noofVMs;
    }

    public void setNoofVMs(int noofVMs) {
        this.noofVMs = noofVMs;
    }

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public double getTotalCpu() {
        return totalCpu;
    }

    public void setTotalCpu(double totalCpu) {
        this.totalCpu = totalCpu;
    }

    public double getTotalHdd() {
        return totalHdd;
    }

    public void setTotalHdd(double totalHdd) {
        this.totalHdd = totalHdd;
    }

    public double getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(double totalRam) {
        this.totalRam = totalRam;
    }


}