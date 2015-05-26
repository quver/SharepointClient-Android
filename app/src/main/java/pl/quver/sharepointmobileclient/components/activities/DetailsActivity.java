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
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import pl.quver.sharepointmobileclient.R;
import pl.quver.sharepointmobileclient.rest.models.TaskEntity;

/**
 * Class DetailsActivity of pl.quver.sharepointmobileclient.components.activities
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 */

@EActivity(R.layout.activity_details)
public class DetailsActivity extends Activity {

    @Extra
    protected TaskEntity taskEntity;

    @ViewById(R.id.text_details_id)
    protected TextView mId;

    @ViewById(R.id.text_details_title)
    protected TextView mTitle;

    @ViewById(R.id.text_details_client_name)
    protected TextView mClientName;

    @ViewById(R.id.text_details_client_phone)
    protected TextView mClientPhone;

    @ViewById(R.id.text_details_client_address)
    protected TextView mClientAddress;

    @ViewById(R.id.text_details_description)
    protected TextView mDescription;

    @AfterViews
    protected void bind() {
        try {
            mId.setText(String.valueOf(taskEntity.getmId().replaceAll("\\<.*?>", "")));
            mTitle.setText(String.valueOf(taskEntity.getmTitle().replaceAll("\\<.*?>", "")));
            mClientName.setText(String.valueOf(taskEntity.getmCustomer().replaceAll("\\<.*?>", "")));
            mClientPhone.setText(String.valueOf(taskEntity.getmPhone().replaceAll("\\<.*?>", "")));
            mClientAddress.setText(String.valueOf(taskEntity.getmAdress().replaceAll("\\<.*?>", "")));
            mDescription.setText(String.valueOf(taskEntity.getmDescription().replaceAll("\\<.*?>", "")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
