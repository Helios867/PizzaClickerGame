package Controller;

public class GameController {

    public static final int TWENTY = 20;
    public static final int HUNDRED = 100;
    public static final int TWOHUNDRED = 200;
    public static final int FIVEK = 5000;
    public static final int THOUSAND = 1000;
    private int cursorPrice = TWENTY;
    private int cursorPriceIncrease = TWENTY;
    private int cursorCount = 1;
    private int pizza = 0;
    private int clickerPrice = HUNDRED;
    private int clickerPriceIncrease = TWOHUNDRED;
    private int clickerInterval = FIVEK;
    private int clickerIntervalDecrease = HUNDRED;
    private int clickerIntervalMin = THOUSAND;
    private int clickerCount = 0;

    public GameController(){

    }

    public GameController(int cursorPrice, int cursorPriceIncrease){
        this.cursorPrice = cursorPrice;
        this.cursorPriceIncrease = cursorPriceIncrease;
    }

    public GameController(int cursorPrice, int cursorPriceIncrease, int clickerPrice, int clickerPriceIncrease,
                          int clickerInterval, int clickerIntervalDecrease, int clickerIntervalMin){
        this.cursorPrice = cursorPrice;
        this.cursorPriceIncrease = cursorPriceIncrease;
        this.clickerPrice = clickerPrice;
        this.clickerInterval = clickerInterval;
        this.clickerPriceIncrease = clickerPriceIncrease;
        this.clickerIntervalDecrease = clickerIntervalDecrease;
        this.clickerIntervalMin = clickerIntervalMin;

    }

    public int getCursorPrice() {
        return this.cursorPrice;
    }

    /**
     * Gets the number of pizzas.
     * @return number of pizzas
     */
    public int getpizza() {
        return this.pizza;
    }

    /**
     * Gets cursor count.
     * @return cursor count
     */
    public int getCursorCount() {
        return this.cursorCount;
    }

    /**
     * Gets clicker count.
     * @return clicker count
     */
    public int getClickerCount() {
        return this.clickerCount;
    }

    /**
     * Gets clicker price.
     * @return clicker price
     */
    public int getClickerPrice() {
        return this.clickerPrice;
    }

    /**
     * Gets clicker interval.
     * @return clicker interval
     */
    public int getClickerInterval() {
        return this.clickerInterval;
    }

    /**
     * Clicker automatically clicks for pizza.
     */
    public void clickerAction() {
        if (this.clickerCount > 0) {
            this.pizza += this.cursorCount;
        }
    }

    /**
     * Cursor click gives pizza.
     */
    public void click() {
        this.pizza += this.cursorCount;
    }

    /**
     * Buys another cursor.
     */
    public void buyCursor() {
        if (canBuyCursor()) {
            this.pizza -= this.cursorPrice;
            this.cursorCount += 1;
            this.cursorPrice += this.cursorPriceIncrease;
        }
    }

    /**
     * Gets the minimum clicker interval.
     * @return minimum clicker interval
     */
    public int getClickerIntervalMin() {
        return this.clickerIntervalMin;
    }

    /**
     * Buys another clicker.
     */
    public void buyClicker() {
        if (canBuyClicker()) {
            this.pizza -= this.clickerPrice;
            this.clickerCount += 1;
            this.clickerPrice += this.clickerPriceIncrease;
            if (this.clickerCount != 1) {
                this.clickerInterval -= this.clickerIntervalDecrease;
                if (this.clickerInterval < this.clickerIntervalMin) {
                    this.clickerInterval = this.clickerIntervalMin;
                }
            }
        }
    }

    /**
     * Sees if a new cursor can be bought.
     * @return true false
     */
    public boolean canBuyCursor() {
        return this.pizza >= this.cursorPrice && this.pizza > 0 && this.cursorPrice > 0;
    }

    /**
     * Sees if a new clicker can be bought.
     * @return true false
     */
    public boolean canBuyClicker() {
        return this.pizza >= this.clickerPrice && this.pizza > 0 && this.clickerPrice > 0;
    }

}
