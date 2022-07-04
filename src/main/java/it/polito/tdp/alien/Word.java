package it.polito.tdp.alien;

import java.util.Objects;

public class Word {

	private String parolaAliena;
	private String traduzione;
	
	public Word(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}

	public Word(String parolaAliena) {
		this.parolaAliena = parolaAliena;
	}

	public String getTraduzione() {
		return traduzione;
	}

	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
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
