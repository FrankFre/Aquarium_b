
public class Aquariumb_main {	

	public static void main(String[] args) throws InterruptedException {
		
		/* Initialgrösse des Beckens */
		int x = 60;
		int y = 10;


//		1. Gegnerierung des Beckens mit festen Parametern

		Aquariumb meinAquariumb = new Aquariumb(x, y);

//		2. Fische generieren anhand der Beckenhöhe mit fixen Parametern 

		meinAquariumb.fuellen();
		
//		3. alles anzeigen
		meinAquariumb.anzeigen();
		
//		4. Schleife mit 3 Durchgängen duchs Becken
		meinAquariumb.fischeBewegen();

		
		meinAquariumb.anzeigen();
		meinAquariumb.fischeBewegen();
//			- Fische bewegen um einen Schritt
//	 		- alles anzeigen

		
//		Iterationsschleife, um die Fische 2x zu bewegen
		
		for (int i = 0; i < (x * 2); i++) {
			
			for (int j = 0; j < 20; j++) {				// Schleife zur Initialisierung einer "freien" Ausgabenkonsole
				System.out.println();				
				}
			
			meinAquariumb.anzeigen();
			meinAquariumb.fischeBewegen();
			Thread.sleep(200);							
			}

	}

}
