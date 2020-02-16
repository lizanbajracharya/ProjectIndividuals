package com.example.hamrobook_ebookstore;

import com.example.hamrobook_ebookstore.bll.SignupBll;
import com.example.hamrobook_ebookstore.model.User;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SignUpTest {
    @Test
    public void SignUpPass(){
        User user=new User("98622","soft","asd","lizan");
        SignupBll signupBll=new SignupBll();
        boolean result=signupBll.Useradd(user);
        assertEquals(true,result);
    }
}
