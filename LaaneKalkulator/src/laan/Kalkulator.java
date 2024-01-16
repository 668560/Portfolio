package laan;

/* Dette er en laaneKalkulator som beregner pris for en kunde som ønsker billån. Den sjekker for 2 betingelser før den velger å regne ut et evt lån og hva den månedtlige kostnaden blir. 
Betingelsene kan endres og oppdateres for å passe lanetilbyders betingelser.
Lånebeløp, lengde, rate og nedbetaling kan også endres. 
*/
public class Kalkulator {

	public static void main(String[] args) {
		int laan = 10000;
		int laanLengde = 3;
		int laanRate = 5; // tilsvarer 5%
		int nedbetaling = 2000;

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
					"Ditt månedlige beløp inkludert nedbetaling og renter blir: " + maanedtligBetaling + " kr");
		}
	}
}
