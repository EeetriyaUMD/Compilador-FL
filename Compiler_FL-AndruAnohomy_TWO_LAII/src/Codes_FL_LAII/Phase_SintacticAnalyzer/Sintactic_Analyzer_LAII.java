package Codes_FL_LAII.Phase_SintacticAnalyzer;

import Codes_FL_LAII.Analyzer_FL_LAII;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Sintactic_Analyzer_LAII extends Analyzer_FL_LAII {

    private final StringBuilder _DataUploaded;
    private static String sintacticLexico;
    private boolean resultConfirmed;

    /**
     *
     */
    @SuppressWarnings("static-access")
    public Sintactic_Analyzer_LAII() {

        this._DataUploaded = new StringBuilder();
        this.sintacticLexico = "";
        this.resultConfirmed = true;

    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")
    public boolean sintacticAnalyzer(String text) {

        int row = 0, grammar = 0;
        StringTokenizer stringToke = new StringTokenizer(text, "\n");
        System.out.println(text);
        while (stringToke.hasMoreTokens()) {

            row++;
            String commands = stringToke.nextToken();

            Pattern pattern = Pattern.compile(
                    grammarStart + "|"
                    + grammarVariableDeclarationONE + "|"
                    + grammarVariableDeclarationTWO + "|"
                    + grammarAllocationDataONE + "|"
                    + grammarAllocationDataTWO + "|"
                    + grammarAllocationDataTREE + "|"
                    + grammarIncrementingDecrementing + "|"
                    + grammarShowDate + "|"
                    + grammarShowMessage + "|"
                    + grammarCycleFOR + "|"
                    + grammarFinishFOR + "|"
                    + grammarFinish
            );

            Matcher matcher = pattern.matcher(commands);

            if (matcher.find()) {

                if (matcher.group().equals(commands)) {

                    grammar++;
                    _DataUploaded.append("Gramatica # " + grammar + " \"" + matcher.group() + "\" Encontrado en la Linea # " + row + "\n");

                } else {

                    guiWindows.setResults("<font color=\"red\">Error Sintactico en la linea # " + row + ".</font><br>");
                    resultConfirmed = false;
                    break;

                }

            } else {

                guiWindows.setResults("<font color=\"red\">Error Sintactico en la linea # " + row + ".</font><br>");
                resultConfirmed = false;
                break;

            }

        }

        sintacticLexico = "Lista de Grammars:\n\n" + _DataUploaded.toString();

        if (resultConfirmed) {

            guiWindows.setResults("<font color=\"blue\">Analisis Sintactico Realizado con Exito.</font><br>");

        } else {

            guiWindows.setResults("<font color=\"red\">Analisis Sintactico !!NO!! Realizado con Exito.</font><br>");

        }

        return resultConfirmed;

    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    public String getText(String text) {

        String line = "";
        StringTokenizer stringToke1 = new StringTokenizer(text, "\n");

        while (stringToke1.hasMoreTokens()) {

            line += stringToke1.nextToken().toString().
                    replaceAll(" ", "")
                    + "\n";

        }

        return line;

    }

    /**
     *
     * @return
     */
    public static String getSintacticLexico() {

        return sintacticLexico;

    }

    /**
     *
     * @param sintacticLexico
     */
    @SuppressWarnings("static-access")
    public void setSintacticLexico(String sintacticLexico) {

        this.sintacticLexico = sintacticLexico;

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Sintactic_Analyzer_LAII{" + '}';

    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    public boolean semanticAnalyzer(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    public boolean lexicalAnalyzer(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void Run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
