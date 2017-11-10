import java.util.Date;

public class Logger {
	
	private LoggerLevel level;
	private LoggerType type;
	private LoggerFormat[] format;
	private Outputter logContent;
	
	
	public Logger(LoggerLevel level, LoggerType type, LoggerFormat[] format) {

		this.level = level;
		this.type = type;
		this.format = format;
		
	}
	
	public void printLog(String s) throws Exception{
		//pre 
		if(s == null) {throw new Exception("cannot be null!");}
		
		if(type==LoggerType.CONSOLE){
			logContent = new ConsoleOutputter();
		}
		else if(type==LoggerType.FILE){
			logContent = new FileOutputter("Log");
		}
		else if(type==LoggerType.SOCKET){
			logContent = new SocketOutputter();
		}
		
		if (format != null) {
			for (LoggerFormat l : format) {
				if (l == LoggerFormat.DATE) {
					// Date date = new Date();
					logContent.addLog(new Date() + ", ");
				}
				if (l == LoggerFormat.LEVEL) {
					addLevel();
				}
			}
		}
		
		logContent.addLog(":"+s);
		//post
		if(s == "") {throw new Exception("cannot be empty!");}
		logContent.writeLogs();
	}
	
	private void addLevel() {
		switch(level){
			case ALERT:
				logContent.addLog(level.ALERT.toString()+", ");
				break;
			case WARNING:
				logContent.addLog(level.WARNING.toString()+", ");
				break;
			case DEBUG:
				logContent.addLog(level.DEBUG.toString()+", ");
				break;
			case INFO:
				logContent.addLog(level.INFO.toString()+", ");
				break;
		}
	}
	

}
