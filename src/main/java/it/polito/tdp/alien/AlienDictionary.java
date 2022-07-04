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
			dizionario.get(dizionario.indexOf(temp)).addTraduzione(traduzione);
		} else {
			dizionario.add(temp);
		}
	}
	
	public List<String> translate(String parola) {
		Word temp = new Word(parola);
		
		if (dizionario.contains(temp)) {
			return dizionario.get(dizionario.indexOf(temp)).getTraduzione();
		} else {
			return null;
		}
	}
	
	public void reset() {
		dizionario.clear();
	}

	public List<String> translateWildCard(String parolaAliena) {
		
		parolaAliena = parolaAliena.replace("?", ".");
		List<String> elenco = new ArrayList<String>();
		
		for (Word w : dizionario) {
			if (w.confrontoWildCard(parolaAliena)) {
				elenco.addAll(w.getTraduzione());
			}
		}
		return elenco;
		
	}
	
}
