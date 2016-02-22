package Codes_FL_LAII;

import Windows_FL_LAII.Beginning_Window_FL_LAII;
    
/**
 *
 * @author FL-AndruAnnohomy
 */
public class Simbol_Table_FL_LAII {

    /**
     *
     */
    protected Beginning_Window_FL_LAII guiWindows = new Beginning_Window_FL_LAII("");
    
    /**
     *
     */
    protected String tokenMain =                     "main";

    /**
     *
     */
    protected String tokenAprin =                    "aprin";

    /**
     *
     */
    protected String tokenString =                   "string";

    /**
     *
     */
    protected String tokenInt =                      "int";

    /**
     *
     */
    protected String tokenShow =                     "fl";

    /**
     *
     */
    protected String tokenGet =                      "get";

    /**
     *
     */
    protected String tokenMay =                      "may";

    /**
     *
     */
    protected String tokenOnlineOrder =              "\\;";

    /**
     *
     */
    protected String tokenOperatorSum =              "\\+";

    /**
     *
     */
    protected String tokenOperatorSubtraction =      "\\-";

    /**
     *
     */
    protected String tokenOperatorMultiplication =   "\\*";

    /**
     *
     */
    protected String tokenOperatorDivision =         "\\/";

    /**
     *
     */
    protected String tokenOperatorLessThan =         "<";

    /**
     *
     */
    protected String tokenOperatorGreaterThan =      ">";

    /**
     *
     */
    protected String tokenOperatorMoreMore =         "\\++";

    /**
     *
     */
    protected String tokenOperatorLessLess =         "\\--";

    /**
     *
     */
    protected String tokenOperatorEqual =            "=";

    /**
     *
     */
    protected String tokenOperatorColon =            ":";

    /**
     *
     */
    protected String tokenOperatorParenthesisLeft =  "\\(";

    /**
     *
     */
    protected String tokenOperatorParenthesisRight = "\\)";

    /**
     *
     */
    protected String tokenOperatorBracesLeft =       "\\{";

    /**
     *
     */
    protected String tokenOperatorBracesRight =      "\\}";

    /**
     *
     */
    protected String tokenOperatorComa =             "\\,";

    /**
     *
     */
    protected String tokenDigit =                    "([0-9]+)";

    /**
     *
     */
    protected String tokenCharacterString =          "('([a-z]|[A-Z]|[0-9]|\\ |\\:)*')";

    /**
     *
     */
    protected String tokenVariable =                 "([a-z|A-Z]+[0-9]+|[a-z|A-Z]+)";

    private String digit = "0|1|2|3|4|5|6|7|8|9";
    private String character = "a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|X|Y|Z";
    
    /**
     *
     */
    public Simbol_Table_FL_LAII() {

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: Simbol_Table_FL_LAII{" + '}';

    }

}
