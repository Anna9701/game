import java.util.Random;

class Game{
	private final int N;
	private final int MIN_ARGS_LIMIT = 1;
	private final int MIN_ZAKRES = 0; 
	private final int MAX_PROB = 10;
	private int liczbadocelowa = 0;
	private int wykprob = 0;
	private boolean koniec = false;
	
	Game (String[] args){
		int x = 0;
		if (args.length < MIN_ARGS_LIMIT){
			System.out.println("Za malo podanych argumentow!");
			System.exit(2);
		}
		try{
			x = Integer.parseInt(args[0]);
		}catch(NumberFormatException error1){
			System.out.println("Zly format danych wejsciowych!");
			System.exit(3);
		}
		if(x < MIN_ZAKRES){
			System.out.println("Limit nie moze byc mniejszy od 0!");
			System.exit(1);
		}	
		N = x;
		wylosuj();
	}
	
	Game (int x){
		if(x < MIN_ZAKRES){
			System.out.println("Limit nie moze byc mniejszy od 0!");
			System.exit(1);
		}
		N = x;
		wylosuj();
	}
	
	void wylosuj (){
		Random generator = new Random();
		liczbadocelowa = generator.nextInt(N);
	}
	
	int pobierzLiczbe(){
		int liczba = 0;
		do{
			if (liczba == 0)
				System.out.println("Podaj liczbe: ");
			else
				System.out.println("Wprowadzono bledna liczbe! Sprobuj jeszcze raz. Pamietaj, ze musi ona byc wieksza od " + MIN_ZAKRES + 
						           " i mniejsza od " + N + ".");
			liczba = System.in.read();
		}while(liczba < 0 || liczba > N);
		
		return liczba;
	}
	
	
	boolean kolejkaGry(){
		int liczba = pobierzLiczbe();
		boolean wygrana = false;
		++wykprob;

		if (liczba == liczbadocelowa)
			wygrana = true;
		else if ( liczbadocelowa < liczba)
			System.out.println("Wylosowana liczba jest mniejsza od podanej!");
		else
			System.out.println("Wylosowana liczba jest wieksza od podanej!");
		
		if(wykprob <= MAX_PROB)
			System.out.println("Zostalo Ci jeszcze: " + (MAX_PROB-wykprob) + " prob. Probuj dalej!");
		else{
			System.out.println("Niestety to koniec gry! Moze nastepnym razem bedziesz miec wiecej szczescia?");
			koniec = true;
		}
		
		return wygrana;
	}
	
	void graj (){
		boolean winner = kolejkaGry();
		
	}
}

public class MainGra {
	public static void main(String[] args) {
		Game gra1 = new Game(args);
		
		gra1.graj();
		
		return;
	}
};

