
/**
 * Classe que modela o escalonador especifico com a politica de escalonamento
 * Shortest Job First
 *
 * @author gvpm
 */
public class EscalonadorSJF extends Escalonador {

    /**
     * Metodo Construtor
     * @param e estrutura onde o escalonador vai atuar
     */
    public EscalonadorSJF(Estruturas e) {
        super(e);
    }

    @Override
    /**
     * Metodo esvazia a fila do escalonador colocando os processos na fila de
     * 'Prontos'
     */
    public void esvaziaFilaEscalonador() {

        while (!estrutura.isFilaEscalonadorEmpty()) {

            estrutura.addFilaProntos(estrutura.removeProximoFilaEscalonador());

        }

    }

    @Override
    /**
     * Metodo checa se a fila de 'Prontos' esta vazia ou se o CPU esta ocupado
     * caso nao, remove o processo com menor tempo restante
     */
    public Processo proximoProcesso() {
        if (estrutura.isFilaProntosEmpty() || (estrutura.isCpuBusy())) {
            return null;
        } else {

            Processo r = estrutura.removeMenorTempoRestantePronto();
            return r;
        }
    }

}
