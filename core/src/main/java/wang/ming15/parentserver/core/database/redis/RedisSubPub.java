package wang.ming15.parentserver.core.database.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * PUNSUBSCRIBE
 *  UNSUBSCRIBE
 * PUBSUB
 * 
 * @author wangming
 *
 */
public enum RedisSubPub {

	INSTANCE;

	/**
	 * 订阅一个或多个符合给定模式的频道。
	 * 
	 * 每个模式以 * 作为匹配符,比如 it* 匹配所有以 it 开头的频道( it.news , it.blog , it.tweets 等等),
	 * news.* 匹配所有以 news. 开头的频道( news.it , news.global.today 等等),诸如此类。
	 * 
	 * @param key
	 * @param value
	 */

	public void psubscribe(String... channels) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			JedisPubSubImpl imple = new JedisPubSubImpl();
			jedis.psubscribe(imple, channels);
		}
	}

	/**
	 * 将信息 message 发送到指定的频道 channel
	 * 
	 * 时间复杂度： O(N+M),其中 N 是频道 channel 的订阅者数量,而 M 则是使用模式订阅(subscribed
	 * patterns)的客户端的数量。
	 * 
	 * @param key
	 * @param value
	 * @return 接收到信息 message 的订阅者数量。
	 */
	public Long publish(String channel, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.publish(channel, value);
		}
	}

	/**
	 * 
	 * @return
	 */
	public Long pubsubNumPat() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.pubsubNumPat();
		}
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, String> pubsubNumSub() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.pubsubNumSub();
		}
	}
	
	public void pubsubChannels(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.pubsubChannels(name);
		}
	}
	
	/**
	 * 订阅给定的一个或多个频道的信息。
	 */
	public void subscribe(String... channels) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			JedisPubSubImpl imple = new JedisPubSubImpl();
			jedis.subscribe(imple, channels);
		}
	}
	
}
