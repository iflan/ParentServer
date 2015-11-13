package wang.ming15.parentserver.core.database.redis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public enum RedisSentinel {

	INSTANCE;
	
	/**
	 * 
	 * @return 
	 */
	public List<Map<String, String>> sentinelMasters() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelMasters();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<String> sentinelGetMasterAddrByName(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelGetMasterAddrByName(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Map<String, String>> sentinelSlaves(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelSlaves(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelFailover(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelFailover(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelMonitor(String name, int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelMonitor(name, name, ordinal, ordinal);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String sentinelRemove(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sentinelRemove(name);
		}
	}
}
