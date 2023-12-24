import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior{

    private final List<Actor> ACTORS_IN_QUEUE = new ArrayList<>();
    private final List<Actor> ACTORS_IN_MARKET = new ArrayList<>();


    @Override
    public void acceptToMarket(Actor actor) {
        ACTORS_IN_MARKET.add(actor);
        System.out.println("Покупатель " + actor.getName() + " пришел в магазин");
    }

    @Override
    public void releaseFromMarket(List<Actor> actorsInMarket) {
        if (!actorsInMarket.isEmpty()){
            for (int i = 0; i < actorsInMarket.size(); i++) {
                System.out.println("Покупатель " + actorsInMarket.remove(i).getName() + " ушел из магазина");
                i--;
            }
        }
        printSeparator();
        System.out.println("В магазине сейчас никого нет!");
    }

    @Override
    public void update() {
        printSeparator();
        takeOrders();
        printSeparator();
        giveOrders();
        printSeparator();
        releaseFromMarket(ACTORS_IN_MARKET);
    }

    @Override
    public void takeInQueue(Actor actor) {
        ACTORS_IN_QUEUE.add(actor);
        System.out.println("Покупатель " + actor.getName() + " встал в очередь");
    }

    @Override
    public void takeOrders() {
        if (!ACTORS_IN_MARKET.isEmpty()) {
            for (Actor actor : ACTORS_IN_MARKET) {
                if (!actor.isMakeOrder){
                    actor.setMakeOrder(true);
                    actor.setTakeOrder(false);
                    System.out.println("Покупатель " + actor.getName() + " сделал заказ");
                    takeInQueue(actor);
                } else {
                    System.out.println("Покупатель " + actor.getName() + " уже сделал заказ ранее");
                }

            }
        } else {
            System.out.println("В магазине никого нет!");
        }

    }

    @Override
    public void giveOrders() {
        if (!ACTORS_IN_QUEUE.isEmpty()){
            for (int i = 0; i < ACTORS_IN_QUEUE.size(); i++) {
                if (!ACTORS_IN_QUEUE.get(i).isTakeOrder){
                    ACTORS_IN_QUEUE.get(i).setTakeOrder(true);
                    ACTORS_IN_QUEUE.get(i).setMakeOrder(false);
                    System.out.println("Покупатель " + ACTORS_IN_QUEUE.get(i).getName() + " забрал заказ");
                    realiseFromQueue(ACTORS_IN_QUEUE.get(i));
                    i--;
                } else {
                    System.out.println("Покупатель " + ACTORS_IN_QUEUE.get(i).getName() + " забрал заказ ранее");
                }
            }
        } else {
            System.out.println("В очереди никого нет, некому выдать заказ!");
        }
    }

    @Override
    public void realiseFromQueue(Actor actor) {
        ACTORS_IN_QUEUE.remove(actor);
        System.out.println("Покупатель " + actor.getName() + " вышел из очереди");
    }

    public void printSeparator(){
        System.out.println("-------------------------------------");
    }
}
