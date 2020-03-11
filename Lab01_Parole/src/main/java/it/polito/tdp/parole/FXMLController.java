
package it.polito.tdp.parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	//Parole elenco ;
	Parole2 elenco;
	//List<String> elencoOrdinato=new LinkedList<String>();
	List<String> elencoOrdinato=new ArrayList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button cancBtn;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTimeEx;

    @FXML
    private Button btnReset;

    @FXML
    void doCanc(ActionEvent event) {

    	//quando premiamo il pulsante cancella dobbiamo eliminare dalla prima area di testo la parte di testo che è selezionata
    	String selected= txtResult.getSelectedText();
    	//txtTimeEx.appendText(selected);
    	if(selected.length()==0) {
    		System.out.println("\nNON HAI SELEZIONATO NIENTE DA CANCELLARE!");
    	}
    	else {
    		txtResult.clear();
    		elenco.deleteWord(selected);
    		String stampa="";
        	elencoOrdinato=elenco.getElenco();
        	for(String i: elencoOrdinato) {
        		stampa=stampa+"\n"+i;
        	}
        	txtResult.appendText(stampa);
    	}
    	
    	txtTimeEx.appendText("Delete "+System.nanoTime()+"\n");
    	
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	txtResult.clear();
    	String inserita=txtParola.getText();
    	if(inserita.length()==0) {
    		System.out.println("\nPAROLA VUOTA, DUNQUE NON INSERITA!");
    	}
    	else {
    		elenco.addParola(inserita);
    	}
    	String stampa="";
    	elencoOrdinato=elenco.getElenco();
    	for(String i: elencoOrdinato) {
    		stampa=stampa+"\n"+i;
    	}
    	txtResult.appendText(stampa);
    	
    	txtTimeEx.appendText("Add "+System.nanoTime()+"\n");

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();
    	elenco.reset();
    	txtTimeEx.appendText("Reset "+System.nanoTime()+"\n");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cancBtn != null : "fx:id=\"cancBtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTimeEx != null : "fx:id=\"txtTimeEx\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        //elenco = new Parole() ;
        elenco=new Parole2();
    }
}



