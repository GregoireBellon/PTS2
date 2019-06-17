package visual;

public class Chrono extends Thread {

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
		if ((h <= 0) && (m <= 0) && (s <= 0)) {
			r = "0 s";
		}

		return r;
	}

	private String dureeFinal = "";
	private boolean stoped = true;

	private long tempsDepart = 0;

	public String getDureeFinal() {
		return dureeFinal;
	}

	public long getDureeSec() {
		return (System.currentTimeMillis() - tempsDepart) / 1000;
	}

	public String getDureeTxt() {
		return timeToHMS(getDureeSec());
	}

	public boolean isStoped() {
		return stoped;
	}

	@Override
	public void run() {
		startChrono();
	}

	public void setDureeFinal(String dureeFinal) {
		this.dureeFinal = dureeFinal;
	}

	public void setStoped(boolean stoped) {
		this.stoped = stoped;
	}

	public void startChrono() {
		tempsDepart = System.currentTimeMillis();
		stoped = false;
	}

	public String stopChrono() {
		dureeFinal = getDureeTxt();
		stoped = true;
		return dureeFinal;
	}

}