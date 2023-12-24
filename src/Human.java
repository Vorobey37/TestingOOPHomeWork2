public class Human extends Actor{

    public Human(String name) {
        super(name);
        super.isMakeOrder = false;
        super.isTakeOrder = false;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setTakeOrder(boolean takeOrder) {
        super.isTakeOrder = takeOrder;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
}
