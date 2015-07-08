
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Classe que modela uma configuração, e carrega seus parametros via arquivo
 * .txt
 *
 * @author gvpm
 */
public class Config {

    private String entrada;
    private String saida = "output.txt";
    private int idEscalonador, plot;
    private int erro = 0;

    /**
     *
     */
    public void Config() {

    }

    /**
     * Retorna o código de erro recebido pelo programa.
     *
     * @return código do erro.
     */
    public int getErro() {
        return erro;
    }

    /**
     * Seta o código do erro ocorrido.
     *
     * @param erro código do erro.
     */
    public void setErro(int erro) {
        this.erro = erro;
    }

    /**
     * Retorna o valor de plot determinado na config.
     *
     * @return 0 = não plotar o gráfico 1= plotar o gráfico.
     */
    public int getPlot() {
        return plot;
    }

    /**
     * Retorna o nome do arquivo de entrada recebido da config.
     *
     * @return nome do arquivo de entrada.
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * Retorna o nome do arquivo de saída "output.txt"
     *
     * @return nome do arquivo de saída.
     */
    public String getSaida() {
        return saida;
    }

    /**
     * Retorna o escalonador a ser utilizado determinado na config.
     *
     * @return código do escalonador a ser utilizado.
     */
    public int getIdEscalonador() {
        return idEscalonador;
    }

    /**
     * Carrega o arquivo "config.txt" na memória. Seta os parâmetros: entrada,
     * plot e escalonador.
     *
     * @throws IOException caso exista problema na leitura.
     */
    public void loadConfig() throws IOException {

        FileReader f;
        try {
            f = new FileReader("config.txt");
            BufferedReader b;
            b = new BufferedReader(f);
            boolean eof = false;

            while (!eof) {

                String line = b.readLine();
                if (line == null) {
                    eof = true;
                } else if (line.startsWith("input")) {
                    String[] sv = line.split(":");

                    entrada = sv[1];

                } else if (line.startsWith("output")) {
                    String[] sv = line.split(":");

                    saida = sv[1];

                } else if (line.startsWith("sched_type")) {
                    String[] sv = line.split(":");

                    idEscalonador = Integer.parseInt(sv[1]);

                } else if (line.startsWith("plot")) {
                    String[] sv = line.split(":");

                    plot = Integer.parseInt(sv[1]);

                }

            }
            b.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo 'config.txt' não encontrado.");
            setErro(5);

        }

    }

}
