package fish.study.adapter.classadpater;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malin
 */
@Slf4j
public class VoltageAdapter extends Voltage implements IBatterLine {

    @Override
    public int output() {
        int voltage = getVoltage();
        log.info("标准电压为：{}V", voltage);
        int out = voltage / 44;
        log.info("适配之后的电压：{}V", out);
        return out;
    }
}
