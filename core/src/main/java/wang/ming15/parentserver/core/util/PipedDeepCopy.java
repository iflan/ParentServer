package wang.ming15.parentserver.core.util;

import java.io.*;

/**
 *
 * Created by wanggnim on 2015/11/5.
 */
public class PipedDeepCopy {
    /**
     * Flag object used internally to indicate that deserialization failed.
     */
    private static final Object ERROR = new Object();

    /**
     * Returns a copy of the object, or null if the object cannot
     * be serialized.
     */
    public static Object copy(Object orig) {
        Object obj = null;
        try {
            // Make a connected pair of piped streams
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(in);

            // Make a deserializer thread (see inner class below)
            Deserializer des = new Deserializer(in);

            // Write the object to the pipe
            ObjectOutputStream out = new ObjectOutputStream(pos);
            out.writeObject(orig);

            // Wait for the object to be deserialized
            obj = des.getDeserializedObject();

            // See if something went wrong
            if (obj == ERROR)
                obj = null;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return obj;
    }

    /**
     * Thread subclass that handles deserializing from a PipedInputStream.
     */
    private static class Deserializer extends Thread {
        /**
         * Object that we are deserializing
         */
        private Object obj = null;

        /**
         * Lock that we block on while deserialization is happening
         */
        private Object lock = null;

        /**
         * InputStream that the object is deserialized from.
         */
        private PipedInputStream in = null;

        public Deserializer(PipedInputStream pin) throws IOException {
            lock = new Object();
            this.in = pin;
            start();
        }

        public void run() {
            Object o = null;
            try {
                ObjectInputStream oin = new ObjectInputStream(in);
                o = oin.readObject();
            } catch(IOException e) {
                // This should never happen. If it does we make sure
                // that a the object is set to a flag that indicates
                // deserialization was not possible.
                e.printStackTrace();
            } catch(ClassNotFoundException cnfe) {
                // Same here...
                cnfe.printStackTrace();
            }

            synchronized(lock) {
                if (o == null)
                    obj = ERROR;
                else
                    obj = o;
                lock.notifyAll();
            }
        }

        /**
         * Returns the deserialized object. This method will block until
         * the object is actually available.
         */
        public Object getDeserializedObject() {
            // Wait for the object to show up
            try {
                synchronized(lock) {
                    while (obj == null) {
                        lock.wait();
                    }
                }
            }
            catch(InterruptedException ie) {
                // If we are interrupted we just return null
            }
            return obj;
        }
    }

}
