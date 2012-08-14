/*
 * ###
 * PHR_AndroidNative
 * %%
 * Copyright (C) 1999 - 2012 Photon Infotech Inc.
 * %%
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
 * ###
 */
/**
 * Author by {phresco} QA Automation Team
 */
package com.photon.phresco.nativeapp.performance.test.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.photon.phresco.nativeapp.R;

import com.jayway.android.robotium.solo.Solo;

public class LoginValidationTest extends TestCase {

	private Solo soloLoginValid;
	private String activityName;
	public ImageView clickCancel;
	private String TAG = "*****LoginValidationTestCase******";

	public LoginValidationTest(Solo solo) {
		this.soloLoginValid = solo;

	}

	public void testLoginValidation() throws TestException {

		try {
			Log.i(TAG, "------It is testLoginValidation()-----------");

			activityName = soloLoginValid.getCurrentActivity().getClass().getSimpleName();

			if (activityName.equalsIgnoreCase("MainActivity")) {
				Log.i(TAG, "------It is MainActivity-----------" + activityName);
				soloLoginValid.waitForActivity("HomeActivity", 2000);

				for (int i = 0; i < 40; i++) {
					activityName = soloLoginValid.getCurrentActivity().getClass().getSimpleName();
					if (activityName.equalsIgnoreCase("HomeActivity")) {

						Log.i(TAG, "------for()-- loop-----");
						break;
					}

					soloLoginValid.waitForActivity("HomeActivity", 2000);
				}

			} else {
				Log.i(TAG, "------ testLoginValidation failed-----------");
				throw new TestException("Current Activity Failed----"
						+ soloLoginValid.getCurrentActivity().getClass().getSimpleName() + "failed");
			}

			if (activityName.equalsIgnoreCase("HomeActivity")) {
				Log.i(TAG, "------HomeActivity-----------");
				System.out.println(" Activity name ---->" + soloLoginValid.getCurrentActivity());
				ArrayList<View> al = soloLoginValid.getViews();
				Iterator<View> it = al.iterator();
				while (it.hasNext()) {
					String viewName = it.next().getClass().getSimpleName();
					if (viewName.equalsIgnoreCase("ImageView")) {
						Log.i(TAG, "------ImageView found-----------");
						break;
					}
					continue;
				}

			} else {
				Log.i(TAG, "------HomeActivity not  found-----------");
				throw new TestException(TAG + soloLoginValid.getCurrentActivity().getClass().getSimpleName() + "failed");
			}
			// click on Loginbutton
			soloLoginValid.waitForActivity("MainActivity", 5000);
			// get the login button view with id i.e home_login_btn
			ImageView loginButton = (ImageView) soloLoginValid
					.getView(R.id.home_login_btn);
			// click on login button with view id
			soloLoginValid.clickOnView(loginButton);
			// control waits for 2 seconds to activate the screen
			soloLoginValid.waitForActivity("SplashActivity", 2000);
			// clears the text at first Editfield
			EditText emailField = (EditText) soloLoginValid.getView(R.id.txt_email);
			soloLoginValid.clearEditText(emailField);
			// it will type the text at first field which i gave in method
			soloLoginValid.enterText(emailField, "android@");
			// clear the text at second Editfield
			EditText passwordField = (EditText) soloLoginValid
					.getView(R.id.txt_password);
			soloLoginValid.clearEditText(passwordField);
			// finding the password field view
			// click the password field based on EditText view object
			soloLoginValid.clickOnView(passwordField);
			soloLoginValid.waitForActivity("MainActivity", 1000);
			soloLoginValid.enterText(passwordField, "*****");
			soloLoginValid.waitForActivity("MainActivity", 1000);
			// click on Login button
			ImageView clickLogin = (ImageView) soloLoginValid
					.getView(R.id.login_btn);
			soloLoginValid.clickOnView(clickLogin);
			// soloSplash.clickOnImageButton(1);
			soloLoginValid.waitForActivity("LoginActivity");
			soloLoginValid.clickOnView(emailField);
			soloLoginValid.waitForActivity("LoginActivity", 1000);
			boolean valid = soloLoginValid.searchText("Invalid Email address!");
			if (valid) {
				assertTrue("Invalid Email address!", valid);
			} else {
				throw new TestException("Testcase failed");
			}
			soloLoginValid.waitForActivity("LoginActivity", 1000);
			// Get the view location of cancel button.
			clickCancel = (ImageView) soloLoginValid.getView(R.id.cancel_btn);
			soloLoginValid.waitForActivity("MainActivity", 1000);
			// click on cancel button
			soloLoginValid.clickOnView(clickCancel);
			soloLoginValid.waitForActivity("LoginActivity", 1000);

		} catch (TestException e) {
			e.printStackTrace();
		}

	}

}
