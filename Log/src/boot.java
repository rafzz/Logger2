
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.io.ObjectInput;
import java.io.ObjectInputStream;

import java.net.Socket;


public class boot {

	public static void main(String[] args) throws IOException, ClassNotFoundException,Exception {
		
		
		
		
		Logger l = new Logger(LoggerLevel.DEBUG, 
				LoggerType.CONSOLE, 
				new LoggerFormat[]{LoggerFormat.DATE, LoggerFormat.LEVEL} ) ;
		
		l.printLog("jakis log");
		l.printLog("jakis inny log !");
		
		l = new Logger(LoggerLevel.INFO, 
				LoggerType.CONSOLE, 
				new LoggerFormat[]{LoggerFormat.LEVEL} ) ;
		
		l.printLog("jakis jeszcze inny log !");
		
		l = new Logger(LoggerLevel.ALERT, 
				LoggerType.FILE, 
				new LoggerFormat[]{LoggerFormat.DATE} ) ;
		
		l.printLog("jakis log w pliku!");
		l.printLog("jakis inny log w pliku!");
		
		l = new Logger(LoggerLevel.ALERT, 
				LoggerType.SOCKET, 
				new LoggerFormat[]{LoggerFormat.DATE} ) ;
		
		l.printLog("socket log!");
		

		client();

		

	}
	
	
	
	static void client() throws IOException, ClassNotFoundException {
	    Socket socket = new Socket("localhost", 4444);
	    InputStream in = socket.getInputStream();
	    ObjectInput oin = new ObjectInputStream(in);
	    String stringFromServer = (String) oin.readObject();
	    FileWriter writer = new FileWriter("received.txt",true);
	    writer.write(stringFromServer);
	    //System.out.println(stringFromServer);
	    in.close();
	    writer.close();
	}

}
