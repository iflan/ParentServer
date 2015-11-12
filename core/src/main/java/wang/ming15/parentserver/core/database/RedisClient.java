package wang.ming15.parentserver.core.database;

import redis.clients.jedis.Jedis;

/**
 * Created by wanggnim on 2015/10/31.
 */
public enum RedisClient {

	JEDIS_CACHE;

	private ThreadLocal<Jedis> cache = new ThreadLocal<Jedis>();

	private Jedis jedis() {
		Jedis jedis = cache.get();
		if (jedis == null) {
			jedis = newJedis("", 0);
			cache.set(jedis);
		}
		return jedis;
	}

	private Jedis newJedis(String redisIp, int redisPort) {
		return new Jedis(redisIp, redisPort);
	}
}
