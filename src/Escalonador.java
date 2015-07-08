
/**
 * Classe que representa um escalonador abstrato
 *
 * @author gvpm
 */
public abstract class Escalonador {

    Estruturas estrutura;

    /**
     * Metodo Construtor
     * @param e estrutura a aplicar o escalonador
     */
    public Escalonador(Estruturas e) {

        this.estrutura = e;

    }

    /**
     * Executa os passos de um escalonamento: - Esvazia fila do escalonador -
     * Pega o proximo processo pronto e cria um evento de Executar para ele
     *
     * @param t tempo da simulacao para escalonar
     */
    public void escalona(int t) {

        esvaziaFilaEscalonador();

        Processo p = proximoProcesso();

        if (p != null) {

            ExecutaEvt e = new ExecutaEvt(t, p, estrutura);
            estrutura.addEvento(e);
        }

    }

    /**
     * Esvazia a fila do escalonador transferindo os processos para a fila de
     * prontos
     */
    public abstract void esvaziaFilaEscalonador();

    /**
     * Retorna o proximo processo de acordo com a politica implementada.
     * Politica preemptiva: retorna messo que cpu esteja ocupada. Politica nao
     * preemptiva: se cpu esta ocupada, nao retorna nada.
     *
     * @return Proximo processo de acordo com a politica usada
     */
    public abstract Processo proximoProcesso();

}
