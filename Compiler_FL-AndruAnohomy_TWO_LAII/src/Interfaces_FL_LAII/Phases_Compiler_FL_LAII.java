package Interfaces_FL_LAII;

/**
 *
 * @author FL-AndruAnnohomy
 */
public interface Phases_Compiler_FL_LAII {

    public boolean sintacticAnalyzer(String text);

    public boolean semanticAnalyzer(String text);

    public boolean lexicalAnalyzer(String text);
    
}
