package ControllerTest;

import com.example.DominosEurekaClient.Controller.DominosController;
import com.example.DominosEurekaClient.Model.Dominoes;
import com.example.DominosEurekaClient.Service.DominosService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@WebMvcTest(DominosController.class)
@RunWith(SpringRunner.class)
public class ControllerTest {
    @MockBean
    DominosService service;

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void getDominosTest() throws Exception {
        Dominoes d = new Dominoes(1,"mohini","pune");
        when((Publisher<?>) service.getDominoes(1)).thenReturn(d);
        this.mockMvc.perform(get("/getDominos/{id}",1)
                .contentType("application/json"))
                .andExpect(status().isOk());

    }

}
