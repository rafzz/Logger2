
public enum LoggerLevel {
	INFO, DEBUG, WARNING, ALERT;
	
	public String toString(){
		switch(this){
		case INFO:
			return "INFO";

			
		case DEBUG:
			return "DEBUG";

			
		case WARNING:
			return "WARNING";

			
		case ALERT:
			return "ALERT";

			
		default:
			return "";

		}
	}
}
