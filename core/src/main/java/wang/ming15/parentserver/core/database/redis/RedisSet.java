package wang.ming15.parentserver.core.database.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public enum RedisSet {

	INSTANCE;
	
	/**
	 * 将一个或多个 member 元素加入到集合 key 当中,已经存在于集合的 member 元素将被忽略.
	 * 
	 * 假如 key 不存在,则创建一个只包含 member 元素作成员的集合.
	 * 
	 * 当 key 不是集合类型时,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 被添加到集合中的新元素的数量,不包括被忽略的元素.
	 */
	public Long sadd(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sadd(key, value);
		}
	}

	/**
	 * 返回集合 key 的基数(集合中元素的数量).
	 * 
	 * @param key
	 * @param value
	 * @return 集合的基数. 当 key 不存在时,返回 0 .
	 */
	public Long scard(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.scard(key);
		}
	}

	/**
	 * 返回一个集合的全部成员,该集合是所有给定集合之间的差集.
	 * 
	 * 不存在的 key 被视为空集.
	 * 
	 * @param key
	 * @param value
	 * @return 一个包含差集成员的列表.
	 */
	public Set<String> sdiff(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sdiff(key, value);
		}
	}

	/**
	 * 这个命令的作用和 SDIFF 类似,但它将结果保存到 destination 集合,而不是简单地返回结果集.
	 * 
	 * 如果 destination 集合已经存在,则将其覆盖.
	 * 
	 * destination 可以是 key 本身.
	 * 
	 * @param key
	 * @param value
	 * @return 结果集中的元素数量.
	 */
	public Long sdiffstore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sdiffstore(key, value);
		}
	}

	/**
	 * 返回一个集合的全部成员,该集合是所有给定集合的交集.
	 * 
	 * 不存在的 key 被视为空集.
	 * 
	 * 当给定集合当中有一个空集时,结果也为空集(根据集合运算定律).
	 * 
	 * @param key
	 * @param value
	 * @return 交集成员的列表.
	 */
	public Set<String> sinter(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sinter(key, value);
		}
	}

	/**
	 * 这个命令类似于 SINTER 命令,但它将结果保存到 destination 集合,而不是简单地返回结果集.
	 * 
	 * 如果 destination 集合已经存在,则将其覆盖.
	 * 
	 * destination 可以是 key 本身.
	 * 
	 * @param key
	 * @param value
	 * @return 结果集中的成员数量.
	 */
	public Long sinterstore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sinterstore(key, value);
		}
	}

	/**
	 * 判断 member 元素是否集合 key 的成员.
	 * 
	 * @param key
	 * @param value
	 * @return 如果 member 元素是集合的成员,返回 1 . 如果 member 元素不是集合的成员,或 key 不存在,返回 0 .
	 */
	public Boolean sismember(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sismember(key, value);
		}
	}

	/**
	 * 返回集合 key 中的所有成员.
	 * 
	 * 不存在的 key 被视为空集合.
	 * 
	 * @param key
	 * @param value
	 * @return 集合中的所有成员.
	 */
	public Set<String> smembers(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.smembers(key);
		}
	}

	/**
	 * 移除集合 key 中的一个或多个 member 元素,不存在的 member 元素会被忽略.
	 * 
	 * 当 key 不是集合类型,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 被成功移除的元素的数量,不包括被忽略的元素.
	 */
	public Long srem(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.srem(key, value);
		}
	}

	/**
	 * 移除并返回集合中的一个随机元素.
	 * 
	 * 如果只想获取一个随机元素,但不想该元素从集合中被移除的话,可以使用 SRANDMEMBER 命令.
	 * 
	 * @param key
	 * @param value
	 * @return 被移除的随机元素. 当 key 不存在或 key 是空集时,返回 nil .
	 */
	public String spop(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.spop(key);
		}
	}

	/**
	 * 将 member 元素从 source 集合移动到 destination 集合.
	 * 
	 * SMOVE 是原子性操作.
	 * 
	 * 如果 source 集合不存在或不包含指定的 member 元素,则 SMOVE 命令不执行任何操作,仅返回 0 .否则, member 元素从
	 * source 集合中被移除,并添加到 destination 集合中去.
	 * 
	 * 当 destination 集合已经包含 member 元素时, SMOVE 命令只是简单地将 source 集合中的 member 元素删除.
	 * 
	 * 当 source 或 destination 不是集合类型时,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 如果 member 元素被成功移除,返回 1 . 如果 member 元素不是 source 集合的成员,并且没有任何操作对
	 *         destination 集合执行,那么返回 0 .
	 */
	public Long smove(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.smove(key, value, value);
		}
	}

	/**
	 * 如果命令执行时,只提供了 key 参数,那么返回集合中的一个随机元素.
	 * 
	 * 从 Redis 2.6 版本开始, SRANDMEMBER 命令接受可选的 count 参数：
	 * 
	 * 如果 count 为正数,且小于集合基数,那么命令返回一个包含 count 个元素的数组,数组中的元素各不相同.如果 count
	 * 大于等于集合基数,那么返回整个集合. 如果 count 为负数,那么命令返回一个数组,数组中的元素可能会重复出现多次,而数组的长度为 count
	 * 的绝对值. 该操作和 SPOP 相似,但 SPOP 将随机元素从集合中移除并返回,而 SRANDMEMBER
	 * 则仅仅返回随机元素,而不对集合进行任何改动.
	 * 
	 * @param key
	 * @param value
	 * @return 只提供 key 参数时,返回一个元素；如果集合为空,返回 nil . 如果提供了 count
	 *         参数,那么返回一个数组；如果集合为空,返回空数组.
	 */
	public String srandmember(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.srandmember(key);
		}
	}

	/**
	 * 返回一个集合的全部成员,该集合是所有给定集合的并集.
	 * 
	 * 不存在的 key 被视为空集.
	 * 
	 * @param key
	 * @param value
	 * @return 并集成员的列表.
	 */
	public Set<String> sunion(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sunion(key, value);
		}
	}

	/**
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public ScanResult<String> sscan(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.sscan(key, value);
		}
	}
}
