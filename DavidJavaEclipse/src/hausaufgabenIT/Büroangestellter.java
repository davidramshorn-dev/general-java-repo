package hausaufgabenIT;

public class Büroangestellter extends Mensch{
public int caffeeCounter;
public double müdigkeit;

public Büroangestellter (String name, int alter, int müdigkeit) {
	super(name, alter);
	caffeeCounter=0;
	this.müdigkeit=müdigkeit;
}

protected int benötigterKoffein() {
	müdigkeit =müdigkeit/caffeeCounter;
	return (int) müdigkeit*10;
}

public int getCaffeeCounter() {
	return caffeeCounter;
}

public void setCaffeeCounter(int caffeeCounter) {
	this.caffeeCounter = caffeeCounter;
}

public double getMüdigkeit() {
	return müdigkeit;
}

public void setMüdigkeit(double müdigkeit) {
	this.müdigkeit = müdigkeit;
}
}
