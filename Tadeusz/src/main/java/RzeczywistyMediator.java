import java.util.*;

interface Mediator {
	public void wyślij(String id, String wiadomość);

	void zarejestrujKolegę(Kolega rene);
}

class RzeczywistyMediator implements Mediator {
	private HashMap<String, Kolega> koledzy = new HashMap<String, Kolega>();

	public void zarejestrujKolegę(Kolega k) {
		k.zarejestrujMediatora(this);
		koledzy.put(k.getId(), k);
	}

	public void wyślij(String id, String wiadomość) {
		koledzy.get(id).odbierz(wiadomość);
	}
}

class Kolega {
	private Mediator mediator;
	private String id;

	public Kolega(String id) { this.id = id; }
	public void zarejestrujMediatora(Mediator mediator) { this.mediator = mediator; }
	public String getId() { return id; }

	public void wyślij(String id, String wiadomość) {
		System.out.println("Przesyłanie wiadomości od "+this.id+" do "+id+": "+wiadomość);
		mediator.wyślij(id, wiadomość); // Rzeczywista komunikacja odbywa się za pośrednictwem mediatora!!!
	}

	public void odbierz(String wiadomość) {
		System.out.println("Wiadomość odebrana przez "+id+": "+wiadomość);
	}
}

class PrzykładoweUżycieMediatora {
	public static void main(String[] args) {
		Kolega rene = new Kolega("rene");
		Kolega toni = new Kolega("toni");
		Kolega kim = new Kolega("kim");

		Mediator m = new RzeczywistyMediator();
		m.zarejestrujKolegę(rene);
		m.zarejestrujKolegę(toni);
		m.zarejestrujKolegę(kim);

		kim.wyślij("toni", "Hello world.");
		rene.wyślij("kim", "Witaj!");
	}
}