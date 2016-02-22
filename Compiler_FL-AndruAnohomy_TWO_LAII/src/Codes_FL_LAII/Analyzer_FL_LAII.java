package Codes_FL_LAII;

import Interfaces_FL_LAII.Phases_Compiler_FL_LAII;

/**
 *
 * @author FL-AndruAnnohomy
 */
public abstract class Analyzer_FL_LAII extends Estructure_Semantic_Table_FL_LAII implements Phases_Compiler_FL_LAII {

    /**
     *
     */
    public Analyzer_FL_LAII() {
    }

    /**
     *
     * @param text
     * @return
     */
    public abstract String getText(String text);

    /**
     *
     */
    public abstract void Run();
    

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Sintactic_Analyzer_LAII{" + '}';

    }

}
