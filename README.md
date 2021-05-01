# Trie
This repository shares the code to create a Java Trie data structure and host it online where multiple global users can access it through a server. This was the final take-home interview for the Slingshot CS Fellowship.

# Instructions
1) GreetServer.java is the code for the server. It contains the functions to add, search, delete, autocomplete, and print words in the trie. It is hosted on a Microsoft Azure Virtual Machine, which can be accessed through a Secure Shell Protocol (ssh) with the public key. If you have MacOS / Linux, simply ssh to the public key through terminal. If you are on Windows, do this through a terminal emulator (I suggest PuTTy: wwww.putty.org). 
current Public Key: 40.78.97.221

2) Now that you have reached a linux terminal (hit yes to the pop ups about ssh fingerprints), you should be prompted for a username and password. You can sign into it with username: anaiy, password: $Bombay25$Bombay25. The reason why there is no private key is that the code for the server may not be running, so the user should be able to start it themselves. Also, I have allowed for changes in the code to be made for testing purposes.

3) To access the Trie directory, simply use the command "cd.." until you are at the root directory of the VM, which should look like anaiy@Trie3:/. Then, use the command "cd anaiy" and next, the command "cd slingshotfinalproject". Now, use the command ls to print all files in that directory, in which case you should see 5 files with the .java extension. If there are not the same number of files with the same file names buth extension .class (for example, if there is Add.java but not Add.class), use the command "javac filename.java" to compile the file. Now, if you use the ls command, you should see a .class file.

4) Now, you can use the 5 functions of the directory to access the trie: you can add words using the "java Add" command, delete words using the "java Delete" command, search for words usng the "java Search" command, find autocompleted words given a prefix using the "java Autocomplete" command, and print all words in the Trie using the "java Printall" command. 
# Note
1) Every time the Azure VM is shut down and restarted, it is given a different public key. Since I will not be hosting this permenantly, please email me @anaiysomalwar@gmail.com or on discord @Anaiy#3006 to update you and start the server.

2) If you get an error message using the program functions, that means that the server code is not running. Ideally, this would not happen if it was hosted on an AWS EC2 instance; however, that does cost more money to host. To test the functionality of the code w/o the server already running, you can run the server yourself by using the command "java GreetServer", and run tests using another ssh window.

3) Unless the server code was not running, there will be no errors from any of the Trie functions. However, it is implied that the user uses no upperspace characters as is common in the applications of the Trie data structure. Using uppercase characters WILL change the outputs of the Trie functions if used accidently. Although this problem could be "fixed" using the toLowerCase() method in the program, I left it in in case it is used for testing.
