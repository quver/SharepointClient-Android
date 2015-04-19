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

import java.io.Serializable;

/**
 * Class Task of pl.quver.sharepointmobileclient.rest.models.
 *
 * Model contains Id, Title
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 6301788713967645642L;

    public static class Columns {
        public static final String ID = "Id";
        public static final String TITLE = "Title";
    }

    /**
     * @serialField
     */
    @SerializedName(Columns.ID)
    private int mId;

    /**
     * @serialField
     */
    @SerializedName(Columns.TITLE)
    private String mTitle;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }

    public Task(int mId, String mTitle) {
        this.mId = mId;
        this.mTitle = mTitle;
    }
}
