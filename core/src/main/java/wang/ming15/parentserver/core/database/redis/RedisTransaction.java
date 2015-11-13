package wang.ming15.parentserver.core.database.redis;

import redis.clients.jedis.Jedis;

public enum RedisTransaction {

	INSTANCE;

	/**
	 * 取消 WATCH 命令对所有 key 的监视.
	 * 
	 * 如果在执行 WATCH 命令之后, EXEC 命令或 DISCARD 命令先被执行了的话,那么就不需要再执行 UNWATCH 了.
	 * 
	 * 因为 EXEC 命令会执行事务,因此 WATCH 命令的效果已经产生了；而 DISCARD 命令在取消事务的同时也会取消所有对 key
	 * 的监视,因此这两个命令执行之后,就没有必要执行 UNWATCH 了.
	 * 
	 * @return
	 */
	public String unwatch() {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.unwatch();
		}
	}

	/**
	 * 监视一个(或多个) key ,如果在事务执行之前这个(或这些) key 被其他命令所改动,那么事务将被打断.
	 * 
	 * @param key
	 * @param value
	 * @return 总是返回 OK .
	 */
	public String watch(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.watch(key, value);
		}
	}

}
