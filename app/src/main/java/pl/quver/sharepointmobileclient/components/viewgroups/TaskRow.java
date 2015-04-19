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

package pl.quver.sharepointmobileclient.components.viewgroups;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import pl.quver.sharepointmobileclient.R;
import pl.quver.sharepointmobileclient.rest.models.Task;

/**
 * Class TaskRow of pl.quver.sharepointmobileclient.components.viewgroups.
 *
 * Class for binding row_task.xml layout with Task model
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 * @see pl.quver.sharepointmobileclient.components.adapters.TasksListAdapter
 * @see pl.quver.sharepointmobileclient.rest.models.Task
 */

@EViewGroup(R.layout.row_task)
public class TaskRow extends LinearLayout {

    @ViewById(R.id.text_task_id)
    protected TextView idText;

    @ViewById(R.id.text_task_title)
    protected TextView titleText;

    /**
     * Dummy constructor with app context injection
     * @param context App context
     * @see android.content.Context
     */
    public TaskRow(Context context) {
        super(context);
    }

    /**
     * Method bind <class>Task</class> with text views of row_task.xml
     * @param task
     */
    public void bind(Task task) {
        idText.setText(String.valueOf(task.getmId()));
        titleText.setText(String.valueOf(task.getmTitle()));
    }
}
