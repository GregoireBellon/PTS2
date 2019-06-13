import javafx.scene.text.Text;

public class Chrono extends Thread {
	private long start;
	private Text textTemps;
	private long time;

	public Chrono(long start, Text textTemps) {
		this.start = start;
		this.textTemps = textTemps;
		start();
	}

	public long getStart() {
		return start;
	}

	public long getTime() {
		return time;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public void start() {
		while (true) {
			time = start - System.currentTimeMillis();
			textTemps.setText(time + "");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
