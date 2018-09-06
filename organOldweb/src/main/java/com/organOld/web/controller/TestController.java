package com.organOld.web.controller.out;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.oService.contract.Conse;
import com.organOld.web.controller.OldmanController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by netlab606 on 2018/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({@ContextConfiguration(name = "parent",locations = "classpath:spring-security.xml"),
                   @ContextConfiguration(name = "child",locations = "classpath:spring-web.xml")

})
public class TestController {
    private MockMvc mockMvc;
    private WebApplicationContext wac;

    private FileController fileController;
    private OldmanController oldmanController;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(wac).build();
    }
    @Test
    public void testServer()throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/oldman/35/info")).andReturn();
    }

}
