package io.rouz.task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static org.junit.Assert.assertTrue;

/**
 * Testing utility for waiting for values
 */
public final class AwaitingConsumer<T> implements Consumer<T> {

  private final CountDownLatch latch = new CountDownLatch(1);
  private T value;

  @Override
  public void accept(T t) {
    value = t;
    latch.countDown();
  }

  public boolean isAvailable() {
    return latch.getCount() == 0;
  }

  public T awaitAndGet() throws InterruptedException {
    assertTrue("wait for value", latch.await(1, TimeUnit.SECONDS));
    return value;
  }
}
