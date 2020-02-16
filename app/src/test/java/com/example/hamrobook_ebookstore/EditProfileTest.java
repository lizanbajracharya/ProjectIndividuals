package com.example.hamrobook_ebookstore;

import com.example.hamrobook_ebookstore.bll.Edituserbll;
import com.example.hamrobook_ebookstore.bll.SignupBll;
import com.example.hamrobook_ebookstore.model.User;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EditProfileTest {
    @Test
    public void SignUpPass(){
        User user=new User("98622","admin","asdad","admin");
        Edituserbll edituserbll=new Edituserbll();
        boolean result=edituserbll.Useredit(user);
        assertEquals(false,result);
    }
}
