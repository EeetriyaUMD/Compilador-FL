package Interfaces_FL_LAII;

/**
 *
 * @author FL-AndruAnnohomy
 */
public interface Phases_Compiler_FL_LAII {

    /**
     *
     * @param text
     * @return
     */
    public boolean sintacticAnalyzer(String text);

    /**
     *
     * @param text
     * @return
     */
    public boolean semanticAnalyzer(String text);

    /**
     *
     * @param text
     * @return
     */
    public boolean lexicalAnalyzer(String text);
    
}
