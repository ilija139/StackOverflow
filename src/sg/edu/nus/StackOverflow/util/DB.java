package sg.edu.nus.StackOverflow.util;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public enum DB {

    INSTANCE;

    private static final MongoClient mc = getClient();
    private static final String DB_NAME = "stackoverflow";

    /**
     * Testing that the mongoDB connection is working.
     * Note that you need manually to insert record in the test collection in the MongoDB database during installation. 
     * @return
     */
    public static String test() {
        DBCollection coll = mc.getDB(DB_NAME).getCollection("test");
        return coll.find().next().toString();
    }

    private static MongoClient getClient() {
        try {
            return new MongoClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}