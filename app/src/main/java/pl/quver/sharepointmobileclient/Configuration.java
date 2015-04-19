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

package pl.quver.sharepointmobileclient;

/**
 * Created by quver on 04.03.2015.
 */
public class Configuration {
    /**
     * Sharepoint website URL - top level
     */
    public static final String SITE_URL = "";

    /**
     * Sharepoint tasks list name
     * @see pl.quver.sharepointmobileclient.rest.models.Task
     */
    public static final String LIST_NAME = "";

    /**
     * Sharepoint tasks list REST API endpoint used as ROOT_URL
     */
    public static final String ENDPOINT_URL = Configuration.SITE_URL + "/_api/web/lists/GetByTitle('" + Configuration.LIST_NAME +"')";

    /**
     * Dummy constructor
     */
    public Configuration(){}
}
