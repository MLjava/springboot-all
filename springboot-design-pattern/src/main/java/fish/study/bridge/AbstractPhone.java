package fish.study.bridge;

/**
 * @author malin
 */
public abstract class AbstractPhone {

    private final Brand brand;

    public AbstractPhone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        brand.doOpen();
    }

    protected void close() {
        brand.doClose();
    }

    protected void call() {
        brand.doCall();
    }

}
