package product.api.com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddANewProduct() throws Exception {
        String requestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 10, \n" +
                "            \"price\": 100.00, \n" +
                "             \"maxDiscount\": 0.1, \n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldListAllProducts() throws Exception {
        String requestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 10, \n" +
                "            \"price\": 100.00, \n" +
                "             \"maxDiscount\": 0.1, \n" +
                "}";

        String expectedResponseBody =
                "[{\"id\": 1, \"name\": \"Keyboard\", \"quantity\": 10, \"price\": 100.00," +
                        "\"maxDiscount\": 0.1}]";

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .content(requestBody)
                .contentType("application/json"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody, responseBody);
    }

    @Test
    public void shouldReturnAProductGivenItsId() throws Exception {
        String requestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 10, \n" +
                "            \"price\": 100.00, \n" +
                "             \"maxDiscount\": 0.1, \n" +
                "}";

        String expectedResponseBody =
                "[{\"id\": 1, \"name\": \"Keyboard\", \"quantity\": 10, \"price\": 100.00," +
                        "\"maxDiscount\": 0.1}]";

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .content(requestBody)
                .contentType("application/json"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/1"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody, responseBody);
    }

    @Test
    public void shouldUpdateAProduct() throws Exception {
        String requestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 10, \n" +
                "            \"price\": 100.00, \n" +
                "             \"maxDiscount\": 0.1, \n" +
                "}";
        String updateProductRequestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 25, \n" +
                "            \"price\": 200.00, \n" +
                "             \"maxDiscount\": 0.2, \n" +
                "}";

        String expectedResponseBody =
                "[{\"id\": 1, \"name\": \"Keyboard\", \"quantity\": 25, \"price\": 200.00," +
                        "\"maxDiscount\": 0.2}]";

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .content(requestBody)
                .contentType("application/json"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/products/1")
                        .content(updateProductRequestBody)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();

        assertEquals(expectedResponseBody, responseBody);
    }

    @Test
    public void shouldDeleteOneProduct() throws Exception {
        String requestBody = "{\n" +
                "          \"name\": \"Keyboard\", \n" +
                "           \"quantity\": 10, \n" +
                "            \"price\": 100.00, \n" +
                "             \"maxDiscount\": 0.1, \n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .content(requestBody)
                        .contentType("application/json"));

        mockMvc.perform(MockMvcRequestBuilders.delete("/products/1"))
                .andExpect(status().isNoContent());
    }
}
