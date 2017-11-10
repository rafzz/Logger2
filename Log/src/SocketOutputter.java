import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketOutputter implements Outputter{

	private String logContent;
	private String fileName;
	
	public SocketOutputter() {
		this.logContent = "";
	}

	@Override
	public void addLog(String s) {
		logContent+=s;
		
	}

	@Override
	public void writeLogs() throws IOException {
		
		ServerSocket ss = new ServerSocket(4444);
	    Socket socket = ss.accept();
	    OutputStream out = socket.getOutputStream();
	    ObjectOutputStream oout = new ObjectOutputStream(out);
	    oout.writeObject(logContent);
	    oout.close();
		
	}

}
