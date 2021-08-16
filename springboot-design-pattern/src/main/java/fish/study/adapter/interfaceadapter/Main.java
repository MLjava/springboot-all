package fish.study.adapter.interfaceadapter;

/**
 * @author malin
 */
public class Main {

    public static void main(String[] args) {
        Play play = new PlayAdapter();
        play.play("mp4");
    }
}
