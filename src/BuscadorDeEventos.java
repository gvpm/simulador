
import javax.swing.JOptionPane;

/**
 * Classe responsavel por pegar o proximo evento da lista de eventos e executar
 *
 * @author gvpm
 */
public class BuscadorDeEventos {

    private final Estruturas estrutura;

    /**
     *
     * Metodo Construtor
     * @param estrutura estrutura da simulacao
     */
    public BuscadorDeEventos(Estruturas estrutura) {
        this.estrutura = estrutura;
    }

    /**
     *  Remove o proximo evento da fila de estrutura e executa
     */
    public void run() {

        while (!estrutura.isFilaEventosEmpty()) {
            Evento ev = estrutura.removeProxEvento();
            ev.run();
        }
        if (estrutura.getErro() == 0 && estrutura.getConfig().getErro() == 0) {
            JOptionPane.showMessageDialog(null, "Simulação Finalizada\nArquivo 'output.txt' criado.");
        }

    }

}
