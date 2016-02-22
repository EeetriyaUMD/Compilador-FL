package Codes_FL_LAII;

import java.util.logging.Logger;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class Grammars_Table_FL_LAII extends Simbol_Table_FL_LAII {

    private static final Logger LOG = Logger.getLogger(Grammars_Table_FL_LAII.class.getName());

    /**
     *
     */
    @SuppressWarnings("FieldMayBeFinal")
    protected String typeVariable = "(" + tokenString + "|" + tokenInt + ")";

    /**
     *
     */
    @SuppressWarnings("FieldMayBeFinal")
    protected String typeResults = "(" + tokenDigit + "|" + tokenCharacterString + ")";

    /**
     *
     */
    @SuppressWarnings("FieldMayBeFinal")
    protected String typeOperation = "(" + tokenOperatorSum + "|" + tokenOperatorSubtraction + "|" + tokenOperatorMultiplication + "|" + tokenOperatorDivision + ")";

    /**
     *
     */
    @SuppressWarnings("FieldMayBeFinal")
    protected String typeAllocation = "(" + tokenVariable + "|" + tokenCharacterString + "|" + tokenDigit + ")";

    /**
     *
     */
    @SuppressWarnings("FieldMayBeFinal")
    protected String typeRelational = "(" + tokenOperatorLessThan + "|" + tokenOperatorGreaterThan + "|" + tokenOperatorMoreMore + "|" + tokenOperatorLessLess + ")";

    /**
     *
     */
    protected String grammarStart = tokenMain + tokenOperatorParenthesisLeft + tokenOperatorParenthesisRight + tokenOperatorBracesLeft;

    /**
     *
     */
    protected String grammarVariableDeclarationONE = typeVariable + tokenVariable + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarVariableDeclarationTWO = typeVariable + tokenVariable + tokenOperatorEqual + typeResults + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarAllocationDataONE = tokenVariable + tokenOperatorEqual + typeAllocation + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarAllocationDataTWO = tokenVariable + tokenOperatorEqual + typeAllocation + typeOperation + typeAllocation + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarAllocationDataTREE = tokenVariable + tokenOperatorEqual + tokenGet + tokenOperatorParenthesisLeft + tokenOperatorParenthesisRight + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarIncrementingDecrementing = tokenVariable + "(" + tokenOperatorMoreMore + "|" + tokenOperatorLessLess + ")" + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarShowDate = tokenAprin + tokenOperatorParenthesisLeft + tokenCharacterString + tokenOperatorComa + tokenVariable + tokenOperatorParenthesisRight + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarShowMessage = tokenShow + tokenOperatorParenthesisLeft + tokenCharacterString + tokenOperatorParenthesisRight + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarCycleFOR = "(" + tokenVariable + "|" + tokenDigit + ")" + typeRelational + "(" + tokenVariable + "|" + tokenDigit + ")" + tokenOperatorColon;

    /**
     *
     */
    protected String grammarFinishFOR = tokenMay + tokenOnlineOrder;

    /**
     *
     */
    protected String grammarFinish = tokenOperatorBracesRight;

    /**
     *
     */
    public Grammars_Table_FL_LAII() {

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Grammars_Table_FL_LAII{" + '}';

    }

}
