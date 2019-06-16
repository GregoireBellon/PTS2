package visual;

public class Chrono extends Thread {

	private long tempsDepart = 0;
	private String dureeFinal = "";

	public void startChrono() {
		tempsDepart = System.currentTimeMillis();
	}
	public String stopChrono() {
		dureeFinal = getDureeTxt();
		return dureeFinal;
	}

	public long getDureeSec() {
		return (System.currentTimeMillis() - tempsDepart) / 1000;
	}

	public String getDureeTxt() {
		return timeToHMS(getDureeSec());
	}

	public static String timeToHMS(long tempsS) {

		int h = (int) (tempsS / 3600);
		int m = (int) ((tempsS % 3600) / 60);
		int s = (int) (tempsS % 60);

		String r = "";

		if (h > 0) {
			r += h + " h ";
		}
		if (m > 0) {
			r += m + " min ";
		}
		if (s > 0) {
			r += s + " s";
		}
		if (h <= 0 && m <= 0 && s <= 0) {
			r = "0 s";
		}

		return r;
	}

	@Override
	public void run() {
		startChrono();
	}

	public String getDureeFinal() {
		return dureeFinal;
	}
	public void setDureeFinal(String dureeFinal) {
		this.dureeFinal = dureeFinal;
	}

}