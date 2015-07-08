
/**
 * Classe que modela o evento da chegada de um processo
 *
 * @author gvpm
 */
public class ChegaEvt extends Evento {

    Processo p;

    /**
     * Metodo Construtor
     * @param t
     * @param p
     * @param e
     */
    public ChegaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 2;
    }

    /**
     * Adiciona o processo na fila do escalonador Cria um evento de chamada do
     * escalonador para o tempo atual
     *
     */
    @Override
    public void run() {
        estrutura.addFilaEscalonador(p);
        EscalonaEvt e = new EscalonaEvt(t, estrutura);
        estrutura.addEvento(e);

    }

}
