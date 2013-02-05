/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package edu.asu.snac.server.auth;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.asu.snac.client.auth.AuthRequest;
import edu.asu.snac.client.auth.AuthResponse;
import edu.asu.snac.client.auth.AuthService;

public class AuthServiceImpl extends RemoteServiceServlet implements
		AuthService {

	@Override
	public AuthResponse doAuth(AuthRequest request) {
		String login = request.getLogin();
		String pw = request.getPw();

		String uid = checkCredential(login, pw);
		UserInfo userInfo = getUserInfo(uid);

		if (userInfo == null) {
			return AuthResponse.ofFailed().setInfo("wrong");
		} else {
			return AuthResponse.ofSucceeded().setInfo(userInfo.getUid());
		}
	}

	private String checkCredential(String login, String pw) {
		if (login.equals("admin") && pw.equals("admin")) {
			return "54321";
		} else {
			return null;
		}
	}

	private UserInfo getUserInfo(String uid) {
		if (uid == null) {
			return null;
		}
		return new UserInfo(uid);
	}
}
