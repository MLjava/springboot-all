package fish.study.strategy;

/**
 * @author malin
 */
public class Activity {

    private final ActivityStrategy activityStrategy;

    public Activity(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    public void doPromotion() {
        activityStrategy.promotion();;
    }
}
