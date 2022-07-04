package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<Word>();
	}
	
	public void addWord(String parola, String traduzione) {
		Word temp = new Word(parola, traduzione);
		if (dizionario.contains(temp)) {
			dizionario.get(dizionario.indexOf(temp)).setTraduzione(traduzione);
		} else {
			dizionario.add(temp);
		}
	}
	
	public String translate(String parola) {
		Word temp = new Word(parola);
		String risultato;
		if (dizionario.contains(temp)) {
			risultato = dizionario.get(dizionario.indexOf(temp)).getTraduzione();
		} else {
			risultato = null;
		}
		return risultato;
	}
	
	public void reset() {
		dizionario.clear();
	}
	
}
