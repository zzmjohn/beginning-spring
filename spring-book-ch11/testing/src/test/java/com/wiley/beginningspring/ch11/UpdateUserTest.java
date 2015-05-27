package com.wiley.beginningspring.ch11;

import com.wiley.beginningspring.ch11.domain.User;
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
public class UpdateUserTest {

    @Test
    public void updateUserWorksOK() {
        RestTemplate template = new RestTemplate();
        User user = new User(3, "Funda Caliskan");
        template.put("http://localhost:8080/rest/users/3", user);

        ResponseEntity<List> resultList = template.getForEntity("http://localhost:8080/basic/rest/users", List.class);
        assertNotNull(resultList);
        assertNotNull(resultList.getBody());
        assertThat(resultList.getBody().size(), is(3));
        assertThat(((Map) resultList.getBody().get(0)).entrySet().toArray()[1].toString(), is("name=Mert Caliskan"));
        assertThat(((Map) resultList.getBody().get(1)).entrySet().toArray()[1].toString(), is("name=Kenan Sevindik"));
        assertThat(((Map) resultList.getBody().get(2)).entrySet().toArray()[1].toString(), is("name=Funda Caliskan"));
    }
}
