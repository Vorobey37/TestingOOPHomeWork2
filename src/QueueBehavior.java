public interface QueueBehavior {

    void takeInQueue(Actor actor);
    void takeOrders();
    void giveOrders();
    void realiseFromQueue(Actor actor);

}
