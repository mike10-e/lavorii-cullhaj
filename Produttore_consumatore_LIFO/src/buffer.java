package ProduttoreConsumatore;

public class Buffer {
    private int array[];
    private int cima; // punta all'ultimo elemento inserito
    private int elementi; // numero totale di elementi
    private int capacità;

    public Buffer() {
        array = new int[10];
        cima = 0; // inizialmente, la cima è a 0 (vuota)
        capacità = 10;
    }

    public synchronized void inserisci(int n) {
        if (isFull()) {
            System.out.println("L'array è pieno.");
        } else {
            array[cima] = n; // inserisce l'elemento in cima
            cima++; // incrementa la cima
            elementi++; // aumenta il numero totale di elementi
            System.out.println("Inserito: " + n);
        }
    }

    public synchronized int togli() {
        if (isEmpty()) {
            throw new IllegalStateException("L'array è vuoto.");
        } else {
            cima--; // decrementa la cima per puntare all'ultimo elemento inserito
            int n = array[cima]; // recupera l'elemento più recentemente aggiunto
            elementi--; // diminuisce il numero totale di elementi
            return n; // restituisce l'elemento rimosso
        }
    }

    private boolean isFull() {
        return elementi == capacità; // restituisce true se l'array è pieno
    }

    private boolean isEmpty() {
        return elementi == 0; // restituisce true se l'array è vuoto
    }
}
