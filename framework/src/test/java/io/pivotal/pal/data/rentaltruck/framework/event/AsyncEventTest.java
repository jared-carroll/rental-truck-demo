package io.pivotal.pal.data.rentaltruck.framework.event;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AsyncEventTest {

    private static final String eventName = "test";

    private String data;

    private DefaultAsyncEventPublisher<String> publisher;
    private AsyncEventSubscriberAdapter<String> subscriber;

    @Before
    public void setUp() {
        publisher = new DefaultAsyncEventPublisher<>(eventName);
        subscriber = new AsyncEventSubscriberAdapter<>(eventName, new Handler());

        data = null;
    }

    @Test
    public void basicTest() throws Exception {
        String someData = "some-data";
        publisher.publish(someData);

        Thread.sleep(1000);

        assertThat(data).isEqualTo(someData);
    }

    private class Handler implements AsyncEventHandler<String> {

        @Override
        public void onEvent(String data) {
            AsyncEventTest.this.data = data;
        }
    }
}
