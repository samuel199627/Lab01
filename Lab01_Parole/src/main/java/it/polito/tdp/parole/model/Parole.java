package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> elenco;
		
	public Parole() {
		elenco=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		elenco.add(p);
	}
	
	public List<String> getElenco() {
		elenco.sort(null);
		return elenco;
	}
	
	public void reset() {
		elenco=new LinkedList<String>();
	}
	

	/*
	public String toString() {
		
		return ritorna;
	}
	*/

}
