package Codes_FL_LAII;

/**   
 *
 * @author FL-AndruAnnohomy
 */
public class Estructure_Semantic_Table_FL_LAII extends Grammars_Table_FL_LAII {

    @SuppressWarnings("FieldMayBeFinal")
    private String estructureVariable = "(" + grammarVariableDeclarationONE + "|" + grammarVariableDeclarationTWO + ")";
    @SuppressWarnings("FieldMayBeFinal")
    private String estructureAllocationData = "(" + grammarAllocationDataONE +    "|" + grammarAllocationDataTWO + "|" + grammarAllocationDataTREE + ")";
    @SuppressWarnings("FieldMayBeFinal")
    private String estructureShowMessage = "(" + grammarShowMessage + "|(" + grammarShowMessage + ")*)";

    /**
     *
     */
    protected String estructureSimpleONE = grammarStart + grammarFinish;

    /**
     *
     */
    protected String estructureSimpleTWO = grammarStart + estructureShowMessage + grammarFinish;

    /**
     *
     */
    protected String estructureSimpleTREE = grammarStart + "(" + estructureShowMessage + "|" + estructureVariable + ")*" + grammarFinish;

    /**
     *
     */
    protected String estructureSimpleFOUR = grammarStart + "(" + estructureShowMessage + "|" + estructureVariable + "|" + estructureAllocationData + ")*" + grammarFinish;

    /**
     *
     */
    protected String estructureSimpleFIVE = grammarStart + "(" + estructureShowMessage + "|" + estructureVariable + "|" + estructureAllocationData + "|" + grammarShowDate + ")*" + grammarFinish;

    /**
     *
     */
    protected String estructureSimpleSIX = grammarStart + "(" + estructureShowMessage + "|" + estructureVariable + "|" + estructureAllocationData + "|" + grammarShowDate + "|" + grammarIncrementingDecrementing + "|" + grammarCycleFOR + "|" + grammarFinishFOR + ")*" + grammarFinish;

//############################################################################################################################################################
    
    /**
     *
     */
        
    protected String grammarErrorVariableInt = tokenInt + tokenVariable + tokenOperatorEqual + tokenCharacterString;

    /**
     *
     */
    protected String grammarErrorVariableString = tokenString + tokenVariable + tokenOperatorEqual + tokenDigit;

    /**
     *
     */
    protected String grammarErrorNoDeclarada = "((" + grammarShowMessage + ")|(" + grammarVariableDeclarationONE + ")|(" + grammarVariableDeclarationTWO + "))+(((" + grammarShowMessage + ")|(" + estructureAllocationData + ")|(" + grammarShowDate + ")|(" + grammarIncrementingDecrementing + ")|(" + grammarCycleFOR + ")|(" + grammarFinishFOR + "))*)";

    /**
     *
     */
    protected String grammarErrorOperationUNO = tokenVariable + tokenOperatorEqual + "(" + tokenVariable + "|" + tokenDigit + ")" + typeOperation + tokenCharacterString + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarErrorOperationTWO = tokenVariable + tokenOperatorEqual + tokenCharacterString + typeOperation +  "(" + tokenVariable + "|" + tokenDigit + ")"  + tokenOnlineOrder;

    /**
     *
     */
    public Estructure_Semantic_Table_FL_LAII() {
    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Estructure_Semantic_Table_FL_LAII{" + '}';

    }

}
