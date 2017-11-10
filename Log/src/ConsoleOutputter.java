

public class ConsoleOutputter implements Outputter{
	
	private String logContent;
	//private String fileName;
	
	public ConsoleOutputter(/*String fileName*/) {
		this.logContent = "";
		//this.fileName = fileName;
	}

	@Override
	public void addLog(String s) {
		logContent+=s;
		
	}

	@Override
	public void writeLogs() {
		
		System.out.println(logContent);
		
	}

}
