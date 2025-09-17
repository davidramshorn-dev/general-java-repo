package tutorialVideoÜbungen3;

import java.util.function.Function;

public class Main_FunctionalInterfaces {

	public static void main(String[] args) {
		Function<Integer, Integer> add3=(a)->a+3;
		Function<Integer, Integer> mutiplyBy4 =(a)->a*3;
		Function<Integer, Double> devideBy5=(a)->(double)a/5;
		Function<Double, String> toString=(a)->a.toString();
		System.out.println(add3.andThen(mutiplyBy4).andThen(devideBy5).andThen(toString).apply(17));
	}

}
