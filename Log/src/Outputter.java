import java.io.IOException;

public interface Outputter {

	public void addLog(String s);
	public void writeLogs() throws IOException;
}
