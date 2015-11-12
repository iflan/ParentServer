package wang.ming15.netty.core.server.core.monitors;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.PooledDataSource;

/**
 * 参考http://www.cnblogs.com/dekn/archive/2006/02/14/330308.html
 * http://blog.csdn.net/lushuaiyin/article/details/7425407
 * @author Administrator
 *
 */
public enum C3P0Monitor {

	INSTANCE;

	public void monitor() {
		//! condition compile 
		if(true)
			return;
		
		// fix :  javax.naming.NoInitialContextException: Need to specify class name in environment or system property, 
		// or as an applet parameter, or in an application resource file:  java.naming.factory.initial
		Properties props = new Properties();
	    props.setProperty("java.naming.factory.initial", "jndiName");
	    
		try {
			// fetch a JNDI-bound DataSource
			InitialContext ictx = new InitialContext(props);
			DataSource ds = (DataSource) ictx.lookup("java:comp/env/jdbc/simpleDataSource");

			// make sure it's a c3p0 PooledDataSource
			if (ds instanceof PooledDataSource) {
				PooledDataSource pds = (PooledDataSource) ds;
				System.err.println("num_connections: "
						+ pds.getNumConnectionsDefaultUser());
				System.err.println("num_busy_connections: "
						+ pds.getNumBusyConnectionsDefaultUser());
				System.err.println("num_idle_connections: "
						+ pds.getNumIdleConnectionsDefaultUser());
				System.err.println();
			} else
				System.err.println("Not a c3p0 PooledDataSource!");
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}
}
