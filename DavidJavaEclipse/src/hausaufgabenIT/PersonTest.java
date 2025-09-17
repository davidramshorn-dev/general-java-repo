package hausaufgabenIT;

public class PersonTest {

public static void main(String[] args) {
Person[] schueler = { new Person("David", 16), new Person("Nicolas", 15), new Person(12) };
for (Person i : schueler) {
i.zeigeInfo();
}
}

}