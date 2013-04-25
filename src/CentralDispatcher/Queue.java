/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralDispatcher;
/**
 *
 * @author user
 */
public class Queue {

    double[] queue;
    int size;
    int head;
    
    Queue()
    {
    
     head=0;
     this.size=10;
    }
    
    
    Queue(int size)
    {
        queue=new double[size];
        head=0;
        this.size=size;
        for(int i=0;i<size;i++)
        {
            queue[i]=-1;
        }
    }
    public int insert(double no)
    {
            int i=0;
            
            if(head==size)
            {
                //head=0;
                for(i=0; i<size-1; i++)
                    queue[i]=queue[i+1];
                queue[size-1]=no;
                
            }
            else{
                queue[head]=no;
                head++;
            }
            
            System.out.println("Head="+head+"  ");
            return 1;
    }
    
    public double getValue(){
        
        double value = -1;
        
        if(this.head!=0){
            value = this.queue[this.head-1];
        }        
        
        return value;
        
    }
    
    void printQueue()
    {
        for(int i=0;i<queue.length;i++)
        System.out.print(" "+queue[i]);
    
    }

    public int getHead() {
        return head;
    }
    
       
    
}
