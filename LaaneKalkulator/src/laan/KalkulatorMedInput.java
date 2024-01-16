package laan;

import javax.swing.JOptionPane;

/* Dette er en laaneKalkulator som beregner pris for en kunde som ønsker billån. Den sjekker for 2 betingelser før den velger å regne ut et evt lån og hva den månedtlige kostnaden blir. 
Betingelsene kan endres og oppdateres for å passe lanetilbyders betingelser.
Lånebeløp, lengde, og nedbetaling leses inn fra evt bruker av programmet. Prosente/raten settes av lånetilbyder
*/
public class KalkulatorMedInput {

		public static void main(String[] args) {
			int laan = Integer.parseInt(JOptionPane.showInputDialog("Ønsket lånebeløp: "));
			int laanLengde = Integer.parseInt(JOptionPane.showInputDialog("Ønsket nedbetalingstid i år: "));
			int laanRate = 5; // tilsvarer 5% og settes av lånetilbyder
			int nedbetaling = Integer.parseInt(JOptionPane.showInputDialog("Ønsket månedlig nedbetalingsbeløp"));

			// conditions for a costumer to get loan
			if (laanLengde <= 0 || laanRate <= 0) {
				System.out.print("Error! Ugyldig lånlengde og/eller lån-rate!");
			} else if (nedbetaling > laan) {
				System.out.print("Error! nedbetaling er større enn lånebeløpet! Bilen kan betales uten lån.");
			} else {
				int gjenstaaendeBalanse = laan - nedbetaling;
				int maaneder = laanLengde * 12;
				int maanedligBalanse = gjenstaaendeBalanse / maaneder; // uten rente inkludert
				int renter = maaneder * laanRate / 100; // deler på 100 fordi proseneten er opgitt i heltall
				int maanedtligBetaling = maanedligBalanse + renter; // totalbeløpet som skal betales hver måned

				System.out.println(
						"Ditt månedlige beløp inkludert nedbetaling og renter på " + laanRate + "% blir: " + maanedtligBetaling + " kr");
				JOptionPane.showMessageDialog(null,"Ditt månedlige beløp inkludert nedbetaling og renter på " + laanRate + "% blir: " + maanedtligBetaling + " kr");
			}
		}
}
