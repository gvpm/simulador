
/**
 * Classe que modela o Processo
 *
 * @author gvpm
 */
public class Processo {

    private final int id;
    private final int tempoChegada;
    private final int tempoExec;
    private int tempoRestante;

    /**
     * Metodo Construtor
     * @param id
     * @param tempoChegada
     * @param tempoExec
     */
    public Processo(int id, int tempoChegada, int tempoExec) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExec = tempoExec;
        this.tempoRestante = tempoExec;
    }

    /**
     *
     * @return id do processo
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return tempo de chegada do processo
     */
    public int getTempoChegada() {
        return tempoChegada;
    }

    /**
     *
     * @return tempo de execucao do processo
     */
    public int getTempoExec() {
        return tempoExec;
    }

    /**
     *
     * @return tempo restante do processo
     */
    public int getTempoRestante() {
        return tempoRestante;
    }

    /**
     * Modifica o tempo restante do processo
     * @param tempoRestante novo tempo restante
     */
    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

}
