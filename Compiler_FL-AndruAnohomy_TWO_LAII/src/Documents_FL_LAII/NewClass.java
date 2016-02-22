package Documents_FL_LAII;

/**
 *
 * @author FL-AndruAnnohomy
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class NewClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String regex = "(\\d+) de (\\w+) de (\\d+)";
        Pattern patron = Pattern.compile(regex);

        String texto = "30 de Enero de 2015";
        Matcher emparejador = patron.matcher(texto);

        emparejador.find();

        String sustitucion = "$1-$2-$3";
        String resultado = emparejador.replaceAll(sustitucion);

        System.out.println("Resultado despues de la sustitucion: " + resultado);
    }

}
