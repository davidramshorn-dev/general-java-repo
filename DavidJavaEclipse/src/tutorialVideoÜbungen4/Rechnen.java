package tutorialVideoÜbungen4;

public class Rechnen {

    public static void main(String[] args) {
//        Rechnen.<Double, Double>rechnen((a1, a2) -> {a1 + a2}, 5.0, 3.0);
    }

    public static <T, U> void rechnen(Rechner rechner, T a1, U a2) {
        System.out.println(rechner.rechnen(a1, a2));
    }
}
