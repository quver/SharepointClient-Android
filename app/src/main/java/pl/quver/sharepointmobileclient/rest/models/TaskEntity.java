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
 * Class TaskEntity of pl.quver.sharepointmobileclient.rest.models.
 *
 * Model contains Id, Title
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 */
public class TaskEntity implements Serializable {
    private static final long serialVersionUID = 6794581071054319600L;
    /**
     * @serialField
     */
    @SerializedName(Columns.ID)
    private String mId;
    /**
     * @serialField
     */
    @SerializedName(Columns.TITLE)
    private String mTitle;
    /**
     * @serialField
     */
    @SerializedName(Columns.CUSTOMER)
    private String mCustomer;
    /**
     * @serialField
     */
    @SerializedName(Columns.DESCRIPTION)
    private String mDescription;
    /**
     * @serialField
     */
    @SerializedName(Columns.ADDRESS)
    private String mAdress;
    /**
     * @serialField
     */
    @SerializedName(Columns.PHONE)
    private String mPhone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCustomer() {
        return mCustomer;
    }

    public void setmCustomer(String mCustomer) {
        this.mCustomer = mCustomer;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mCustomer='" + mCustomer + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mAdress='" + mAdress + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }

    public static class Columns {
        public static final String ID = "ID_zlecenia";
        public static final String TITLE = "Title";
        public static final String CUSTOMER = "yzti";
        public static final String DESCRIPTION = "jxub";
        public static final String ADDRESS = "vo4v";
        public static final String PHONE = "daes";
    }
}
