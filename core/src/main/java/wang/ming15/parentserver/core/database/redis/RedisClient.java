package wang.ming15.parentserver.core.database.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 在不同的线程中使用相同的Jedis实例会发生奇怪的错误.但是创建太多的实现也不好因为这意味着会建立很多sokcet连接,
 * 也会导致奇怪的错误发生.单一Jedis实例不是线程安全的.为了避免这些问题,可以使用JedisPool,
 * JedisPool是一个线程安全的网络连接池.可以用JedisPool创建一些可靠Jedis实例,可以从池中拿到Jedis的实例.
 * 这种方式可以解决那些问题并且会实现高效的性能
 * 
 */
public enum RedisClient {

	INSTANCE("10.234.10.12", 7006);
	
	private JedisPool pool;

	RedisClient(String host, int port) {
		pool = new JedisPool(host, port);
	}

	/**
	 * 
	 * @param jedis
	 */
	public void close(Jedis jedis) {
		jedis.close();
	}

	public Jedis getJedis() {
		return pool.getResource();
	}
	
	public void bitpos(String key, boolean value) {
		try (Jedis jedis = getJedis()) {
			jedis.bitpos(key, value);
		}
	}

	public void sentinelReset(String name) {
		try (Jedis jedis = getJedis()) {
			jedis.sentinelReset(name);
		}
	}

	public void sentinelSet(String name) {
		try (Jedis jedis = getJedis()) {
			jedis.sentinelSet(name, null);
		}
	}

	public void asking() {
		try (Jedis jedis = getJedis()) {
			jedis.asking();
		}
	}
	
	public void setDataSource() {
		try (Jedis jedis = getJedis()) {
			jedis.setDataSource(pool);
		}
	}

	public void expireAt(String key, long value) {
		try (Jedis jedis = getJedis()) {
			jedis.expireAt(key, value);
		}
	}

	public void substr(String name) {
		try (Jedis jedis = getJedis()) {
			jedis.substr(name, 0, 0);
		}
	}

	public void sunionstore(String key, String value) {
		try (Jedis jedis = getJedis()) {
			jedis.sunionstore(key, value);
		}
	}

	public void connect() {
		try (Jedis jedis = getJedis()) {
			jedis.connect();
		}
	}

	public void isConnected() {
		try (Jedis jedis = getJedis()) {
			jedis.isConnected();
		}
	}

	public void resetState() {
		try (Jedis jedis = getJedis()) {
			jedis.resetState();
		}
	}

	public void getDB() {
		try (Jedis jedis = getJedis()) {
			jedis.getDB();
		}
	}

	public void waitReplicas(int ordinal) {
		try (Jedis jedis = getJedis()) {
			jedis.waitReplicas(ordinal, ordinal);
		}
	}

	public void disconnect() {
		try (Jedis jedis = getJedis()) {
			jedis.disconnect();
		}
	}

	public void getClient() {
		try (Jedis jedis = getJedis()) {
			jedis.getClient();
		}
	}

	public void randomBinaryKey() {
		try (Jedis jedis = getJedis()) {
			jedis.randomBinaryKey();
		}
	}

}
