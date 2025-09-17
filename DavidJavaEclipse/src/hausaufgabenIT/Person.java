package hausaufgabenIT;

public class Person {
public String name;
public int alter;

public Person(String name, int alter) {
this.name = name;
this.alter = alter;
}

public Person(int alter) {
this.name = "Unbekannt";
this.alter = alter;
}

public void zeigeInfo() {
System.out.printf("%s ist %d Jahre alt.", name, alter);
}
}
