package tutorialVideoÜbungen3;

public class Streamer {
public String name;
public double mioAbonnenten;
public String beruf;
public Streamer(String name, double mioAbonnenten, String beruf) {
	this.beruf=beruf;
	this.mioAbonnenten=mioAbonnenten;
	this.name=name;
}
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Streamer)) return false;
    Streamer other = (Streamer) obj;
    return name.equals(other.name);
}

@Override
public int hashCode() {
    return name.hashCode();
}
}
