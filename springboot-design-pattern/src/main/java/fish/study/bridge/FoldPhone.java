package fish.study.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class FoldPhone extends AbstractPhone {

    public FoldPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        log.info("折叠手机");
        super.open();
    }

    @Override
    protected void close() {
        log.info("折叠手机");
        super.close();
    }

    @Override
    protected void call() {
        log.info("折叠手机");
        super.call();
    }
}
