package io.pivotal.pal.data.rentaltruck.framework.event;

import org.springframework.kafka.core.KafkaTemplate;

public class KafkaAsyncEventSubscriber<T> implements AsyncEventHandler<T> {

    private String eventName;
    private KafkaTemplate<Object, T> template;

    public KafkaAsyncEventSubscriber(String eventName, KafkaTemplate<Object, T> template) {
        this.eventName = eventName;
        this.template = template;
    }

    @Override
    public void onEvent(T data) {
        template.send(eventName, data);
    }
}
