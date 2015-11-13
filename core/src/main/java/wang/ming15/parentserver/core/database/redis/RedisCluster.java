package wang.ming15.parentserver.core.database.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public enum RedisCluster {

	INSTANCE;
	
	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotMigrating(int ordinal, String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSetSlotMigrating(ordinal, name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotImporting(int ordinal, String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSetSlotImporting(ordinal, name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public String clusterSetSlotStable(int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSetSlotStable(ordinal);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterFlushSlots() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterFlushSlots();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Long clusterKeySlot(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterKeySlot(name);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public Long clusterCountKeysInSlot(int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterCountKeysInSlot(ordinal);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterSaveConfig() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSaveConfig();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String clusterReplicate(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterReplicate(name);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterFailover() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterFailover();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String clusterNodes() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterNodes();
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterMeet(int ordinal, String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterMeet(name, ordinal);
		}
	}

	/**
	 * 
	 * @param reset
	 * @return
	 */
	public String clusterReset(JedisCluster.Reset reset) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterReset(reset);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterInfo() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterInfo();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String clusterForget(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterForget(name);
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<String> clusterSlaves(String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSlaves(name);
		}
	}

	/**
	 * 
	 */
	public void clusterSlots() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.clusterSlots();
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String clusterAddSlots(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterAddSlots();
		}
	}

	/**
	 * 
	 * @return
	 */
	public String clusterDelSlots() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterDelSlots();
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @return
	 */
	public List<String> clusterGetKeysInSlot(int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterGetKeysInSlot(ordinal, ordinal);
		}
	}

	/**
	 * 
	 * @param ordinal
	 * @param name
	 * @return
	 */
	public String clusterSetSlotNode(int ordinal, String name) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.clusterSetSlotNode(ordinal, name);
		}
	}
}
