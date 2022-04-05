package ua.azbest.ProxyBandTask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.azbest.ProxyBandTask.model.User;
import ua.azbest.ProxyBandTask.repositories.UserRepository;
import ua.azbest.ProxyBandTask.services.UserService;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsers() throws Exception {
        User user1 = new User("Name1", "name1@email.com");
        User user2 = new User("Name2", "name2@email.com");
        User user3 = new User("Name3", "name3@email.com");
        List<User> userList = List.of(user1, user2, user3);

        Mockito.when(userService.getAllUsers()).thenReturn(userList);

        String URI = "/users";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
                .accept(
                        MediaType.APPLICATION_JSON
                );

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(userList);
        String outputJson = result.getResponse().getContentAsString();
        assertThat(outputJson).isEqualTo(expectedJson);

    }

    private String mapToJson(Object object) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}