package com.chatapp.fovi;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

public class MyTestCase extends ActivityInstrumentationTestCase2<LoginActivity> {

	private EditText editUser;
	private EditText editPass;
	private Button btnLog;
	private LoginActivity actividad;

	public MyTestCase() {
//		super("com.example.calc", MainActivity.class);
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		actividad = getActivity();
		editUser = (EditText) actividad.findViewById(R.id.usernameField);
		editPass = (EditText) actividad.findViewById(R.id.passwordField);
		btnLog = (Button) actividad.findViewById(R.id.loginButton);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	private static final String USER= "test";
	private static final String PASS = "test";


	public void testAddValues() throws Exception {
        //on value 1 entry
		TouchUtils.tapView(this,editUser);
		getInstrumentation().sendStringSync(USER);
		// now on value2 entry
		TouchUtils.tapView(this,editPass);
		getInstrumentation().sendStringSync(PASS);
		// now on Add button
		TouchUtils.clickView(this,btnLog);

		assertNotNull("Add result should be...", ParseUser.logIn(USER,PASS));
	}

}
