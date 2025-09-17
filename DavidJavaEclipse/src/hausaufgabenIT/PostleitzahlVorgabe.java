package hausaufgabenIT;

public class PostleitzahlVorgabe {
char[] arrayZahlen = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
char[] arrayZahlen1 = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
public String land;
public String plz;

public PostleitzahlVorgabe(String land, String plz) {
	this.land=land;
	this.plz=plz;
}

public boolean isValidPLZ() {
	boolean isValid=false;
	switch (land) {
	case "DE":
		isValid=isValidPLZDE(); break;
	case "PL":
		isValid=isValidPLZPL(); break;
	case "FR":
		isValid=isValidPLZFR(); break;
	default:
		System.out.println("Dieses Land existiert nicht!");
	}
	return isValid;
}

public boolean isValidPLZDE() {
int zaehler = 0;
boolean isValid = false;
if (plz.charAt(0) != '0' && plz.length() == 5) {
loop: for (int i = 0; i < 5; i++) {
if (i == 0) {
continue loop;
}
for (char y : arrayZahlen) {
if (plz.charAt(i) == y) {
zaehler++;
}
}
if (zaehler != 1) {
return false;
} else {
zaehler = 0;
}
}
for (char y : arrayZahlen1) {
if (plz.charAt(0) == y) {
zaehler++;
}
}
if (zaehler != 1) {
return false;
} else {
zaehler = 0;
}
return true;
}
return isValid;
}


@SuppressWarnings("unused")
public boolean isValidPLZPL() {
int zaehler = 0;
boolean isValid = false;
if (plz.length() == 5) {
loop: for (int i = 0; i < 4; i++) {
for (char y : arrayZahlen) {
if (plz.charAt(i) == y) {
zaehler++;
}
}
if (zaehler != 1) {
return false;
} else {
zaehler = 0;
}
}
return true;
}
return isValid;
}

public boolean isValidPLZFR() {
int zaehler = 0;
boolean isValid = false;
if (plz.indexOf("-") == 2 && plz.length() == 6) {
loop: for (int i = 0; i < 5; i++) {
if (i == 2) {
continue loop;
}
for (char y : arrayZahlen) {
if (plz.charAt(i) == y) {
zaehler++;
System.out.println(zaehler);
}
}
if (zaehler != 1) {
return false;
} else {
zaehler = 0;
}
}
return true;
}
return isValid;
}
}
