package tutorialVideoÜbungen3;

public abstract class Tier {
boolean istSäugetier;
int alter;
public Tier(boolean istSäugetier, int alter) {
	this.alter=alter;
	this.istSäugetier=istSäugetier;
}
public abstract void fressen();
}
