package hu.nye.progkor.bringanaplo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BiciklizesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testListPageShouldReturnOk() throws Exception {
        // Csak azt nézzük, hogy bejön-e az oldal
        mockMvc.perform(get("/bringak"))
                .andExpect(status().isOk())
                .andExpect(view().name("lista"));
    }
}