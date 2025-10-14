package hausaufgabenIT;

public class Palindrom {
	private String wort;
	public Palindrom(String wort) {
		this.wort=wort;
	}
	public boolean prüfeObPalindrom() {
		char[] wort=this.wort.toUpperCase().toCharArray();
		for (int i=0; i<wort.length; i++) {
		if (wort[i]!=wort[wort.length-i-1]) {
		return false;
		}
		}
		return true;
		}
}
