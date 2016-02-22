package Codes_FL_LAII.Phase_SemanticAnalyzer;

import Codes_FL_LAII.Analyzer_FL_LAII;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Semantic_Analyzer_FL_LAII extends Analyzer_FL_LAII {

    private String semaanticLexico;
    private Pattern pattern;
    private Matcher matcher;
    private String commands;
    private String commands1;
    private String commands2;
    private String commands3;
    private String commands4;
    private String commands5;
    private String grammarRemplace = "(\\S+)\\{(\\S+)\\}";
    private boolean a, b, c, d, e;
    private final ArrayList<String> list1;
    private String list2;

    /**
     *
     */
    public Semantic_Analyzer_FL_LAII() {

        this.semaanticLexico = "";
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.list1 = new ArrayList<String>();
        this.list2 = "";

    }

    /**
     *
     * @param text
     * @return
     */
    @SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "override"})
    public boolean semanticAnalyzer(String text) {

        int row = 0;
        StringTokenizer stringToke1 = new StringTokenizer(text, "\n");

        while (stringToke1.hasMoreTokens()) {

            row++;
            commands = stringToke1.nextToken();
            pattern = Pattern.compile(
                    estructureSimpleONE + "|"
                    + estructureSimpleTWO + "|"
                    + estructureSimpleTREE + "|"
                    + estructureSimpleFOUR + "|"
                    + estructureSimpleFIVE + "|"
                    + estructureSimpleSIX
            );

            matcher = pattern.matcher(commands);

            if (matcher.find()) {

                if (matcher.group().equals(commands)) {

                    a = true;

                } else {

                    guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! Realizado con Exito. Devido a que una Sentencia esta Fuera del main.</font><br>");
                    a = false;
                    break;

                }

            } else {

                guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! Realizado con Exito. Devido a que una Sentencia esta Fuera del main.</font><br>");
                a = false;
                break;

            }

//########################################################################################################################################################
            pattern = Pattern.compile(grammarRemplace);
            matcher = pattern.matcher(commands);
            matcher.find();

            String sustitucion = "$2";
            commands1 = matcher.replaceAll(sustitucion).replaceAll(";", ";\n");
            commands2 = matcher.replaceAll(sustitucion);
            commands3 = matcher.replaceAll(sustitucion).replaceAll(";", ";\n");
            commands4 = matcher.replaceAll(sustitucion).replaceAll(";", ";\n");
            commands5 = matcher.replaceAll(sustitucion).replaceAll(";", ";\n");

//########################################################################################################################################################
            StringTokenizer stringToke2 = new StringTokenizer(commands1, "\n");

            while (stringToke2.hasMoreTokens()) {

                row++;
                commands1 = stringToke2.nextToken();
                pattern = Pattern.compile(
                        grammarErrorVariableInt + "|"
                        + grammarErrorVariableString
                );

                matcher = pattern.matcher(commands1);

                if (matcher.find()) {

                    guiWindows.setResults("<font color=\"red\">Error Semantico en la linea # " + row + ". Valor !!!NO!!! Soportado por el Tipo de Variable.</font><br>");
                    b = false;
                    break;

                } else {

                    b = true;

                }

            }

//########################################################################################################################################################
            StringTokenizer stringToke3 = new StringTokenizer(commands2, "\n");

            while (stringToke3.hasMoreTokens()) {

                commands2 = stringToke3.nextToken();
                pattern = Pattern.compile(
                        grammarErrorNoDeclarada
                );

                matcher = pattern.matcher(commands2);

                if (matcher.find()) {

                    if (matcher.group().equals(commands2)) {

                        c = true;

                    } else {

                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! Existe un Orden en la Declarcion de las Variables.</font><br>");
                        c = false;
                        break;

                    }

                } else {

                    if (commands2.equals("main(){}")) {

                        this.a = true;
                        this.b = true;
                        this.c = true;
                        this.d = true;
                        this.e = true;

                    } else {

                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! Existe un Orden en la Declarcion de las Variables.</font><br>");
                        c = false;
                        break;

                    }

                }

            }

//########################################################################################################################################################
            row = 1;
            StringTokenizer stringToke4 = new StringTokenizer(commands3, "\n");

            while (stringToke4.hasMoreTokens()) {

                row++;
                commands3 = stringToke4.nextToken();
                pattern = Pattern.compile(
                        grammarErrorOperationUNO + "|"
                        + grammarErrorOperationTWO
                );

                matcher = pattern.matcher(commands3);

                if (matcher.find()) {

                    guiWindows.setResults("<font color=\"red\">Error Semantico en la linea # " + row + ". Deseas Realizar una Operacion con una Cadena.</font><br>");
                    d = false;
                    break;

                } else {

                    d = true;

                }

            }

//########################################################################################################################################################
            row = 1;
            StringTokenizer stringToke5 = new StringTokenizer(commands4, "\n");

            while (stringToke5.hasMoreTokens()) {

                row++;
                commands4 = stringToke5.nextToken();
                pattern = Pattern.compile(
                        grammarVariableDeclarationONE + "|"
                        + grammarVariableDeclarationTWO
                );

                matcher = pattern.matcher(commands4);

                if (matcher.find()) {

                    if (matcher.group().indexOf("=") != -1) {

                        if (matcher.group().indexOf("string") != -1) {

                            if (this.list1.indexOf(matcher.group().substring(6, matcher.group().indexOf("="))) != -1) {

                                guiWindows.setResults("<font color=\"red\">Error Semantico Existe una Variable con el Mismo Nombre. Linea # " + row + "</font><br>");
                                e = false;
                                break;

                            } else {

                                this.list1.add(matcher.group().substring(6, matcher.group().indexOf("=")));
                                e = true;

                            }

                        } else {

                            if (this.list1.indexOf(matcher.group().substring(3, matcher.group().indexOf("="))) != -1) {

                                guiWindows.setResults("<font color=\"red\">Error Semantico Existe una Variable con el Mismo Nombre. Linea # " + row + "</font><br>");
                                e = false;
                                break;

                            } else {

                                this.list1.add(matcher.group().substring(3, matcher.group().indexOf("=")));
                                e = true;

                            }

                        }

                    } else {

                        if (matcher.group().indexOf("string") != -1) {

                            if (this.list1.indexOf(matcher.group().substring(6, matcher.group().indexOf(";"))) != -1) {

                                guiWindows.setResults("<font color=\"red\">Error Semantico Existe una Variable con el Mismo Nombre. Linea # " + row + "</font><br>");
                                e = false;
                                break;

                            } else {

                                this.list1.add(matcher.group().substring(6, matcher.group().indexOf(";")));
                                e = true;

                            }

                        } else {

                            if (this.list1.indexOf(matcher.group().substring(3, matcher.group().indexOf(";"))) != -1) {

                                guiWindows.setResults("<font color=\"red\">Error Semantico Existe una Variable con el Mismo Nombre. Linea # " + row + "</font><br>");
                                e = false;
                                break;

                            } else {

                                this.list1.add(matcher.group().substring(3, matcher.group().indexOf(";")));
                                e = true;

                            }

                        }

                    }

                }

            }

            for (String x : this.list1) {

                this.list2 += x + ",";

            }

//########################################################################################################################################################
            row = 1;
            String variable;
            StringTokenizer stringToke6 = new StringTokenizer(commands5, "\n");

            while (stringToke6.hasMoreTokens()) {

                row++;
                commands5 = stringToke6.nextToken();
                pattern = Pattern.compile(
                        grammarAllocationDataONE + "|"
                        + grammarAllocationDataTWO + "|"
                        + grammarAllocationDataTREE + "|"
                        + grammarShowDate
                );

                matcher = pattern.matcher(commands5);

                if (matcher.find()) {

                    if (matcher.group().equals(commands5.replaceAll("int", "").replaceAll("string", ""))) {

                        if (matcher.group().indexOf("=") != -1) {

                            if (matcher.group().indexOf("+") != -1 || matcher.group().indexOf("-") != -1 || matcher.group().indexOf("*") != -1 || matcher.group().indexOf("/") != -1) {

                                variable = matcher.group().substring(0, matcher.group().indexOf("="));

                                if (this.list1.indexOf(variable) != -1) {

                                    this.list2 = this.list2.replaceAll(variable + ",", "");
                                    a = true;

                                } else {

                                    guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                    a = false;
                                    break;

                                }

                                if (matcher.group().indexOf("+") != -1) {

                                    variable = matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf("+"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                    variable = matcher.group().substring(matcher.group().indexOf("+") + 1, matcher.group().indexOf(";"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                }

                                if (matcher.group().indexOf("-") != -1) {

                                    variable = matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf("-"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                    variable = matcher.group().substring(matcher.group().indexOf("-") + 1, matcher.group().indexOf(";"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                }

                                if (matcher.group().indexOf("*") != -1) {

                                    variable = matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf("*"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                    variable = matcher.group().substring(matcher.group().indexOf("*") + 1, matcher.group().indexOf(";"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                }

                                if (matcher.group().indexOf("/") != -1) {

                                    variable = matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf("/"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                    variable = matcher.group().substring(matcher.group().indexOf("/") + 1, matcher.group().indexOf(";"));

                                    if (this.list1.indexOf(variable) != -1) {

                                        this.list2 = this.list2.replaceAll(variable + ",", "");
                                        a = true;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                }

                            } else {

                                variable = matcher.group().substring(0, matcher.group().indexOf("="));

                                if (this.list1.indexOf(variable) != -1) {

                                    this.list2 = this.list2.replaceAll(variable + ",", "");
                                    a = true;

                                } else {

                                    guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                    a = false;
                                    break;

                                }

                                variable = matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf(";"));

                                if (this.list1.indexOf(variable) != -1) {

                                    this.list2 = this.list2.replaceAll(variable + ",", "");
                                    a = true;

                                } else {

                                    if (variable.indexOf("'") != -1) {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se Soporta el Valor en la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    } else {

                                        guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                        a = false;
                                        break;

                                    }

                                }

                            }

                        } else {

                            variable = matcher.group().substring(matcher.group().indexOf(",") + 1, matcher.group().indexOf(")"));

                            if (this.list1.indexOf(variable) != -1) {

                                this.list2 = this.list2.replaceAll(variable + ",", "");
                                a = true;

                            } else {

                                guiWindows.setResults("<font color=\"red\">Error Semantico !!NO!! se a Declarado la Variable. Linea # " + row + "</font><br>");
                                a = false;
                                break;

                            }

                        }

                    }

                }

            }

//########################################################################################################################################################
            break;

        }

        if (a && b && c && d && e) {

            if (this.list2.equals("")) {

                guiWindows.setResults("<font color=\"orange\">Analisis Semantico Realizado con Exito.</font><br>");

            } else {

                guiWindows.setResults("<font color=\"orange\">Analisis Semantico Realizado con Exito. </font><font color=\"yellow\">Existe un Variable sin Utilizar. Con nombre: " + this.list2.substring(0, list2.indexOf(",")) + "</font><br>");

            }

        }

        return true;

    }

    /**
     *
     * @param text
     * @return
     */
    @SuppressWarnings("override")
    public String getText(String text) {

        String line = "";
        StringTokenizer stringToke1 = new StringTokenizer(text, "\n");

        while (stringToke1.hasMoreTokens()) {

            line += stringToke1.nextToken().toString().replaceAll(" ", "");

        }

        return line.replaceAll("\n", "");

    }

    /**
     *
     * @return
     */
    public String getSemanticLexico() {

        return semaanticLexico;

    }

    /**
     *
     * @param semaanticLexico
     */
    public void setSemanticLexico(String semaanticLexico) {

        this.semaanticLexico = semaanticLexico;

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Semantic_Analyzer_FL_LAII{" + '}';

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
