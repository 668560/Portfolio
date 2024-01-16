package src;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();
		ProsjektDAO prosjektDAO = new ProsjektDAO();
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		AnsattprosjektDAO ansattprosjektDAO = new AnsattprosjektDAO();

		int ansattId;
		boolean quit = false;

		while (!quit) {
			String info = "Hei! \n" + "Press \n" + "1 for Søke etter ansatt på ansatt-id \n"
					+ "2 for Søke etter ansatt på brukernavn  " + "\n" + "3 for Utlisting av alle ansatte  \n"
					+ "4 Oppdatere en ansatt sin loenn \n" + "5 Oppdatere en ansatt sin stilling \n"
					+ "6 Legge inn en ny ansatt  \n" + "7 for å finn avdeling med Id \n"
					+ "8 for utlisting av alle ansatte på en avdeling \n"
					+ "9  for å oppdatere hvilken avdeling en ansatt jobber på\n"
					+ "10 for å legge inn en ny avdeling \n" + "11 for å legge inn et nytt prosjekt \n"
					+ "12 for å registrere prosjektdeltagelse"
					+ "\n13 for å føre timer på ansatt i prosjekt \n14 Utskrift ang info om prosjekt \n15 Utskrift av alle prosjekt \n16 Utlisting av alle avdelinger \n"
					+ "0 for å avslutte";

			System.out.println(info);
			int input = 0;
			String ansattBrukernavn = "";

			Scanner inn = new Scanner(System.in);
			input = java.lang.Integer.parseInt(inn.nextLine());
			switch (input) {

			case 0:

				quit = true;
				break;

			//  Søke etter ansatt på ansatt-id

			case 1:
				System.out.println("Skriv inn ansatt-id");

				ansattId = java.lang.Integer.parseInt(inn.nextLine());
				Ansatt ansatt = ansattDAO.hentAnsattId(ansattId);

				System.out.println(ansatt.toString());

				break;

			// Søke etter ansatt på brukernavn

			case 2:
				System.out.println("Skriv inn brukernavn");
				ansattBrukernavn = "" + inn.nextLine();
				Ansatt bruker = ansattDAO.hentBrukernavn(ansattBrukernavn);
				System.out.println(bruker.toString());

				break;

			case 3:

				// Utlisting av alle ansatte

				List<Ansatt> ansattListe = ansattDAO.hentAlleAnsatte();
				// ansattListe =;
				ansattListe.forEach(System.out::println);
//for (int f = 0; f<ansattListe.size();f++) {

				// System.out.println(ansattListe.get(f));

//}
				break;

			case 4:

				//  Oppdatere en ansatt sin lønn

				System.out.println("Skriv inn ansatt-id, og maanedsloenn");
				ansattId = java.lang.Integer.parseInt(inn.nextLine());

				System.out.println("og maanedsloenn");
				int loenn = java.lang.Integer.parseInt(inn.nextLine());

				ansattDAO.oppdaterLoenn(ansattId, loenn);

				System.out.println("Oppdatert!");

				break;

			case 5:

				// Oppdatere en ansatt sin stilling

				System.out.println("Skriv inn ansatt-id");
				ansattId = java.lang.Integer.parseInt(inn.nextLine());

				System.out.println("og ny stilling");
				String stilling = inn.nextLine();

				ansattDAO.oppdaterStilling(ansattId, stilling);

				break;

			case 6:

				// Legge inn en ny ansatt

				System.out.println("Skriv inn bruker-id");
				String brukerId = inn.nextLine();

				System.out.println("Skriv inn fornavn");
				String fornavn = inn.nextLine();

				System.out.println("Skriv inn etternavn");
				String etternavn = inn.nextLine();

				System.out.println("Skriv inn ansettelsesdato");
				Date ansettelsesdato;
				try {
					ansettelsesdato = new SimpleDateFormat("dd/MM/yyyy").parse(inn.nextLine());
				} catch (ParseException e) {
					ansettelsesdato = new Date(1920, 12, 12);

					e.printStackTrace();
				}

				System.out.println("Skriv inn stilling");
				String stillingn = inn.nextLine();

				System.out.println("Skriv inn maanedsloenn");
				int maanedsloenn = java.lang.Integer.parseInt(inn.nextLine());

				System.out.println("Skriv inn avdeligsid");
				int avdelingids = java.lang.Integer.parseInt(inn.nextLine());

				Avdeling avdelingg = avdelingDAO.finnAvdelingMedId(avdelingids);

				Ansatt ansattInn = new Ansatt(brukerId, fornavn, etternavn, ansettelsesdato, stillingn, maanedsloenn); // avdelingids
				ansattInn.setAvdeling(avdelingg);
				avdelingg.getAnsatte().add(ansattInn);
				ansattDAO.lagreAnsatt(ansattInn);
				avdelingDAO.oppdaterAvdeling(avdelingg);
				break;
			case 7:

				// finnAvdeling Med Id(

				System.out.println("Skriv inn avdelingsid");
				int avdelingsId = java.lang.Integer.parseInt(inn.nextLine());
				System.out.println("" + (avdelingDAO.finnAvdelingMedId(avdelingsId).toString()));

				break;

			case 8:

				// Utlisting av alle ansatte på en avdeling
				// inkl. utheving av hvem som er sjef

				System.out.println("Skriv inn avdelingsid");
				avdelingsId = java.lang.Integer.parseInt(inn.nextLine());

				Avdeling avd = avdelingDAO.finnAvdelingMedId(avdelingsId);

				List<Ansatt> ansatte = avd.getAnsatte();

				Ansatt sjef = avd.getSjef();

				// ansatte.forEach(System.out::println);
				System.out.println("Antall ansatte: " + ansatte.size());

				for (int i = 0; i < ansatte.size(); i++) {

					if (ansatte.get(i).getAnsattid() == sjef.getAnsattid()) {

						System.out.println(" Sjef: " + ansatte.get(i).toString() + "\n");
					} else {

						System.out.println(ansatte.get(i).toString() + "\n");
					}

				}

				break;

			case 9:

				// Oppdatere hvilken avdeling en ansatt jobber på
				// Man kan ikke bytte avdeling hvis man er sjef!

				System.out.println("Skriv inn ansatt-id, ");
				ansattId = java.lang.Integer.parseInt(inn.nextLine());

				System.out.println("og ny avdelingsid");
				int nyAvdeling = java.lang.Integer.parseInt(inn.nextLine());

				Ansatt aa = ansattDAO.hentAnsattId(ansattId);
				if (aa.getStilling().compareTo("sjef") == 0) {
					System.out.println("Kan desverre ikke bytte stilling som sjef");
				}

				else {

					ansattDAO.oppdaterAnsattAvdeling(ansattId, nyAvdeling);
					// sjekDAO

					System.out.println("Avdeling oppdatert!");

//////

				}
				break;

			case 10:

				// Legge inn en ny avdeling
				// NB! Siden en avdeling MÅ ha en sjef

				System.out.println("Skriv inn navn på avdeling, ");
				String navnPaaAvdeling = inn.nextLine();

				System.out.println("og ansatt-id til avdelingssjef");
				int nyAvdelingsjef = java.lang.Integer.parseInt(inn.nextLine());

				Ansatt nySjef = ansattDAO.hentAnsattId(nyAvdelingsjef);

				Avdeling nylagetAvdeling = new Avdeling(navnPaaAvdeling, nySjef);
				avdelingDAO.oppdaterAvdeling(nylagetAvdeling);

				System.out.println("Avdeling oprettet!");
				break;

			/// Litt til mht automatisk lagt til avd etc.. ?

			case 11:
				// Legge inn nytt prosjekt
				System.out.println("Skriv inn prosjektnavn:");
				inn = new Scanner(System.in);
				String navnPaaProsjekt = inn.nextLine();

				System.out.println("prosjektbeskrivelse");
				String prosjektBeskrivelse = (inn.nextLine());

				Prosjekt nyttprosjekt = new Prosjekt(navnPaaProsjekt, prosjektBeskrivelse);
				prosjektDAO.lagreProsjekt(nyttprosjekt);
				System.out.println("Nytt prosjekt opprettet" + navnPaaProsjekt + " " + prosjektBeskrivelse);
				break;

			case 12:
				// Registrere prosjektdeltagelse
				System.out.println("Skriv inn ansatt id");
				ansattId = java.lang.Integer.parseInt(inn.nextLine());
				ansatt = ansattDAO.hentAnsattId(ansattId);

				System.out.println("skriv inn prosjekt id ");
				int prosjektId = java.lang.Integer.parseInt(inn.nextLine());

				Prosjekt prosjekt = prosjektDAO.finnProsjektMedId(prosjektId);

				System.out.println("rolle");
				String rolle1 = (inn.nextLine());

				prosjekt.leggTilAnsatt(ansatt, rolle1);

				prosjektDAO.oppdaterProsjekt(prosjekt);

				break;

			case 13:

				// Føre inn timer på en ansatt i prosjekt
				System.out.println("Skriv inn brukernavn");

				ansattBrukernavn = "" + inn.nextLine();
				Ansatt brukerff = ansattDAO.hentBrukernavn(ansattBrukernavn);

				System.out.println("timeføring");
				Double arbeidstimer = (java.lang.Double.parseDouble((inn.nextLine())));

				System.out.println("prosjekt id");
				int prosjektIdd = java.lang.Integer.parseInt(inn.nextLine());

				List<Ansattprosjekt> ja = brukerff.ansattprosjekt;

				for (int uu = 0; uu < ja.size(); uu++) { ////

					if (ja.get(uu).getProsjekt().getProsjektid() == (prosjektIdd)) {

						ja.get(uu).setArbeidstimer(arbeidstimer);
						ansattprosjektDAO.oppdaterAnsattprosjekt(ja.get(uu));

					}

				}

				break;

			case 14:
				// utskrift om info om prosjekt

				System.out.println("Skriv inn prosjekt id");

				prosjektId = java.lang.Integer.parseInt(inn.nextLine());

				Prosjekt ppp = prosjektDAO.finnProsjektMedId(prosjektId);

				System.out.println(ppp.prosjektUtskrift());

				break;

			case 15:

				// Utlisting av alle prosjekt

				List<Prosjekt> prosjektliste = prosjektDAO.hentAlleProsjekt();

				prosjektliste.forEach(System.out::println);

				break;

			case 16:

				// Utlisting av alle avdelinger

				List<Avdeling> avdelingliste = avdelingDAO.hentAlleAvdelinger();

				avdelingliste.forEach(System.out::println);

				break;

			}
		}

	}
}
