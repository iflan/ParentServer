package wang.ming15.parentserver.core.database.redis;

import redis.clients.jedis.Jedis;

public enum RedisServer {

	INSTANCE;

	public void bgrewriteaof() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.bgrewriteaof();
		}
	}

	public void bgsave() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.bgsave();
		}
	}

	public void clientKill(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.clientKill(key);
		}
	}

	public void clientSetname(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.clientSetname(key);
		}
	}

	public void clientGetname() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.clientGetname();
		}
	}

	public void clientList() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.clientList();
		}
	}

	public void configResetStat() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.configResetStat();
		}
	}

	public void configGet(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.configGet(key);
		}
	}

	public void configSet(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.configSet(key, value);
		}
	}

	public void dbSize() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.dbSize();
		}
	}

	public void flushDB() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.flushDB();
		}
	}

	public void info() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.info();
		}
	}

	public void lastsave() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.lastsave();
		}
	}

	public void monitor() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.monitor(null);
		}
	}

	public void flushAll() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.flushAll();
		}
	}

	public void shutdown() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.shutdown();
		}
	}

	public void debug() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.debug(null);
		}
	}

	public void save() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.save();
		}
	}

	public void slaveof(String name, int ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slaveof(name, ordinal);
		}
	}

	public void slaveofNoOne() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slaveofNoOne();
		}
	}

	public void slowlogGet() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slowlogGet();
		}
	}

	public void slowlogReset() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slowlogReset();
		}
	}

	public void slowlogLen() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slowlogLen();
		}
	}

	public void slowlogGetBinary() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.slowlogGetBinary();
		}
	}

	public void sync() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.sync();
		}
	}

	public void time() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.time();
		}
	}

}
