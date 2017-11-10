import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class FileOutputter implements Outputter {

	private String logContent;
	private String fileName;
	
	public FileOutputter(String fileName) {
		this.logContent = "";
		this.fileName = fileName;
	}

	@Override
	public void addLog(String s) {
		logContent+=s;
		
	}

	@Override
	public void writeLogs() {
		
		try {
				File f1 = new File(fileName+".txt");
				if(!f1.exists()) {
					f1.createNewFile();
				} 
				FileWriter fw = new FileWriter(fileName+".txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw);
			    
			    out.println(logContent);
			    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
