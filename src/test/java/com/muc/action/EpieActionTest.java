package com.muc.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muc.epie.EpieApplication;
import com.muc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EpieApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EpieActionTest {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testSend() throws Exception {

        //调用接口，传入添加的用户参数
        mockMvc.perform(MockMvcRequestBuilders.post("/epie/addWorks")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("openid","oHafd4pc-DOL3wucguMVB32Dj9-4")
                .param("workType","3")
                .param("workTitel","集成测试1")
                .param("workDesc","集成测试1")
                .param("workPoster","")
                .param("workPath","1593530036911.jpg")


        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();


    }
}