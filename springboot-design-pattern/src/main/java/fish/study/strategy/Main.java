package fish.study.strategy;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        Activity activity = new Activity(StrategyFactory.getStrategy(StrategyFactory.ActivityName.ACTIVITY618));
        activity.doPromotion();
    }
}
