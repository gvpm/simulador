
import java.util.Comparator;

/**
 * Classe que representa um evento abstrato
 *
 * @author gvpm
 */
public abstract class Evento implements Comparator {

    int t, id;

    Estruturas estrutura;

    /**
     *
     */
    public void run() {

    }

    /**
     * Retorna o tempo do evento
     *
     * @return tempo na simulacao
     */
    public int getT() {
        return t;
    }

    /**
     *
     * @return id do tipo do evento
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return processo do evento, caso exista
     */
    public Processo getP() {
        return null;
    }

    /**
     * Metodo "compare" implementada para fazer o evento ser comparavel e
     * possobilitar a utilizacao do metodo sort
     *
     * Faz a comparacao pelo tempo e caso o tempo seja igual faz a comparacao
     * pela ID do evento respeitando as prioridades de execucao dos eventos
     *
     */
    @Override
    public int compare(Object o1, Object o2) {
        Evento e1 = (Evento) o1;
        Evento e2 = (Evento) o2;

        int r = 0;

        if ((e1.getT() == e2.getT()) && (e1.getId() > e2.getId())) {
            r = 1;
        }
        if ((e1.getT() == e2.getT()) && (e1.getId() < e2.getId())) {
            r = -1;
        }
        if ((e1.getT() == e2.getT()) && (e1.getId() == e2.getId())) {
            r = 0;
        }
        if (e1.getT() > e2.getT()) {
            r = 1;
        }
        if (e1.getT() < e2.getT()) {
            r = -1;
        }

        return r;
    }

}
