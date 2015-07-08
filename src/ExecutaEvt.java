
/**
 * Classe que modela o evento de execucao de um processo
 *
 * @author gvpm
 */
public class ExecutaEvt extends Evento {

    private final Processo p;

    /**
     * Metodo Construtor
     * @param t tempo na simulacao
     * @param p processo a ser executado
     * @param e estrutura da simulacao
     */
    public ExecutaEvt(int t, Processo p, Estruturas e) {
        this.t = t;
        this.p = p;
        this.estrutura = e;
        this.id = 4;
    }

    /**
     * Verifica se existe um processo na cpu (Caso exista): -Remove o evento de
     * termino desse processo da cpu -Altera seu tempo restante -Adiciona ele na
     * fila do escalonador -Ajusta o log atual com o tempo de saida e o
     * indicador de termino 0 (Independente da existencia de um processo na
     * cpu): -Adiciona o processo do evento na cpu -Cria uma nova linha de log
     * -Cria um evento de termino para o novo processo
     *
     */
    @Override
    public void run() {

        Processo p2 = estrutura.cpuCheck();
        if (p2 != null) {

            Evento e2 = estrutura.removeEventoTermina(p2);
            int tRestante = e2.getT() - t;
            p2.setTempoRestante(tRestante);
            estrutura.addFilaEscalonador(p2);
            estrutura.getLogAtual().setTempoSaida(t);
            estrutura.getLogAtual().setTermino(0);

        }

        estrutura.addCpu(p);
        LogLine l = new LogLine(t, p.getId());
        estrutura.addLogLine(l);
        int tExec;
        //-1 No tempo resrante inicial era errado, Tempo exec foi usado
        //if (p.getTempoRestante() == -1) {
        //    tExec = p.getTempoExec();
        //} else {
        tExec = p.getTempoRestante();
        //}

        TerminaEvt te = new TerminaEvt(t + tExec, p, estrutura);
        estrutura.addEvento(te);

    }

}
