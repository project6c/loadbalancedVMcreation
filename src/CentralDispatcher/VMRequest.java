
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;

/**
 *
 * @author Preethy
 * Date : 04/03/2013
 * This is the Server side module for handling VM Requests.
 */
public class VMRequest {
    
    public int vmId;
    public String clientIp;
    public double requestedHdd;
    public double requestedCpu;
    public double requestedRam;

    public VMRequest(int vmId, String clientIp, double requestedHdd, double requestedCpu, double requestedRam) {
        this.vmId = vmId;
        this.clientIp = clientIp;
        this.requestedHdd = requestedHdd;
      this.requestedCpu = requestedCpu;
        this.requestedRam = requestedRam;
    }
      
    public VMRequest(){}
}
