
/**
 * Classe que modela um evento de termino de um processo
 *
 * @author gvpm
 */
public class TerminaEvt extends Evento {

    private final Processo p;

    /**
     * Metodo Construtor
     * @param t Tempo na simulacao
     * @param p Processo que vai terminar
     * @param e Estrutura usada na simulacao
     */
    public TerminaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 1;
    }

    /**
     * - Remove o processo da cpu - Cria o evento de escalonador para o tempo
     * atual - Ajusta alinha de log atual
     */
    @Override
    public void run() {
        estrutura.removeCPU();

        EscalonaEvt e = new EscalonaEvt(t, estrutura);
        estrutura.addEvento(e);
        estrutura.getLogAtual().setTempoSaida(t);
        estrutura.getLogAtual().setTermino(1);

    }

    /**
     * Funcao que retorna o agragado ao evento
     * @return processo agregado ao evento
     */
    @Override
    public Processo getP() {
        return p;
    }

}
