import java.util.Random;

public class Aquariumb {

	private int breite;
	private int hoehe;

	private Fischb[] fische; /* Array von typ Fisch mit dem Namen fische */

	/* Konstruktor für das Becken, Masse müssen bei Aufruf angegeben werden */

	public Aquariumb(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;

	}

	/* getter und setter-Methoden entsprechend nach späterem Bedarf */

	public int getHoehe() {
		return this.hoehe;
	}

	public int getBreite() {
		return this.breite;
	}

	/*
	 * Methode füllen füllt das Becken entsprechend seiner Höhe mit einer
	 * entsprechenden Anzahl von Fischen
	 */

	public void fuellen() {

		// Aufruf des Konstruktors der Methode Zufall
		Random zufall = new Random();		
		
		int xzuf1, xzuf2; 
		
		// Array vom Typ Fisch namens fische in der Grösse hoehe wird angelegt
		this.fische = new Fischb[this.hoehe]; 		
	
		
		// Es werden Fisch-Elemente pro Zeile angelegt
		for (int i = 0; i < this.hoehe; i++)  {			

			// Generieren eines zufälligen Fisch-Typs
			xzuf1 = zufall.nextInt(3);
			//System.out.println(this.hoehe+1);
			switch(xzuf1)   {
			
			case 0:
				// generieren eines Zufalls-Wertes im Bereich Beckenbreite ohne die Länge Fisch
				xzuf2 = zufall.nextInt((breite - 9));
				fische[i] = new Haie(xzuf2, i, true);
//				System.out.println("xxx");
				break;
			
			case 1:	
				xzuf2 = zufall.nextInt((breite - 5));
				fische[i] = new Kugelf(xzuf2, i, true);
				break;
				
			case 2:
				xzuf2 = zufall.nextInt((breite - 4));
				fische[i] = new Schwertf(xzuf2, i, true);
				break;
				}
			}	
	}
//	

	public void anzeigen() {

		// Schleife so oft wie Aquariumhöhe:

		for (int i = 0; i < this.hoehe; i++) {

			// Gibt linken Rand vom Becken aus
			this.gibRandAus();

			// Gib eine Zeile Wasser mit Fisch aus
			this.gibZeileAus(i);

			// Gib rechten Rand vom Becken aus
			this.gibRandAus();

			System.out.println();
		}
		// Gib eine Zeile Aquariumboden aus
		this.gibBodenAus();
	}

	private void gibBodenAus() {

		System.out.print('+');

		for (int i = 0; i < this.breite; i++) {
			System.out.print('-');
		}
		System.out.println('+');
	}

	private void gibRandAus() {
		System.out.print('|');
	}

	
	/* Hier wird eine Fisch Zeile aufgebaut für die String-Ausgabe */
	
	private void gibZeileAus(int zeile) {

		int xwert = this.fische[zeile].getXpos();
		
		// erster Teil Wasser mit Leerzeichen linke Seite
		for (int i = 0; i < (xwert); i++) {
			System.out.print(' ');
		}

		// Einsetzen des Strings des Fisch-Shapes
		if (this.fische[zeile].getDir()) {

			System.out.print(fische[zeile].getShape());
			

		} else {
			System.out.print(fische[zeile].getShape());
		}

		// zweiter Teil Wasser mit Berücksichtung der Shape_länge
		for (int i = (xwert); i < (this.breite - fische[zeile].laenge); i++) {    
			System.out.print(' ');
		}

	}

	// Bewegen aller Fisch-Objekte entsprechend ihres konkreten Zustandes
	public void fischeBewegen()  {

		for (int i = 0; i < this.hoehe; i++) {
			fische[i].bewegen(this.breite);
		}
	}

}
