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

package pl.quver.sharepointmobileclient.rest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Class TaskContainer of pl.quver.sharepointmobileclient.rest.models.
 *
 * Model is a container for elements of Sharepoint 2013 List
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 */
public class TasksContainerEntity {
    public static class Columns {
        public static final String CONTAINER = "value";
    }

    @SerializedName(Columns.CONTAINER)
    private List<TaskEntity> mValues;

    public List<TaskEntity> getmValues() {
        return mValues;
    }

    public void setmValues(List<TaskEntity> mValues) {
        this.mValues = mValues;
    }
}
