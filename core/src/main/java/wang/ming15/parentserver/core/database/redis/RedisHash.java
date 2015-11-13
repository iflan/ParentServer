package wang.ming15.parentserver.core.database.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;

public enum RedisHash {

	INSTANCE;
	
	/**
	 * 将哈希表 key 中的域 field 的值设为 value .
	 * 
	 * 如果 key 不存在,一个新的哈希表被创建并进行 HSET 操作.
	 * 
	 * 如果域 field 已经存在于哈希表中,旧值将被覆盖.
	 * 
	 * 时间复杂度： O(1)
	 * 
	 * @param key
	 * @param value
	 * @return 如果 field 是哈希表中的一个新建域,并且值设置成功,返回 1 . 如果哈希表中域 field
	 *         已经存在且旧值已被新值覆盖,返回 0
	 */
	public void hset(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hset(key, value, value);
		}
	}

	/**
	 * 返回哈希表 key 中给定域 field 的值. 时间复杂度： O(1) nil .
	 * 
	 * @param key
	 * @param value
	 * @return 给定域的值. 当给定域不存在或是给定 key 不存在时,返回
	 */
	public void hget(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hget(key, value);
		}
	}

	/**
	 * 将哈希表 key 中的域 field 的值设置为 value ,当且仅当域 field 不存在.
	 * 
	 * 若域 field 已经存在,该操作无效.
	 * 
	 * 如果 key 不存在,一个新哈希表被创建并执行 HSETNX 命令.
	 * 
	 * 时间复杂度： O(1)
	 * 
	 * @param key
	 * @param value
	 * @return 设置成功,返回 1 . 如果给定域已经存在且没有操作被执行,返回 0 .
	 */
	public void hsetnx(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hsetnx(key, value, value);
		}
	}

	/**
	 * 同时将多个 field-value (域-值)对设置到哈希表 key 中.
	 * 
	 * 此命令会覆盖哈希表中已存在的域.
	 * 
	 * 如果 key 不存在,一个空哈希表被创建并执行 HMSET 操作.
	 * 
	 * 时间复杂度： O(N), N 为 field-value 对的数量.
	 * 
	 * @param key
	 * @param value
	 * @return 如果命令执行成功,返回 OK . 当 key 不是哈希表(hash)类型时,返回一个错误.
	 */
	public void hmset(String key, Map<String, String> value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hmset(key, value);
		}
	}

	/**
	 * 返回哈希表 key 中,一个或多个给定域的值.
	 * 
	 * 如果给定的域不存在于哈希表,那么返回一个 nil 值.
	 * 
	 * 因为不存在的 key 被当作一个空哈希表来处理,所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(N), N 为给定域的数量.
	 * 
	 * @param key
	 * @param value
	 * @return 一个包含多个给定域的关联值的表,表值的排列顺序和给定域参数的请求顺序一样.
	 */
	public void hmget(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hmget(key, value);
		}
	}

	/**
	 * 返回哈希表 key 中,一个或多个给定域的值.
	 * 
	 * 如果给定的域不存在于哈希表,那么返回一个 nil 值.
	 * 
	 * 因为不存在的 key 被当作一个空哈希表来处理,所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表.
	 * 
	 * 时间复杂度： O(N), N 为给定域的数量.
	 * 
	 * @param key
	 * @param value
	 * @return 一个包含多个给定域的关联值的表,表值的排列顺序和给定域参数的请求顺序一样.
	 */
	public void hincrBy(String key, String value, long ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hincrBy(key, value, ordinal);
		}
	}

	/**
	 * 为哈希表 key 中的域 field 加上浮点数增量 increment .
	 * 
	 * 如果哈希表中没有域 field ,那么 HINCRBYFLOAT 会先将域 field 的值设为 0 ,然后再执行加法操作.
	 * 
	 * 如果键 key 不存在,那么 HINCRBYFLOAT 会先创建一个哈希表,再创建域 field ,最后再执行加法操作.
	 * 
	 * 当以下任意一个条件发生时,返回一个错误：
	 * 
	 * 域 field 的值不是字符串类型(因为 redis 中的数字和浮点数都以字符串的形式保存,所以它们都属于字符串类型） 域 field
	 * 当前的值或给定的增量 increment 不能解释(parse)为双精度浮点数(double precision floating point
	 * number) HINCRBYFLOAT 命令的详细功能和 INCRBYFLOAT 命令类似,请查看 INCRBYFLOAT
	 * 命令获取更多相关信息.
	 * 
	 * 时间复杂度： O(1)
	 * 
	 * @param key
	 * @param value
	 * @return 执行加法操作之后 field 域的值.
	 */
	public void hincrByFloat(String key, String value, double ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hincrByFloat(key, value, ordinal);
		}
	}

	/**
	 * 查看哈希表 key 中,给定域 field 是否存在.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(1)
	 * 
	 * @param key
	 * @param value
	 * @return 如果哈希表含有给定域,返回 1 . 如果哈希表不含有给定域,或 key 不存在,返回 0 .
	 */
	public void hexists(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hexists(key, value);
		}
	}

	/**
	 * 删除哈希表 key 中的一个或多个指定域,不存在的域将被忽略. 时间复杂度: O(N), N 为要删除的域的数量.
	 * 
	 * @param key
	 * @param value
	 * @return 被成功移除的域的数量,不包括被忽略的域.
	 */
	public void hdel(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hdel(key, value);
		}
	}

	/**
	 * 查看哈希表 key 中,给定域 field 是否存在.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(1)
	 * 
	 * @param key
	 * @param value
	 * @return 如果哈希表含有给定域,返回 1 . 如果哈希表不含有给定域,或 key 不存在,返回 0
	 */
	public void hlen(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hlen(key);
		}
	}

	/**
	 * 返回哈希表 key 中的所有域.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(N), N 为哈希表的大小.
	 * 
	 * @param key
	 * @param value
	 * @return 一个包含哈希表中所有域的表. 当 key 不存在时,返回一个空表.
	 */
	public void hkeys(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hkeys(key);
		}
	}

	/**
	 * 返回哈希表 key 中所有域的值.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(N), N 为哈希表的大小.
	 * 
	 * @param key
	 * @param value
	 * @return 一个包含哈希表中所有值的表. 当 key 不存在时,返回一个空表.
	 */
	public void hvals(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hvals(key);
		}
	}

	/**
	 * 返回哈希表 key 中,所有的域和值.
	 * 
	 * 在返回值里,紧跟每个域名(field name)之后是域的值(value),所以返回值的长度是哈希表大小的两倍.
	 * 
	 * 可用版本： >= 2.0.0
	 * 
	 * 时间复杂度： O(N), N 为哈希表的大小.
	 * 
	 * @param key
	 * @param value
	 * @return 以列表形式返回哈希表的域和域的值. 若 key 不存在,返回空列表.
	 */
	public void hgetAll(String key) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hgetAll(key);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void hscan(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			jedis.hscan(key, value);
		}
	}
}
