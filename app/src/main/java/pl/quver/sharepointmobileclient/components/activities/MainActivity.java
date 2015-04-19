/*
 * Copyright (c) Pawel Quver 2015.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package pl.quver.sharepointmobileclient.components.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.BackgroundExecutor;

import java.util.Collections;
import java.util.List;

import pl.quver.sharepointmobileclient.BuildConfig;
import pl.quver.sharepointmobileclient.Configuration;
import pl.quver.sharepointmobileclient.R;
import pl.quver.sharepointmobileclient.components.adapters.TasksListAdapter;
import pl.quver.sharepointmobileclient.rest.models.TaskEntity;
import pl.quver.sharepointmobileclient.rest.services.TasksService;

/**
 * Class Main of pl.quver.sharepointmobileclient.components.activities.
 *
 * Activite shows List of Tasks from Sharepoint REST API. This is start point of application.
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 * @see pl.quver.sharepointmobileclient.rest.services.TasksService
 * @see pl.quver.sharepointmobileclient.rest.models.TaskEntity
 */

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    protected Context mContext;
    protected String mFedAuth;
    protected String mRtfa;
    protected boolean mIsLogged = false;

    @ViewById(R.id.list_requests)
    protected ListView mTasksList;

    @Bean
    protected TasksListAdapter mTasksAdapter;

    @AfterViews
    void bindAdapter() {
        mTasksList.setAdapter(mTasksAdapter);
    }

    @RestService
    protected TasksService mTasksService;

    /**
     * Method checks is SharedPreferences contains rfTa and FedAuth for REST API requests
     */
    private void showLoginIfNeeded() {

        SharedPreferences shared = getSharedPreferences("AUTHENTICATION_CREDENTIALS", Context.MODE_PRIVATE);

        mFedAuth = shared.getString("FED_AUTH", "");
        mRtfa = shared.getString("RFTA", "");

        if(mRtfa.length() > 0 && mFedAuth.length() > 0) {
            System.out.println("mRtfa " + mRtfa);
            System.out.println("mFedAuth " + mFedAuth);

            mIsLogged = true;

            return;
        }

        mIsLogged = false;
        LoginActivity_.intent(this).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Configuration.SITE_URL.isEmpty() || Configuration.LIST_NAME.isEmpty() || Configuration.ENDPOINT_URL.isEmpty()) {
            throw new AssertionError("Configuration cannot be empty");
        }

        mContext = this;

        showLoginIfNeeded();
        performRequest();
    }

    @Override
    protected void onResume() {
        super.onResume();

        showLoginIfNeeded();
        performRequest();
    }

    @Override
    protected void onStop() {
        super.onStop();

        //Cancel all background requests when activity disappear top
        BackgroundExecutor.cancelAll("restRequest", true);
    }

    @AfterViews
    protected void click() {
        mTasksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                System.out.println(mTasksAdapter.getItem(i));

                DetailsActivity_.intent(mContext).taskEntity(mTasksAdapter.getItem(i)).start();
            }
        });
    }


    /**
     * Method perform requests to Sharepoint REST API on background thread
     */
    @Background(id="restRequest")
    protected void performRequest() {
        if(mIsLogged) {

            /**
             * Header "Cookie: rtFA=(String); FedAuth=(String)"
             */
            mTasksService.setHeader("Cookie", "rtFa=" + mRtfa + "; FedAuth=" + mFedAuth);

            List<TaskEntity> responseList = Collections.emptyList();

            try {
                responseList = mTasksService.getTasksList().getmValues();
            } catch (Exception e) {
                e.printStackTrace();
            }

            updateList(responseList);

            if(BuildConfig.DEBUG) {
                for (TaskEntity taskEntity : responseList) {
                    System.out.println(taskEntity.toString());
                }
            }
        }
    }

    /**
     * Method update Tasks List View on UI Thread
     * @param updatedList
     */
    @UiThread
    protected void updateList(List<TaskEntity> updatedList) {
        mTasksList.setAdapter(mTasksAdapter);
        mTasksAdapter.setmTasksList(updatedList);
    }
}
