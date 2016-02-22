package Codes_FL_LAII.Phase_LexicalAnalyzer;

import Codes_FL_LAII.Analyzer_FL_LAII;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Lexical_Analyzer_FL_LAII extends Analyzer_FL_LAII {

    private final StringBuilder _DataUploaded;
    private static String analyzerLexico;
    private boolean resultConfirmed;

    /**
     *
     */
    @SuppressWarnings("static-access")
    public Lexical_Analyzer_FL_LAII() {

        this._DataUploaded = new StringBuilder();
        this.analyzerLexico = "";
        this.resultConfirmed = true;

    }

    /**
     *
     * @param text
     * @return
     */
    @SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "override"})
    public boolean lexicalAnalyzer(String text) {

        @SuppressWarnings("UnusedAssignment")
        int row = 0, token = 0, position = 0;
        StringTokenizer stringToke1 = new StringTokenizer(text, "\n");

        while (stringToke1.hasMoreTokens()) {

            row++;
            position = 0;
            String line = stringToke1.nextToken();
            StringTokenizer stringToke2 = new StringTokenizer(line, "#");

            while (stringToke2.hasMoreTokens()) {

                token++;
                position++;
                String commands = stringToke2.nextToken();

                Pattern pattern = Pattern.compile(
                        tokenMain + "|"
                        + tokenAprin + "|"
                        + tokenString + "|"
                        + tokenInt + "|"
                        + tokenShow + "|"
                        + tokenGet + "|"
                        + tokenMay + "|"
                        + tokenOnlineOrder + "|"
                        + tokenOperatorSum + "|"
                        + tokenOperatorSubtraction + "|"
                        + tokenOperatorMultiplication + "|"
                        + tokenOperatorDivision + "|"
                        + tokenOperatorLessThan + "|"
                        + tokenOperatorGreaterThan + "|"
                        + tokenOperatorEqual + "|"
                        + tokenOperatorColon + "|"
                        + tokenOperatorParenthesisLeft + "|"
                        + tokenOperatorParenthesisRight + "|"
                        + tokenOperatorBracesLeft + "|"
                        + tokenOperatorBracesRight + "|"
                        + tokenOperatorComa + "|"
                        + tokenOperatorParenthesisLeft + "|"
                        + tokenDigit + "|"
                        + tokenCharacterString + "|"
                        + tokenVariable
                );

                Matcher matcher = pattern.matcher(commands);
//matcher.end()
                if (matcher.find()) {

                    if (matcher.group().equals(commands.replaceAll(" ", ""))) {

                        _DataUploaded.append("Token # " + token + " \"" + matcher.group() + "\" Encontrado en la Posición # " + position + " En la Fila # " + row + "\n");

                    } else {

                        if (matcher.group().indexOf("'") == -1 && matcher.group().lastIndexOf("'") == -1) {

                            guiWindows.setResults("<font color=\"red\">Error Lexico en la linea # " + row + ".</font><br>");
                            _DataUploaded.append("Error # " + token + " \"" + matcher.group() + "\" Encontrado en la Posición # " + position + " En la Fila # " + row + "\n");
                            resultConfirmed = false;
                            break;

                        } else {

                            _DataUploaded.append("Token # " + token + " \"" + matcher.group() + "\" Encontrado en la Posición # " + position + " En la Fila # " + row + "\n");

                        }

                    }

                } else {

                    try {

                        _DataUploaded.append("Error # " + token + " \"" + matcher.group() + "\" Encontrado en la Posición # " + position + " En la Fila # " + row + "\n");
                        guiWindows.setResults("<font color=\"red\">Error Lexico en la linea # " + row + ".</font><br>");
                        resultConfirmed = false;
                        break;

                    } catch (IllegalStateException ex) {

                        if (commands.indexOf(" ") == -1) {

                            guiWindows.setResults("<font color=\"red\">Error Lexico en la linea # " + row + ". Caracter !!NO!! Reconocido.</font><br>");

                        } else {

                            System.out.println("datos ignorados\n");

                        }

                    }

                }

            }

        }

        analyzerLexico = "Lista de Tokens:\n\n" + _DataUploaded.toString();

        if (resultConfirmed) {

            guiWindows.setResults("<font color=\"green\">Analisis Lexico Realizado con Exito.</font><br>");

        } else {

            guiWindows.setResults("<font color=\"red\">Analisis Lexico !!NO!! Realizado con Exito.</font><br>");

        }

        return resultConfirmed;

    }

    /**
     *
     * @param text
     * @return
     */
    @SuppressWarnings({"ResultOfMethodCallIgnored", "override"})
    public String getText(String text) {

        String line = "", lineString;
        StringTokenizer stringToke1 = new StringTokenizer(text, "\n");

        while (stringToke1.hasMoreTokens()) {

            lineString = stringToke1.nextToken().toString();

            if (lineString.indexOf("'") == -1 && lineString.lastIndexOf("'") == -1) {

                line += lineString.
                        replaceAll(tokenMain, "#" + tokenMain + "#").
                        replaceAll(tokenAprin, "#" + tokenAprin + "#").
                        replaceAll(tokenString, "#" + tokenString + "#").
                        replaceAll(tokenInt, "#" + tokenInt + "#").
                        replaceAll(tokenShow, "#" + tokenShow + "#").
                        replaceAll(tokenGet, "#" + tokenGet + "#").
                        replaceAll(tokenMay, "#" + tokenMay + "#").
                        replaceAll(tokenOnlineOrder, "#" + tokenOnlineOrder + "#").
                        replaceAll(tokenOperatorSum, "#" + tokenOperatorSum + "#").
                        replaceAll(tokenOperatorSubtraction, "#" + tokenOperatorSubtraction + "#").
                        replaceAll(tokenOperatorMultiplication, "#" + tokenOperatorMultiplication + "#").
                        replaceAll(tokenOperatorDivision, "#" + tokenOperatorDivision + "#").
                        replaceAll(tokenOperatorLessThan, "#" + tokenOperatorLessThan + "#").
                        replaceAll(tokenOperatorGreaterThan, "#" + tokenOperatorGreaterThan + "#").
                        replaceAll(tokenOperatorEqual, "#" + tokenOperatorEqual + "#").
                        replaceAll(tokenOperatorParenthesisLeft, "#" + tokenOperatorParenthesisLeft + "#").
                        replaceAll(tokenOperatorParenthesisRight, "#" + tokenOperatorParenthesisRight + "#").
                        replaceAll(tokenOperatorBracesLeft, "#" + tokenOperatorBracesLeft + "#").
                        replaceAll(tokenOperatorBracesRight, "#" + tokenOperatorBracesRight + "#").
                        replaceAll(tokenOperatorComa, "#" + tokenOperatorComa + "#").
                        replaceAll(tokenOperatorColon, "#" + tokenOperatorColon + "#")
                        + "\n";

            } else {

                line += lineString.
                        replaceAll(tokenMain, "#" + tokenMain + "#").
                        replaceAll(tokenAprin, "#" + tokenAprin + "#").
                        replaceAll(tokenString, "#" + tokenString + "#").
                        replaceAll(tokenInt, "#" + tokenInt + "#").
                        replaceAll(tokenShow, "#" + tokenShow + "#").
                        replaceAll(tokenGet, "#" + tokenGet + "#").
                        replaceAll(tokenMay, "#" + tokenMay + "#").
                        replaceAll(tokenOnlineOrder, "#" + tokenOnlineOrder + "#").
                        replaceAll(tokenOperatorSum, "#" + tokenOperatorSum + "#").
                        replaceAll(tokenOperatorSubtraction, "#" + tokenOperatorSubtraction + "#").
                        replaceAll(tokenOperatorMultiplication, "#" + tokenOperatorMultiplication + "#").
                        replaceAll(tokenOperatorDivision, "#" + tokenOperatorDivision + "#").
                        replaceAll(tokenOperatorLessThan, "#" + tokenOperatorLessThan + "#").
                        replaceAll(tokenOperatorGreaterThan, "#" + tokenOperatorGreaterThan + "#").
                        replaceAll(tokenOperatorEqual, "#" + tokenOperatorEqual + "#").
                        replaceAll(tokenOperatorParenthesisLeft, "#" + tokenOperatorParenthesisLeft + "#").
                        replaceAll(tokenOperatorParenthesisRight, "#" + tokenOperatorParenthesisRight + "#").
                        replaceAll(tokenOperatorBracesLeft, "#" + tokenOperatorBracesLeft + "#").
                        replaceAll(tokenOperatorBracesRight, "#" + tokenOperatorBracesRight + "#").
                        replaceAll(tokenOperatorComa, "#" + tokenOperatorComa + "#")
                        + "\n";

            }

        }

        return line;

    }

    /**
     *
     * @return
     */
    public static String getAnalyzerLexico() {

        return analyzerLexico;

    }

    /**
     *
     * @param analyzerLexico
     */
    @SuppressWarnings("static-access")
    public void setAnalyzerLexico(String analyzerLexico) {

        this.analyzerLexico = analyzerLexico;

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Lexical_Analyzer_FL_LAII{" + '}';

    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    public boolean sintacticAnalyzer(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     */
    @Override
    public void Run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
