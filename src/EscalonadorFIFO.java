
/**
 * Classe que modela o escalonador especifico com a politica de escalonamento
 * FIFO
 *
 * @author gvpm
 */
public class EscalonadorFIFO extends Escalonador {

    /**
     *
     * @param e estrutura onde o escalonador vai atuar
     */
    public EscalonadorFIFO(Estruturas e) {
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
     * caso nao, remove o proximo processo 'Pronto'
     * @return o proximo processo
     */
    public Processo proximoProcesso() {
        if (estrutura.isFilaProntosEmpty() || (estrutura.isCpuBusy())) {
            return null;
        } //if(estrutura.filaProntosIsEmpty())return null;
        else {
            Processo r = estrutura.removeProximoPronto();

            return r;
        }
    }

}
