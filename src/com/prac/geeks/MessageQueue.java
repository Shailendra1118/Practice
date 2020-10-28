/**
 * 
 */
package com.prac.geeks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by varma on 3/21/2018.
 */

class Message {
	private String unique_topic;
	private Integer sequence;

	public String getUnique_topic() {
		return unique_topic;
	}

	public void setUnique_topic(String unique_topic) {
		this.unique_topic = unique_topic;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "Message{" + "unique_topic='" + unique_topic + '\''
				+ ", sequence=" + sequence + '}';
	}
}

class Producer implements Runnable {

	BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {

			for (int i = 0; i < 10; i++) {
				Message message = new Message();
				message.setSequence(i);
				message.setUnique_topic(Thread.currentThread().getId() + " "
						+ i);
				queue.add(message);
				Thread.sleep(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
			Message msg = queue.take();
			while (msg != null) {
				System.out.println(msg.toString());
				msg = queue.take();
			}
		} catch (Exception e) {

		}
	}
}

public class MessageQueue {

	public static void main(String[] args) throws Exception {
		BlockingQueue<Message> bq = new ArrayBlockingQueue<>(10);

		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		IntStream.range(0, 3).forEach(i -> executorService.execute(producer));

		new Thread(consumer).start();

	}

}