
import java.io.IOException;

/**
 * Classe de controle que implementa e executa o fluxo da simulacao
 *
 * @author gvpm
 */
public class Simulador {

    private Estruturas estrutura;

    /**
     *
     */
    public Simulador() {

    }

    /**
     * Cria a config - carrega a config - cria a base de estruturas - cria o
     * escalonador - - carrega input na base - cria o buscador de eventos - roda
     * o buscador de eventos - gera as saidas
     *
     * @throws IOException
     */
    public void run() throws IOException {
        Config config = new Config();
        config.loadConfig();
        if (config.getErro() == 0) {
            this.estrutura = new Estruturas(config);

            Carregador c = new Carregador(estrutura);
            c.run();

            int idEscalonador = estrutura.getConfig().getIdEscalonador();
            //Cria Factory
            EscalonadorFactory factory = new EscalonadorFactory(estrutura);
            //Cria Escalonador pedido na config e coloca na estrurura.
            estrutura.setEscalonador(factory.getEscalonador(idEscalonador));

            BuscadorDeEventos b = new BuscadorDeEventos(estrutura);
            b.run();

            Saida saida = new Saida(estrutura);
            saida.printLog();

            if (estrutura.getConfig().getPlot() == 1) {
                saida.geraPlot();
            }

        }

    }

}
