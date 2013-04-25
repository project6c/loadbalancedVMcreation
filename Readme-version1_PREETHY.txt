Classes & 	Packages in the pjt OperatingSystem
Pkg 1:ClientRequest

Classes:RequestGenerator.java
Methods:requestSender
Description:Gets the hdd & ram needs from a user through console and sends it to the Central Dispatcher

Pkg 2: CentralDispatcher

Classes:
	1.Listener.java

	Methods&Description:
			1. Constructor-where initialisation of ports&sockets are done
		
			2.  listenToPorts()-where the C.D should continuosly listen to both ports.
				we have to implement threading here.
				Currently, the server is listening to the VM requests from the user.
				Sruti has the code for Statistics Reporting & Listening.
				we have to integrate it here.

	2.Main.java
	Methods&Description
			1.main()-Execution starts here.Objects for OperatingSystem class and Listener class are instantiated

	3.OperatingSystem.java-has the physicalmachine details
	4.PhysicalMachine.java-structure for a PM
	5.Queue.java-Structure for Queue
	6.VMRequest.java-Structure for a VMRequest
	7.RequestReceiver.java-Receives the parameters for a VM Request from a user and bundles it into an object of VMRequest class and puts it into an arraylist. From this arraylist, the  VM Placement Algorithm should take each request and process.
Also, I have tried to write the request parameters into a file, using Surya's code.but it doesnt seem to work properly.
			
