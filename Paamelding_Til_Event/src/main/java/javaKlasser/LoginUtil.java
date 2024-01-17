package javaKlasser;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
	

		public static void loggUtBruker(HttpSession session) {
			
			session.invalidate();
			
		}

		public static void loggInnBruker(HttpServletRequest request, String mobil) {
			
			
			
			loggUtBruker(request.getSession());
			
			HttpSession sess= request.getSession();
			sess.setMaxInactiveInterval(180);
			
			sess.setAttribute("mobil", mobil);
			sess.setAttribute("erBrukerInnlogget", true);
		}
		
		public static boolean erBrukerInnlogget(HttpSession session) {
			
			

			
			return session !=null && session.getAttribute("mobil") !=null;
			
		}

		public static void loggutBruker(HttpSession session) {
			// TODO Auto-generated method stub
			
		}

	}


