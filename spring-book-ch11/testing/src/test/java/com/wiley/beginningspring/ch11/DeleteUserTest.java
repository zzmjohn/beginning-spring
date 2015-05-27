package com.wiley.beginningspring.ch11;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by mertcaliskan
 * on 05/10/14.
 */
public class DeleteUserTest {

    @Test
    public void deleteUserWorksOK() {
        RestTemplate template = new RestTemplate();
        template.delete("http://localhost:8080/rest/users/3");

        ResponseEntity<List> resultList = template.getForEntity("http://localhost:8080/basic/rest/users", List.class);
        assertNotNull(resultList);
        assertNotNull(resultList.getBody());
        assertThat(resultList.getBody().size(), is(2));

        assertThat(((Map) resultList.getBody().get(0)).entrySet().toArray()[1].toString(), is("name=Mert Caliskan"));
        assertThat(((Map) resultList.getBody().get(1)).entrySet().toArray()[1].toString(), is("name=Kenan Sevindik"));
    }
}
