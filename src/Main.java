public class Main {

    public static void main(String[] args) {

        Market market = new Market();

        Actor shopper1 = new Human("Борис");
        Actor shopper2 = new Human("Виктор");
        Actor shopper3 = new Human("Яна");
        Actor shopper4 = new Human("Вероника");
        Actor shopper5 = new Human("Алексей");

        market.acceptToMarket(shopper1);
        market.acceptToMarket(shopper2);
        market.acceptToMarket(shopper3);
        market.acceptToMarket(shopper4);
        market.acceptToMarket(shopper5);

        market.update();

    }
}