package wang.ming15.parentserver.core.database.redis;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

public enum RedisSortedSet {

	INSTANCE;
	
	/**
	 * 
	 * @param ordinal
	 * @param value
	 * @return
	 */
	public Set<Tuple> zrangeWithScores(long ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrangeWithScores(value, ordinal, ordinal);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param ordinal
	 * @return
	 */
	public Set<Tuple> zrevrangeWithScores(String key, String value, long ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrevrangeWithScores(value, ordinal, ordinal);
		}
	}

	/**
	 * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中.
	 * 
	 * 如果某个 member 已经是有序集的成员,那么更新这个 member 的 score 值,并通过重新插入这个 member 元素,来保证该
	 * member 在正确的位置上.
	 * 
	 * score 值可以是整数值或双精度浮点数.
	 * 
	 * 如果 key 不存在,则创建一个空的有序集并执行 ZADD 操作.
	 * 
	 * 当 key 存在但不是有序集类型时,返回一个错误.
	 * 
	 * 对有序集的更多介绍请参见 sorted set .
	 * 
	 * @param key
	 * @param value
	 * @return 被成功添加的新成员的数量,不包括那些被更新的、已经存在的成员.
	 */
	public Long zadd(String key, Map<String, Double> value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zadd(key, value);
		}
	}

	/**
	 * 返回有序集 key 中,指定区间内的成员.
	 * 
	 * 其中成员的位置按 score 值递增(从小到大)来排序.
	 * 
	 * 具有相同 score 值的成员按字典序(lexicographical order )来排列.
	 * 
	 * 如果你需要成员按 score 值递减(从大到小)来排列,请使用 ZREVRANGE 命令.
	 * 
	 * 下标参数 start 和 stop 都以 0 为底,也就是说,以 0 表示有序集第一个成员,以 1 表示有序集第二个成员,以此类推.
	 * 你也可以使用负数下标,以 -1 表示最后一个成员, -2 表示倒数第二个成员,以此类推. 超出范围的下标并不会引起错误. 比如说,当 start
	 * 的值比有序集的最大下标还要大,或是 start > stop 时, ZRANGE 命令只是简单地返回一个空列表. 另一方面,假如 stop
	 * 参数的值比有序集的最大下标还要大,那么 Redis 将 stop 当作最大下标来处理. 可以通过使用 WITHSCORES 选项,来让成员和它的
	 * score 值一并返回,返回列表以 value1,score1, ..., valueN,scoreN 的格式表示.
	 * 客户端库可能会返回一些更复杂的数据类型,比如数组、元组等.
	 * 
	 * @param key
	 * @param value
	 * @return 指定区间内,带有 score 值(可选)的有序集成员的列表.
	 */
	public Long zrange(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrank(key, value);
		}
	}

	/**
	 * 移除有序集 key 中的一个或多个成员,不存在的成员将被忽略.
	 * 
	 * 当 key 存在但不是有序集类型时,返回一个错误.
	 * 
	 * @param key
	 * @param value
	 * @return 被成功移除的成员的数量,不包括被忽略的成员.
	 */
	public Long zrem(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrem(key, value);
		}
	}

	/**
	 * 为有序集 key 的成员 member 的 score 值加上增量 increment .
	 * 
	 * 可以通过传递一个负数值 increment ,让 score 减去相应的值,比如 ZINCRBY key -5 member ,就是让
	 * member 的 score 值减去 5 .
	 * 
	 * 当 key 不存在,或 member 不是 key 的成员时, ZINCRBY key increment member 等同于 ZADD key
	 * increment member .
	 * 
	 * 当 key 不是有序集类型时,返回一个错误.
	 * 
	 * score 值可以是整数值或双精度浮点数.
	 * 
	 * @param key
	 * @param ordinal
	 * @param value
	 * @return member 成员的新 score 值,以字符串形式表示.
	 */
	public Double zincrby(String key, double ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zincrby(key, ordinal, value);
		}
	}

	/**
	 * 返回有序集 key 中成员 member 的排名.其中有序集成员按 score 值递增(从小到大)顺序排列.
	 * 
	 * 排名以 0 为底,也就是说, score 值最小的成员排名为 0 .
	 * 
	 * 使用 ZREVRANK 命令可以获得成员按 score 值递减(从大到小)排列的排名.
	 * 
	 * @param key
	 * @param value
	 * @return 如果 member 是有序集 key 的成员,返回 member 的排名. 如果 member 不是有序集 key 的成员,返回
	 *         nil .
	 */
	public Long zrank(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrank(key, value);
		}
	}

	/**
	 * 返回有序集 key 中成员 member 的排名.其中有序集成员按 score 值递减(从大到小)排序.
	 * 
	 * 排名以 0 为底,也就是说, score 值最大的成员排名为 0 .
	 * 
	 * 使用 ZRANK 命令可以获得成员按 score 值递增(从小到大)排列的排名.
	 * 
	 * @param key
	 * @param value
	 * @return 如果 member 是有序集 key 的成员,返回 member 的排名. 如果 member 不是有序集 key 的成员,返回
	 *         nil .
	 */
	public Long zrevrank(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrevrank(key, value);
		}
	}

	/**
	 * 返回有序集 key 中,指定区间内的成员.
	 * 
	 * 其中成员的位置按 score 值递减(从大到小)来排列. 具有相同 score 值的成员按字典序的逆序(reverse
	 * lexicographical order)排列. 除了成员按 score 值递减的次序排列这一点外, ZREVRANGE 命令的其他方面和
	 * ZRANGE 命令一样
	 * 
	 * @param key
	 * @param value
	 * @param ordinal
	 * @return 指定区间内,带有 score 值(可选)的有序集成员的列表.
	 */
	public Set<String> zrevrange(String key, String value, long ordinal) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrevrange(value, ordinal, ordinal);
		}
	}

	/**
	 * 返回有序集 key 的基数.
	 * 
	 * @param key
	 * @param value
	 * @return 当 key 存在且是有序集类型时,返回有序集的基数. 当 key 不存在时,返回 0 .
	 */
	public Long zcard(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zcard(key);
		}
	}

	/**
	 * 返回有序集 key 中,成员 member 的 score 值.
	 * 
	 * 如果 member 元素不是有序集 key 的成员,或 key 不存在,返回 nil .
	 * 
	 * @param key
	 * @param value
	 * @return member 成员的 score 值,以字符串形式表示.
	 */
	public Double zscore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zscore(key, value);
		}
	}

	/**
	 * 返回有序集 key 中, score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量.
	 * 
	 * 关于参数 min 和 max 的详细使用方法,请参考 ZRANGEBYSCORE 命令.
	 * 
	 * @param key
	 * @param value
	 * @return score 值在 min 和 max 之间的成员的数量.
	 */
	public Long zcount(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zcount(key, value, value);
		}
	}

	/**
	 * 返回有序集 key 中,所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员.有序集成员按 score
	 * 值递增(从小到大)次序排列.
	 * 
	 * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的,不需要额外的计算).
	 * 
	 * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count ),注意当 offset
	 * 很大时,定位 offset 的操作可能需要遍历整个有序集,此过程最坏复杂度为 O(N) 时间.
	 * 
	 * 可选的 WITHSCORES 参数决定结果集是单单返回有序集的成员,还是将有序集成员及其 score 值一起返回. 该选项自 Redis 2.0
	 * 版本起可用. 区间及无限
	 * 
	 * min 和 max 可以是 -inf 和 +inf ,这样一来,你就可以在不知道有序集的最低和最高 score 值的情况下,使用
	 * ZRANGEBYSCORE 这类命令.
	 * 
	 * 默认情况下,区间的取值使用闭区间 (小于等于或大于等于),你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于).
	 * 
	 * @param key
	 * @param value
	 * @return 指定区间内,带有 score 值(可选)的有序集成员的列表.
	 */
	public Set<String> zrangeByScore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrangeByScore(key, value, value);
		}
	}

	/**
	 * 计算给定的一个或多个有序集的并集,其中给定 key 的数量必须以 numkeys 参数指定,并将该并集(结果集)储存到 destination .
	 * 
	 * 默认情况下,结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 .
	 * 
	 * WEIGHTS
	 * 
	 * 使用 WEIGHTS 选项,你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication
	 * factor),每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation
	 * function)之前都要先乘以该有序集的因子.
	 * 
	 * 如果没有指定 WEIGHTS 选项,乘法因子默认设置为 1 .
	 * 
	 * AGGREGATE
	 * 
	 * 使用 AGGREGATE 选项,你可以指定并集的结果集的聚合方式.
	 * 
	 * 默认使用的参数 SUM ,可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；使用参数 MIN
	 * ,可以将所有集合中某个成员的 最小 score 值作为结果集中该成员的 score 值；而参数 MAX 则是将所有集合中某个成员的 最大
	 * score 值作为结果集中该成员的 score 值.
	 * 
	 * @param key
	 * @param value
	 * @return 保存到 destination 的结果集的基数.
	 */
	public Long zunionstore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zunionstore(key, value);
		}
	}

	/**
	 * 计算给定的一个或多个有序集的交集,其中给定 key 的数量必须以 numkeys 参数指定,并将该交集(结果集)储存到 destination .
	 * 
	 * 默认情况下,结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
	 * 
	 * 关于 WEIGHTS 和 AGGREGATE 选项的描述,参见 ZUNIONSTORE 命令.
	 * 
	 * @param key
	 * @param value
	 * @return 保存到 destination 的结果集的基数.
	 */
	public Long zinterstore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zinterstore(key, value);
		}
	}

	/**
	 * 对于一个所有成员的分值都相同的有序集合键 key 来说, 这个命令会返回该集合中, 成员介于 min 和 max 范围内的元素数量.
	 * 
	 * 这个命令的 min 参数和 max 参数的意义和 ZRANGEBYLEX 命令的 min 参数和 max 参数的意义一样.
	 * 
	 * @param key
	 * @param value
	 * @return 整数回复：指定范围内的元素数量.
	 */
	public Long zlexcount(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zlexcount(key, value, value);
		}
	}

	/**
	 * 当有序集合的所有成员都具有相同的分值时, 有序集合的元素会根据成员的字典序（lexicographical ordering）来进行排序,
	 * 而这个命令则可以返回给定的有序集合键 key 中, 值介于 min 和 max 之间的成员.
	 * 
	 * 如果有序集合里面的成员带有不同的分值, 那么命令返回的结果是未指定的（unspecified）.
	 * 
	 * 命令会使用 C 语言的 memcmp() 函数, 对集合中的每个成员进行逐个字节的对比（byte-by-byte compare）,
	 * 并按照从低到高的顺序, 返回排序后的集合成员. 如果两个字符串有一部分内容是相同的话, 那么命令会认为较长的字符串比较短的字符串要大.
	 * 
	 * 可选的 LIMIT offset count 参数用于获取指定范围内的匹配元素 （就像 SQL 中的 SELECT LIMIT offset
	 * count 语句）. 需要注意的一点是, 如果 offset 参数的值非常大的话, 那么命令在返回结果之前, 需要先遍历至 offset
	 * 所指定的位置, 这个操作会为命令加上最多 O(N) 复杂度.
	 * 
	 * 如何指定范围区间 合法的 min 和 max 参数必须包含 ( 或者 [ , 其中 ( 表示开区间（指定的值不会被包含在范围之内）, 而 [
	 * 则表示闭区间（指定的值会被包含在范围之内）.
	 * 
	 * 特殊值 + 和 - 在 min 参数以及 max 参数中具有特殊的意义, 其中 + 表示正无限, 而 - 表示负无限. 因此,
	 * 向一个所有成员的分值都相同的有序集合发送命令 ZRANGEBYLEX <zset> - + , 命令将返回有序集合中的所有元素.
	 * 
	 * @param key
	 * @param value
	 * @return 数组回复：一个列表,列表里面包含了有序集合在指定范围内的成员.
	 */
	public Set<String> zrangeByLex(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrangeByLex(key, value, value);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public ScanResult<Tuple> zscan(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zscan(key, value);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrangeByScoreWithScores(key, value, value);
		}
	}

	/**
	 * 返回有序集 key 中, score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员.有序集成员按 score
	 * 值递减(从大到小)的次序排列.
	 * 
	 * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列.
	 * 
	 * 除了成员按 score 值递减的次序排列这一点外, ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样.
	 * 
	 * @param key
	 * @param value
	 * @return 指定区间内,带有 score 值(可选)的有序集成员的列表.
	 */
	public Set<String> zrevrangeByScore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrevrangeByScore(key, value, value);
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zrevrangeByScoreWithScores(key, value, value);
		}
	}

	/**
	 * 移除有序集 key 中,指定排名(rank)区间内的所有成员.
	 * 
	 * 区间分别以下标参数 start 和 stop 指出,包含 start 和 stop 在内.
	 * 
	 * 下标参数 start 和 stop 都以 0 为底,也就是说,以 0 表示有序集第一个成员,以 1 表示有序集第二个成员,以此类推.
	 * 你也可以使用负数下标,以 -1 表示最后一个成员, -2 表示倒数第二个成员,以此类推.
	 * 
	 * @param ordinal
	 * @param value
	 * @return 被移除成员的数量.
	 */
	public Long zremrangeByRank(int ordinal, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zremrangeByRank(value, ordinal, ordinal);
		}
	}

	/**
	 * 移除有序集 key 中,所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员.
	 * 
	 * 自版本2.1.6开始, score 值等于 min 或 max 的成员也可以不包括在内,详情请参见 ZRANGEBYSCORE 命令
	 * 
	 * @param key
	 * @param value
	 * @return 被移除成员的数量.
	 */
	public Long zremrangeByScore(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zremrangeByScore(key, value, value);
		}
	}

	/**
	 * 对于一个所有成员的分值都相同的有序集合键 key 来说, 这个命令会移除该集合中, 成员介于 min 和 max 范围内的所有元素.
	 * 
	 * 这个命令的 min 参数和 max 参数的意义和 ZRANGEBYLEX 命令的 min 参数和 max 参数的意义一样.
	 * 
	 * @param key
	 * @param value
	 * @return 整数回复：被移除的元素数量.
	 */
	public Long zremrangeByLex(String key, String value) {
		try (Jedis jedis = RedisClient.INSTANCE.getJedis()) {
			return jedis.zremrangeByLex(key, value, value);
		}
	}
}
