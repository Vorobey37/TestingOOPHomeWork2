public interface ActorBehavior {

    void setTakeOrder(boolean takeOrder);
    void setMakeOrder(boolean makeOrder);
    boolean isMakeOrder();
    boolean isTakeOrder();

}
