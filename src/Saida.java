
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Classe responsavel por criar os arquivos log de saida e gerar plot
 *
 * @author gvpm
 */
public class Saida {

    Estruturas estrutura;

    /**
     * Metodo Construtor
     * @param estrutura
     */
    public Saida(Estruturas estrutura) {
        this.estrutura = estrutura;
    }

    /**
     * Metodo responsavel por criar um arquivo de saida com o log
     */
    public void printLog() {

        FileWriter arq = null;
        PrintWriter gravarArq;
        try {
            arq = new FileWriter(estrutura.getConfig().getSaida());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo de saída.");
            estrutura.setErro(3);

        }
        gravarArq = new PrintWriter(arq);
        while (!estrutura.getLog().isEmpty()) {

            gravarArq.println(estrutura.getLog().get(0).toString());
            gravarArq.flush();

            estrutura.getLog().remove(0);

        }
        gravarArq.close();

    }

    /**
     * Metodo que gera e executa o plot
     */
    public void geraPlot() {
        File file = new File("plot.sh");

        try {
            Runtime.getRuntime().exec("chmod +x" + file.getAbsolutePath());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o Plot.\n\nVerifique se o gnuplot está instalado.\nVerifique se os arquivos 'plot.gnu' e 'plot.sh' estão na pasta.");
            estrutura.setErro(4);

        }
        try {
            Runtime.getRuntime().exec(file.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o Plot.\n\nVerifique se o gnuplot está instalado.\nVerifique se os arquivos 'plot.gnu' e 'plot.sh' estão na pasta.");
            estrutura.setErro(4);
        }

    }

}
