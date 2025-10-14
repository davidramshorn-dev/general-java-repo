package hausaufgabenIT;

public class Mensch {
protected int alter;
public String name;
public Mensch(String name, int alter) {
	this.alter=alter;
	this.name=name;
}
public Mensch() {
	alter=0;
	name="";
}
protected void feiertGeburtstag() {
	alter++;
}
public int getAlter() {
	return alter;
}
public void setAlter(int alter) {
	this.alter = alter;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
