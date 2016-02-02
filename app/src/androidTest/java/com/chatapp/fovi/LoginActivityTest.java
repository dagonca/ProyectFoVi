package com.chatapp.fovi;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseUser;

import junit.framework.TestCase;

/**
 * Created by 21438581 on 02/02/2016.
 */
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    private LoginActivity actividad;
    private EditText editUser;
    private EditText editPass;
    private Button btnLog;

    public LoginActivityTest() {
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

    private static final String USER = "test";
    private static final String PASS = "test";



    public void testLoginValues() throws Exception{

        if(ParseUser.getCurrentUser()!=null)
            ParseUser.logOut();

        //on value 1 entry
        TouchUtils.tapView(this, editUser);
        getInstrumentation().sendStringSync(USER);
        // now on value2 entry
        TouchUtils.tapView(this, editPass);
        getInstrumentation().sendStringSync(PASS);
        // now on Add button
        TouchUtils.clickView(this, btnLog);


        assertNotNull("Log in...", ParseUser.logIn(USER, PASS));
    }




}