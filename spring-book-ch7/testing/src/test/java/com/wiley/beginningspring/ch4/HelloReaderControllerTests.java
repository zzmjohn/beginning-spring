package com.wiley.beginningspring.ch4;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * User: mertcaliskan
 * Date: 18/06/14
 */
public class HelloReaderControllerTests extends BaseControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void helloReaderControllerWorksOk() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(model().attribute("message", "Hello Reader!"))
                .andExpect(view().name("helloReader"));
    }

    @Test
    public void helloReaderControllerWorksOkWithAnUnmappedUrl() throws Exception {
        mockMvc.perform(post("/helloMyLove"))
                .andExpect(status().isNotFound());
    }
}
