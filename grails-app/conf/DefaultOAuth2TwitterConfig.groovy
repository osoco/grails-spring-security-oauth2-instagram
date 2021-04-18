/* Copyright 2021-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

security {
    oauth2 {
        providers {
            twitter {
                successUri = "/oauth2/twitter/success"
                failureUri = "/oauth2/twitter/failure"
                callback = "/oauth2/twitter/callback"
                api_key = "changeme_apikey"
                api_secret = "changeme_apisecret"
            }
        }
    }
}