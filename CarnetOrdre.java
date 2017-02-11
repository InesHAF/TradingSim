package tradingsim;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;




public class CarnetOrdre {
    

	private Queue<OrdrePrix> achatqueue = new PriorityQueue<OrdrePrix>(100, new Comparator<OrdrePrix>() {
		public int compare(OrdrePrix int1, OrdrePrix int2) {
			Double prix1 = int1.getPrix();
			Double prix2 = int2.getPrix();
			return prix2.compareTo(prix1);
		}
	});
	private Queue<OrdrePrix> ventequeue = new PriorityQueue<OrdrePrix>(100, new Comparator<OrdrePrix>() {
		public int compare(OrdrePrix int1, OrdrePrix int2) {
			Double prix1 = int1.getPrix();
			Double prix2 = int2.getPrix();
			return prix1.compareTo(prix2);
		}
	});

	public CarnetOrdre() {

	}

	public Queue<OrdrePrix> getAchatqueue() {
		return achatqueue;
	}

	public void setAchatqueue(Queue<OrdrePrix> achatqueue) {
		this.achatqueue = achatqueue;
	}

	public Queue<OrdrePrix> getVentequeue() {
		return ventequeue;
	}

	public void setVentequeue(Queue<OrdrePrix> ventequeue) {
		this.ventequeue = ventequeue;
	}



	public int addOrdre(Ordre ordre) {
		if (ordre.isAchat()) {
			OrdrePrix ordreprix = containAchat(ordre.getPrixunitaire());
			if (ordreprix != null) {
				return ordreprix.addOrdre(ordre);
			} else {
				ordreprix = new OrdrePrix(ordre);
				achatqueue.add(ordreprix);
				return 1;
			}
		} else {
			OrdrePrix ordreprix = containVente(ordre.getPrixunitaire());
			if (ordreprix != null) {
				return ordreprix.addOrdre(ordre);
			} else {
				ordreprix = new OrdrePrix(ordre);
				ventequeue.add(ordreprix);
				return 1;
			}

		}

	}

	public OrdrePrix containAchat(double prix) {

		Iterator<OrdrePrix> iterator = achatqueue.iterator();
		while (iterator.hasNext()) {
			OrdrePrix ordreprix = iterator.next();
			if (ordreprix.getPrix() == prix) {
				return ordreprix;
			}
		}
		return null;
	}

	public OrdrePrix containVente(double prix) {
		Iterator<OrdrePrix> iterator = ventequeue.iterator();
		while (iterator.hasNext()) {
			OrdrePrix ordreprix = iterator.next();
			if (ordreprix.getPrix() == prix) {
				return ordreprix;
			}
		}
		return null;
	}
	
	public int removeOrdre(Ordre ordre){
		if (ordre.isAchat()){
			Iterator<OrdrePrix> iterator = achatqueue.iterator();
			while(iterator.hasNext()){
				OrdrePrix ordreprix= iterator.next();
				
				if(ordreprix.getListeordre().containsValue(ordre)){
					ordreprix.getListeordre().remove(ordre.getKey());
					ordreprix.actualiserQuantite();
					if(ordreprix.getQuantitetotale()==0){
						achatqueue.remove(ordreprix);
					}
					return 1;
				}
			}
				return 0;
			
		}else{
			Iterator<OrdrePrix> iterator = ventequeue.iterator();
			while(iterator.hasNext()){
				OrdrePrix ordreprix= iterator.next();
				
				if(ordreprix.getListeordre().containsValue(ordre)){
					ordreprix.getListeordre().remove(ordre.getKey());
					ordreprix.actualiserQuantite();
					if(ordreprix.getQuantitetotale()==0){
						achatqueue.remove(ordreprix);
					}
					return 1;
				}
				
			}
			return 0;
		}
	}

	public void affichage() {
		Iterator<OrdrePrix> iterator = achatqueue.iterator();
		System.out.println("-----CarnetOrdre-----\n");
		System.out.println("-----Achats-----\n");
		while (iterator.hasNext()) {
			OrdrePrix ordreprix = iterator.next();
			System.out.println(ordreprix);
		}
		iterator = ventequeue.iterator();
		System.out.println("-----Ventes-----\n");
		while (iterator.hasNext()) {
			OrdrePrix ordreprix = iterator.next();
			System.out.println(ordreprix);
		}
	}
	

}
