package fish.study.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author malin
 */
public class StrategyFactory {

    private static final Map<ActivityName, ActivityStrategy> ACTIVITY_STRATEGY_MAP = new HashMap<>();

    private static final ActivityStrategy NULL_STRATEGY = new NullStrategy();

    static {
        ACTIVITY_STRATEGY_MAP.put(ActivityName.ACTIVITY618, new Strategy618());
        ACTIVITY_STRATEGY_MAP.put(ActivityName.ACTIVITY1212, new Strategy618());
    }

    public static ActivityStrategy getStrategy(ActivityName activityName) {
        if (activityName == null) {
            return NULL_STRATEGY;
        }
        ActivityStrategy activityStrategy;
        try {
            activityStrategy = ACTIVITY_STRATEGY_MAP.get(activityName);
        } catch (RuntimeException e) {
            activityStrategy = NULL_STRATEGY;
        }
        return activityStrategy;
    }

    public enum ActivityName {

        /**
         *
         */
        ACTIVITY618,

        /**
         *
         */
        ACTIVITY1212;
    }

}
