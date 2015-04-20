package pl.quver.sharepointmobileclient;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.google.gson.Gson;

import junit.framework.Assert;

import pl.quver.sharepointmobileclient.rest.models.TaskEntity;

public class ApplicationTest extends ApplicationTestCase<Application> {

    class WrongEntity{

    }

    private String mFullJSON;
    private String mCorruptedJSON;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        mFullJSON = "{ \"Id\" : 1, \"Title\" : \"Tomasz\"}";

        mCorruptedJSON = "{ \"Id\" : 1, \"Title\" : \"Tomasz\",";
    }

    @Override
    public void tearDown() throws Exception {
        mCorruptedJSON = null;
        mFullJSON = null;

        super.tearDown();
    }

    public void testMapFull() throws Exception {
        try {
            TaskEntity testFull = new Gson().fromJson(mFullJSON, TaskEntity.class);
            Assert.assertEquals("Tomasz", testFull.getmTitle());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void testMapCorrupted() throws Exception {
        try {
            TaskEntity testCorrupted = new Gson().fromJson(mCorruptedJSON, TaskEntity.class);
            Assert.assertNull(testCorrupted.getmTitle());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ApplicationTest() {
        super(Application.class);
    }
}