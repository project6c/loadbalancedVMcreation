#include <stdio.h>
#include <stdlib.h>

int main(int argc,char *argv)
{
    long double a[4],b[4],loadavg,freemem,totalmem,memusage;
    FILE *fp,*frp;
	 
    int i;
    int status;
    char command[] = " df -H | awk '{print $5}' | head -2 | tail -1 > hdusage.txt";
    status = system(command);
        
//    for(i=0;i<5;i++)
  //  {
    fp = fopen("/proc/stat","r");
    fscanf(fp,"%*s %Lf %Lf %Lf %Lf",&a[0],&a[1],&a[2],&a[3]);
    fclose(fp);
    sleep(1);
    fp = fopen("/proc/stat","r");
    fscanf(fp,"%*s %Lf %Lf %Lf %Lf",&b[0],&b[1],&b[2],&b[3]);
    fclose(fp);
    frp=fopen("cpuvalues.txt","w");
    loadavg = ((b[0]+b[1]+b[2]) - (a[0]+a[1]+a[2])) / ((b[0]+b[1]+b[2]+b[3]) - (a[0]+a[1]+a[2]+a[3]));
    fprintf(frp,"%Lf\n",loadavg);

   // }

    fp = fopen("hdusage.txt", "r");
   /* int num;
    char* ch;
    while((*ch=getc(fp)) != '%')
     num = atoi(ch);
    printf("num = %d\n", num);
   */
    char *temp;
    char *p;
    int choice;
    fscanf(fp, "%d", &choice);
    fprintf(frp,"%d\n", 100-choice);
    //p = strtok(temp, "%");
    //printf("p = %s\n", p);
    //int num = atoi(p);
    //printf("num = %d\n", num);

    fclose(fp);

    fp=fopen("/proc/meminfo","r");
    fscanf(fp,"%*s %Lf %*s %*s %Lf",&totalmem,&freemem);
        
    memusage=freemem/totalmem;
    //printf("totalmem = %Lf\n", totalmem);
    //printf("freemem = %Lf\n", freemem);
    fprintf(frp,"%Lf\n",1-memusage);
    fclose(fp);
   
    

    return(0);
}
