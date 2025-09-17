package tutorialVideoÜbungen2;

public class Hund_Generic <T>{
public T name;
public Hund_Generic(T name) {
	this.name=name;
}
public void gibName(){
	System.out.println(name.getClass());
}
}
