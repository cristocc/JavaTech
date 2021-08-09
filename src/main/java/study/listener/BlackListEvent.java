package study.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by crist on 2021/6/16
 *
 * @author cc
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }

    @Override
    public String toString() {
        return "BlackListEvent{" +
                "address='" + address + '\'' +
                ", test='" + test + '\'' +
                "} " + super.toString();
    }
}
