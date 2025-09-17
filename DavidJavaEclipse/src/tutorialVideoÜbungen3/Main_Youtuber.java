package tutorialVideoÜbungen3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Youtuber {

	public static void main(String[] args) {
		List<Youtuber> dieGang=new ArrayList<>();
		dieGang.add(new Youtuber("BastiGHG", 2.13, true));
		dieGang.add(new Youtuber("Simplicissimus", 6, true));
		dieGang.add(new Youtuber("Paluten", 7, true));
		dieGang.add(new Youtuber("Papaplatte", 2.5, true));
		dieGang.add(new Youtuber("Unge", 5, false));
		dieGang.add(new Youtuber("ApoRed", 0.4, false));
		dieGang.add(new Youtuber("Julien Bam", 9.5, false));
		dieGang.stream()
				.filter(tuber->2>tuber.mioAbbonenten)
				.forEach(tuber->System.out.println(tuber.name));
		boolean anyMatch=dieGang.stream()
		.anyMatch(tuber->tuber.name.equals("Du Huen"));
		System.out.println(anyMatch);
		List<Streamer> streamer=new ArrayList<>();
		streamer =dieGang.stream()
				.filter(f->f.istAktiv)
				.map(f->new Streamer(f.name, f.mioAbbonenten, "Streamer"))
				.peek(i->System.out.println(i.name))
				.collect(Collectors.toList());
		System.out.println(streamer.contains("ApoRed"));
	}
	

}
