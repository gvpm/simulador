
/**
 * Classe que modela o evento do escalonador.
 *
 * @author gvpm
 */
public class EscalonaEvt extends Evento {

    int idEscalonador;
    Escalonador escalonador;

    /**
     * Metodo Construtor
     * @param t tempo na simulacao
     * @param e estrutura da simulacao
     */
    public EscalonaEvt(int t, Estruturas e) {
        this.t = t;
        this.estrutura = e;
        this.id = 3;

    }

    /**
     * Chama o escalonador da simulacao para o tempo atual
     */
    @Override
    public void run() {

        estrutura.getEscalonador().escalona(t);

    }

}
