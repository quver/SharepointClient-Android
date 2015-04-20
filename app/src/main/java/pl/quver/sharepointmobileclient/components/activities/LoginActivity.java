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
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import pl.quver.sharepointmobileclient.Configuration;
import pl.quver.sharepointmobileclient.R;

/**
 * Class LoginActivity of pl.quver.sharepointmobileclient.components.activities.
 *
 * Activite for Sharepoint Authentication with cookie parsing for rfTa and FedAuth values
 * and puts it to SharedPreferences
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 * @see pl.quver.sharepointmobileclient.Configuration
 * @see android.content.SharedPreferences
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {

    @ViewById(R.id.web_login)
    protected WebView mWebView;

    private CookieManager mCookieManager;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mPreferencesEditor;

    /**
     * Method shows webView and parse cookie for rfTa and FedAuth after Android Annotations inject
     */
    @AfterViews
    void performLogin() {
        System.out.println("Starting web login activity");

        mSharedPreferences = getSharedPreferences("AUTHENTICATION_CREDENTIALS", Context.MODE_WORLD_WRITEABLE);
        mPreferencesEditor = mSharedPreferences.edit();

        mWebView.loadUrl(Configuration.SITE_URL);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mCookieManager = CookieManager.getInstance();
        mCookieManager.removeSessionCookie();

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                String Cookies =  mCookieManager.getCookie(Configuration.SITE_URL);

                try {
                    if (Cookies.contains("rtFa")) {
                        String[] separated = Cookies.split(";");
                        boolean RTFA = false;
                        boolean FedAuth = false;
                        String RTFA_Value = "";
                        String FedAuth_Value = "";

                        for (int i = 0; i <= separated.length - 1; i++) {

                            if (separated[i].contains("rtFa") && !RTFA) {
                                RTFA_Value = separated[i].substring(6);
                                mPreferencesEditor.putString("RFTA", RTFA_Value);
                                mPreferencesEditor.commit();
                                RTFA = true;
                            }

                            if (separated[i].contains("FedAuth") && !FedAuth) {
                                FedAuth_Value = separated[i].substring(9);
                                mPreferencesEditor.putString("FED_AUTH", FedAuth_Value);
                                mPreferencesEditor.commit();
                                FedAuth = true;
                            }

                            if (RTFA && FedAuth) {
                                System.out.println("Login success");

                                System.out.println("FED_AUTH: " + mSharedPreferences.getString("FED_AUTH", ""));
                                System.out.println("RFTA: " + mSharedPreferences.getString("RFTA", ""));

                                finish();

                                break;
                            }

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return true;
            }
        });
    }
}
