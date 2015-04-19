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

package pl.quver.sharepointmobileclient.rest.services;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import pl.quver.sharepointmobileclient.Configuration;
import pl.quver.sharepointmobileclient.rest.models.TasksContainerEntity;

/**
 * Interface TasksService of pl.quver.sharepointmobileclient.rest.services.
 *
 * Interface for request to Sharepoint 2013 list REST API using Gson Converter
 * rootUrl is Constants.ENDPOINT_URL
 *
 * @author quver
 * @version 1.0
 * @since 19.04.15
 * @see pl.quver.sharepointmobileclient.Configuration
 */

@Rest(rootUrl = Configuration.ENDPOINT_URL, converters = { GsonHttpMessageConverter.class })
public interface TasksService {

    /**
     * Method for /items endpoint
     *
     * @see pl.quver.sharepointmobileclient.rest.models.TasksContainerEntity
     * @see pl.quver.sharepointmobileclient.rest.models.TaskEntity
     * @return Multilevel object with API response
     */
    @Get("/items")
    @RequiresHeader("Cookie")
    @Accept(MediaType.APPLICATION_JSON)
    TasksContainerEntity getTasksList();

    void setHeader(String name, String value);
    String getHeader(String name);
}