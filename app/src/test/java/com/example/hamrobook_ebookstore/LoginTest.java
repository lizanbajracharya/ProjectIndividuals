package com.example.hamrobook_ebookstore;

import com.example.hamrobook_ebookstore.bll.LoginBll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void testLogin() {
        LoginBll loginBll = new LoginBll();
        boolean result = loginBll.checkUser("admin", "admin");
        assertEquals(true, result);
    }

    //Fail Login
    @Test
    public void testLoginFail() {
        LoginBll loginBll = new LoginBll();
        boolean result = loginBll.checkUser("asdasd", "FailedLogin123");
        assertEquals(false, result);
    }
}
