x=1
while [ $x -le 100 ]
do
cc cpu_check.c #produces a.out
./a.out #run your program
sleep 5
javac TCPClient.java
java TCPClient
sleep 5
x=$(( $x + 1 ))
done 
