/**
 * enum to specify all symbols a tile can hold
 *
 * @author AndrewSommer
 * @version 1.0.0 06 November 2017
 */
public enum Symbol {
    CROSS('X'),
    NAUGHT('O'),
    EMPTY(' ');//Whitespace

    /**
     * The character that will be placed on the board
     */
    private final char symbol;

    /**
     * Constructor
     * @param symbol
     */
    Symbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the character of the symbol
     * @return
     */
    public char getSymbol() {
        return symbol;
    }
}
