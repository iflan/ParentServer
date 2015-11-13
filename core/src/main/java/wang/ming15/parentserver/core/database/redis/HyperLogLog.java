package wang.ming15.parentserver.core.database.redis;

import redis.clients.jedis.Jedis;

public enum HyperLogLog {

	INSTANCE;
	
	public void pfcount(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.pfcount(key, value);
		}
	}
	
	public void pfadd(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.pfadd(key, value);
		}
	}
	
	public void pfmerge(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.pfmerge(key, value);
		}
	}
}
