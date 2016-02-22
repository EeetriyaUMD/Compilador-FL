package Codes_FL_LAII.Generation_Code;

import Codes_FL_LAII.Analyzer_FL_LAII;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Generation_Code_FL_LAII extends Analyzer_FL_LAII {

    private final StringBuilder _DataUploaded;
    private static String sintacticLexico;
    private boolean resultConfirmed;
    private File file;
    private final String name;
    private String operation;
    private String message;
    private final ArrayList<Integer> number = new ArrayList<Integer>();

    /**
     *
     * @param name
     */
    @SuppressWarnings("Convert2Diamond")
    public Generation_Code_FL_LAII(String name) {

        this.file = new File(name);
        this.name = name;
        this._DataUploaded = new StringBuilder();
        this.sintacticLexico = "";
        this.resultConfirmed = true;
        this.operation = "";
        this.message = "";
        this.number.clear();

    }

    /**
     *
     */
    public Generation_Code_FL_LAII() {

        this.file = new File("default");
        this.name = "default";
        this._DataUploaded = new StringBuilder();
        this.sintacticLexico = "";
        this.resultConfirmed = true;
        this.operation = "";
        this.message = "";

    }

    /**
     *
     * @param text
     * @return
     */
    @Override
    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")
    public boolean sintacticAnalyzer(String text) {

        StringTokenizer stringToke = new StringTokenizer(text, "\n");

        while (stringToke.hasMoreTokens()) {

            String commands = stringToke.nextToken();

            Pattern pattern = Pattern.compile(
                    grammarVariableDeclarationTWO + "|"
                    + grammarShowDate + "|"
                    + grammarAllocationDataTWO
            );

            Matcher matcher = pattern.matcher(commands);

            if (matcher.find()) {

                if (matcher.group().indexOf("=") != -1) {

                    try {

                        number.add(Integer.parseInt(matcher.group().substring(matcher.group().indexOf("=") + 1, matcher.group().indexOf(";"))));

                    } catch (NumberFormatException e) {

                    }

                }

                if (matcher.group().indexOf("aprin") != -1) {

                    message = matcher.group().substring(matcher.group().indexOf("(") + 1, matcher.group().indexOf(",")).replaceAll("'", "");
                    
                }

                if (matcher.group().indexOf("+") != -1) {

                    operation = matcher.group().substring(matcher.group().indexOf("+"), matcher.group().indexOf("+") + 1).replaceAll(" ", "");

                }
                
                if (matcher.group().indexOf("-") != -1) {

                    operation = matcher.group().substring(matcher.group().indexOf("-"), matcher.group().indexOf("-") + 1).replaceAll(" ", "");

                }
                
                if (matcher.group().indexOf("*") != -1) {

                    operation = matcher.group().substring(matcher.group().indexOf("*"), matcher.group().indexOf("*") + 1).replaceAll(" ", "");

                }
                
                if (matcher.group().indexOf("/") != -1) {

                    operation = matcher.group().substring(matcher.group().indexOf("/"), matcher.group().indexOf("/") + 1).replaceAll(" ", "");

                }

            }

        }

        return resultConfirmed;

    }

    /**
     *
     */
    @SuppressWarnings("override")
    public void Run() {

        setPath(name);
        ensSuma(number.get(0), number.get(1), message, operation);
        crearBat();
        ejecutarBat();

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
     * @param av
     * @param bv
     * @param res
     * @param op
     */
    public void ensSuma(int av, int bv, String res, String op) {

        String a = Integer.toHexString(av);
        String b = Integer.toHexString(bv);

        FileWriter fichero = null;
        try {

            fichero = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fichero);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(".model small");
            pw.println(".stack");
            pw.println(".data");
            pw.println("mensaje db '" + res + ":','$'");
            pw.println(".code");
            pw.println("main proc");
            pw.println("mov ax,seg mensaje");
            pw.println("mov ds,ax");
            pw.println("mov ah,09");
            pw.println("lea dx,mensaje");
            pw.println("int 21h");

            pw.println("MOV AL," + a.toUpperCase() + "\n");
            pw.println("MOV BL," + b.toUpperCase() + "\n");

            if ("+".equals(op)) {
                pw.println("ADD AL,BL\n");
            }
            if ("-".equals(op)) {
                pw.println("SUB AL,BL\n");
            }
            if ("*".equals(op)) {
                pw.println("MUL BL\n");
            }
            if ("/".equals(op)) {
                pw.println("XOR AX,AX\n");
                pw.println("MOV AL," + b.toUpperCase() + "\n");
                pw.println("MOV BL,AL\n");
                pw.println("MOV AL," + a.toUpperCase() + "\n");
                pw.println("DIV BL\n");
                pw.println("MOV BL,AL\n");

            }

            pw.println("mov dl,al");
            pw.println("add dl,48");
            pw.println("mov ah,02");
            pw.println("int 21h");
            pw.println("mov ax,4c00h");
            pw.println("int 21h");
            pw.println("main endp");
            pw.println("end main");

            pw.close();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    @SuppressWarnings("MalformedRegexp")
    public void crearBat() {

        File f;
        FileWriter fichero = null;
        try {

            f = new File(getPath().replace(name + ".asm", name + ".bat"));
            f.delete();
            fichero = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fichero);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("cd " + getPath().replace(name + ".asm", ""));
            pw.println("tasm suma.asm");
            pw.println("tlink suma.obj");
            pw.println("suma");
            bw.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    public void ejecutarBat() {
        Runtime ejecutar = Runtime.getRuntime();
        try {
            ejecutar.exec("cmd.exe /k start " + getPath().replace(name + ".asm", name + ".bat"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param name
     */
    public void setPath(String name) {

        file = new File(getPath().replace(name, "/Files/" + name + ".asm"));

    }

    /**
     *
     * @return
     */
    public String getPath() {

        return file.getAbsolutePath();

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Generation_Code_FL_LAII{" + '}';

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

}
