
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Classe chave da simulacao, contem todas as estruturas e metodos necessarios
 * para a execucao da simulacao, o escalonador a ser utilizado e a config
 * carregada.
 *
 * @author gvpm
 */
public class Estruturas {

    private final List<Evento> filaEventos;
    private final List<Processo> filaEscalonador;
    private final List<Processo> filaProntos;
    private Processo cpu;
    private final List<LogLine> log;
    private final Config config;
    private int erro;
    private Escalonador escalonador;

    /**
     * Metodo Construtor
     *
     * @param c configuracao a ser utilizada na simulacao
     */
    public Estruturas(Config c) {

        this.filaEventos = new LinkedList<>();
        this.filaEscalonador = new LinkedList<>();
        this.filaProntos = new LinkedList<>();
        this.log = new LinkedList<>();
        this.cpu = null;
        this.config = c;
        this.erro = 0;

    }

    /**
     *
     * @return
     */
    public List<LogLine> getLog() {
        return log;
    }

    /**
     *
     * @return
     */
    public int getErro() {
        return erro;
    }

    /**
     *
     * @return
     */
    public List<Processo> getFilaProntos() {
        return filaProntos;
    }

    /**
     *
     * @param e
     */
    public void setEscalonador(Escalonador e) {
        this.escalonador = e;
    }

    /**
     *
     * @return
     */
    public Escalonador getEscalonador() {
        return escalonador;
    }

    /**
     *
     * @param erro
     */
    public void setErro(int erro) {
        this.erro = erro;
    }

    /**
     * Adifiona um evento novo a estrutura - caso seja um evento de escalonador
     * verifica se ja nao existe um igual - ordena a fila de acordo com o tempo
     * e a prioridade de cada tipo de evento
     *
     * @param e evento a ser adicionado
     */
    public void addEvento(Evento e) {
        ListIterator li = filaEventos.listIterator();
        int cont = 0;

        if (e.getId() == 3) {

            while (li.hasNext()) {
                Evento ee = (Evento) li.next();
                if ((ee.getId() == 3) && (ee.getT() == e.getT())) {
                    cont = 1;
                }

            }
        }

        if (cont == 0) {
            filaEventos.add(e);
        }
        //if(cont==1)System.out.println("Ja tem");

        filaEventos.sort(e);
    }

    /**
     *
     * @return evento removido
     */
    public Evento removeProxEvento() {

        return filaEventos.remove(0);

    }

    /**
     * Metodo para retirar um evento de termino de determinado processo
     *
     * @param p processo do evento termina que deseja se retirar
     * @return evento de termino do processo retirado
     */
    public Evento removeEventoTermina(Processo p) {
        ListIterator li = filaEventos.listIterator();
        Evento ee = null;
        while (li.hasNext()) {
            ee = (Evento) li.next();
            if ((ee.getId() == 1) && (ee.getP().equals(p))) {
                filaEventos.remove(ee);
                return ee;
            }

        }

        return ee;
    }

    /**
     *
     * @return true: fila vazia; false: fila nao vazia
     */
    public boolean isFilaEventosEmpty() {
        return filaEventos.isEmpty();

    }

    /**
     *
     * @param p processo a ser adicionado
     */
    public void addFilaEscalonador(Processo p) {

        filaEscalonador.add(p);
    }

    /**
     *
     * @return processo removido
     */
    public Processo removeProximoFilaEscalonador() {
        return filaEscalonador.remove(0);

    }

    /**
     *
     * @return false: fila escalonador nao vazia true:fila escalonador vazia
     */
    public boolean isFilaEscalonadorEmpty() {
        return filaEscalonador.isEmpty();

    }

    /**
     *
     * @param p processo a ser adicionado
     */
    public void addFilaProntos(Processo p) {
        filaProntos.add(p);
    }

    /**
     *
     * @return proximo processo da fila de prontos
     */
    public Processo removeProximoPronto() {
        return filaProntos.remove(0);

    }

    /**
     * Metodo para retirar o processo com menos tempo restante da lista de
     * prontos
     *
     * @return processo com menor tempo restante da lista
     */
    public Processo removeMenorTempoRestantePronto() {
        int tamanho = filaProntos.size();
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < tamanho; i++) {
            if (i == 0) {
                min = filaProntos.get(i).getTempoRestante();
                minIndex = 0;
            } else if (filaProntos.get(i).getTempoRestante() < min) {
                min = filaProntos.get(i).getTempoRestante();
                minIndex = i;

            }

        }

        return filaProntos.remove(minIndex);

    }

    /**
     *
     * @return true: fila de prontos vazia false: fila de prontos nao vazia
     */
    public boolean isFilaProntosEmpty() {
        return filaProntos.isEmpty();

    }

    /**
     *
     * @param p processo a ser adicionado
     */
    void addCpu(Processo p) {
        this.cpu = p;
    }

    /**
     *
     * @return o processo removido
     */
    public Processo removeCPU() {
        Processo p = cpu;
        cpu = null;
        return p;
    }

    /**
     *
     * @return o processo da cpu
     */
    public Processo cpuCheck() {
        Processo p = cpu;
        return p;
    }

    /**
     *
     * @return true: cpu ocupada false: cpu vazia
     */
    public boolean isCpuBusy() {
        return cpu != null;
    }

    /**
     *
     * @return configuracao da simulacao
     */
    public Config getConfig() {
        return config;
    }

    /**
     *
     * @return log mais atual na lista de logs
     */
    public LogLine getLogAtual() {

        return log.get(log.size() - 1);

    }

    /**
     *
     * @param l linha de log a ser adicionada
     */
    public void addLogLine(LogLine l) {
        log.add(l);

    }

}
