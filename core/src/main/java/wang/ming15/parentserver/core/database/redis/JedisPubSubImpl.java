package wang.ming15.parentserver.core.database.redis;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public class JedisPubSubImpl extends JedisPubSub {
	
	@Override
	public void onMessage(String channel, String message) {
		System.out.println("onMessage : " + channel + " " + message);
		super.onMessage(channel, message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("onPMessage :");
		super.onPMessage(pattern, channel, message);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("onPSubscribe :");
		super.onPSubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		System.out.println("onPUnsubscribe :");
		super.onPUnsubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println("onSubscribe :");
		super.onSubscribe(channel, subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		System.out.println("onUnsubscribe :");
		super.onUnsubscribe(channel, subscribedChannels);
	}

	@Override
	public void proceed(Client client, String... channels) {
		System.out.println("proceed :");
		super.proceed(client, channels);
	}

	@Override
	public void proceedWithPatterns(Client client, String... patterns) {
		System.out.println("proceedWithPatterns :");
		super.proceedWithPatterns(client, patterns);
	}

	@Override
	public void psubscribe(String... patterns) {
		System.out.println("psubscribe :");
		super.psubscribe(patterns);
	}

	@Override
	public void punsubscribe() {
		System.out.println("punsubscribe :");
		super.punsubscribe();
	}

	@Override
	public void punsubscribe(String... patterns) {
		System.out.println("punsubscribe :");
		super.punsubscribe(patterns);
	}

	@Override
	public void subscribe(String... channels) {
		System.out.println("subscribe :");
		super.subscribe(channels);
	}

	@Override
	public void unsubscribe() {
		System.out.println("unsubscribe :");
		super.unsubscribe();
	}

	@Override
	public void unsubscribe(String... channels) {
		System.out.println("unsubscribe :");
		super.unsubscribe(channels);
	}
}
