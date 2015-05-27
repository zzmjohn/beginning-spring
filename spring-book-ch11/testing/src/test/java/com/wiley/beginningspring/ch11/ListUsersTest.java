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
public class ListUsersTest {

    @Test
    public void listUsersWorksOK() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List> result = template.getForEntity("http://localhost:8080/basic/rest/users", List.class);
        assertNotNull(result);
        assertNotNull(result.getBody());
        assertThat(result.getBody().size(), is(2));
        assertThat(((Map) result.getBody().get(0)).entrySet().toArray()[1].toString(), is("name=Mert Caliskan"));
        assertThat(((Map) result.getBody().get(1)).entrySet().toArray()[1].toString(), is("name=Kenan Sevindik"));
    }
}
