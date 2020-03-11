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
	
	public void deleteWord(String selected) {
		
		System.out.println("Parola da cancellare: "+selected);
		/*
		for(String i:this.elenco) {
			if(i.equals(selected)) {
				this.elenco.remove(i);
			}
		}
		*/
		for(int i=0; i<this.elenco.size();i++) {
			if(this.elenco.get(i).equals(selected)) {
				//System.out.println("Ciao!\n");
				elenco.remove(i);
				return ;
			}
		}
	}

}
