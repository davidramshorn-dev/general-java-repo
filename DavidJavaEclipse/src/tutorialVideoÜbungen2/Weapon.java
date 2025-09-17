package tutorialVideoÜbungen2;

import java.util.Objects;

public class Weapon {
String name;
public Weapon(String name) {
	this.name=name;
	
}
@Override
public boolean equals(Object ob) {
    if (this == ob) return true;
    if (ob == null || getClass() != ob.getClass()) return false;
    Weapon weapon = (Weapon) ob;
    return Objects.equals(name, weapon.name);
}

// hashCode-Methode überschreiben
@Override
public int hashCode() {
    return Objects.hash(name);
}
}
