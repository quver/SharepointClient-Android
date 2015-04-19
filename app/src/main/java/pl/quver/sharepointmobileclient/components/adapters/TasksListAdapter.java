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

package pl.quver.sharepointmobileclient.components.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.Collections;
import java.util.List;

import pl.quver.sharepointmobileclient.rest.models.TaskEntity;
import pl.quver.sharepointmobileclient.components.viewgroups.TaskRow;
import pl.quver.sharepointmobileclient.components.viewgroups.TaskRow_;

/**
 * Class TasksListAdapter of pl.quver.sharepointmobileclient.components.adapters.
 *
 * Adapter bind data to TaskList with TaskRow view group
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 * @see pl.quver.sharepointmobileclient.rest.models.TaskEntity
 */

@EBean
public class TasksListAdapter extends BaseAdapter {

    /**
     * List of <class>TaskEntity</class> objects
     */
    List<TaskEntity> mTasksList = Collections.emptyList();

    @RootContext
    Context context;

    /**
     * Method perform TasksList update on MainActivity
     * @param updatedList list of <class>TaskEntity</class> objects
     */
    public void setmTasksList(List<TaskEntity> updatedList) {
        mTasksList = updatedList;
        notifyDataSetChanged();
    }

    /**
     * Dummy getter
     * @return List of <class>TaskEntity</class> objects
     */
    public List<TaskEntity> getmTasksList () {
        return mTasksList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskRow taskRowView;
        if (convertView == null) {
            taskRowView = TaskRow_.build(context);
        } else {
            taskRowView = (TaskRow) convertView;
        }

        taskRowView.bind(getItem(position));

        return taskRowView;
    }

    @Override
    public int getCount() {
        return mTasksList.size();
    }

    @Override
    public TaskEntity getItem(int position) {
        return mTasksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
