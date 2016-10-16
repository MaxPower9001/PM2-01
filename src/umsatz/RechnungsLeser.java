package umsatz;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RechnungsLeser {

    private String quelle;

    public RechnungsLeser(String string) {
        this.quelle = string;
    }

    public Kasse leseKasse() throws FileNotFoundException, UngueltigerGeldbetragException {

    	Pattern patternRechnung = Pattern.compile("\\s*(\\d+)\\s*(\\|\\|.*)");
    	Pattern patternPositionen= Pattern.compile("\\|\\|\\s*([^;]+[^; ])\\s*;\\s*(\\d+)(?:,(\\d+))?");
    	
        Kasse kasse = new Kasse();
        // Erzeugt ein Dateiobjekt f (File) aus dem Namen der Datei quelle
        // sowie einen Scanner, der das Dateiobjekt f liest.
        // Eine Zeile in der Datei entspricht einer Rechnung.
        File f = new File(Paths.get(quelle).toString());
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
        	String line = sc.nextLine();
        	Matcher matcher = patternRechnung.matcher(line);
    		if(matcher.matches()) {
    			Integer rechnungsNummer = Integer.valueOf(matcher.group(1));
    			Rechnung rechnung = new Rechnung(rechnungsNummer);
    			String restPositionen = matcher.group(2);
    			Matcher matcherPosis = patternPositionen.matcher(restPositionen);
    			while(matcherPosis.find()) {
    				String positionName = matcherPosis.group(1);
    				Integer preisEuro = Integer.valueOf(matcherPosis.group(2)) ;
    				Integer preisCentsOptional = matcherPosis.group(3) == null ? null : Integer.valueOf(matcherPosis.group(3));
    				GeldBetrag geldBetrag;
    				if(preisCentsOptional == null) {
    					 geldBetrag = new GeldBetrag(preisEuro * 100);
    				} else {
    					geldBetrag = new GeldBetrag(preisEuro * 100, preisCentsOptional);
    				}
    				Position position = new Position(positionName, geldBetrag);
    				rechnung.add(position);
    			}
    			kasse.add(rechnung);
    		}
           }
        
        sc.close();
        return kasse;
    }

}
