package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {

	private String parolaAliena;
	private List<String> traduzioni;
	
	public Word(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzioni = new ArrayList<String>();
		this.traduzioni.add(traduzione);
	}

	public Word(String parolaAliena) {
		this.parolaAliena = parolaAliena;
		this.traduzioni = new ArrayList<String>();
	}

	public List<String> getTraduzione() {
		return traduzioni;
	}

	public void addTraduzione(String traduzione) {
		if (traduzioni.contains(traduzione)) {
			return;
		}
		this.traduzioni.add(traduzione);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parolaAliena);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(parolaAliena, other.parolaAliena);
	}

}
