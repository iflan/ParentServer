package wang.ming15.parentserver.core.util;

import com.google.protobuf.GeneratedMessage;
import com.googlecode.protobuf.format.JsonFormat;

/**
 *
 * Created by wanggnim on 2015/10/31.
 */
public class ProtobufJavaFormat {

	public static String format2String(GeneratedMessage message) {
		return JsonFormat.printToString(message);
	}

}
