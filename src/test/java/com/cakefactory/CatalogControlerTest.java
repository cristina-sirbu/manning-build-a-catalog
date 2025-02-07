package com.cakefactory;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CatalogController.class)
public class CatalogControlerTest {

    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CatalogService catalogService;

    @BeforeEach
    void setUp() {
        this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("/catalog returns the catalog page")
    void returnsCatalogPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/catalog"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("index page return a list of items from the database")
    void returnsListOfItemsFromDb() throws Exception {
        final String expectedTitle = "Red Velvet";
        mockItems(expectedTitle, BigDecimal.valueOf(3));

        HtmlPage page = webClient.getPage("http://localhost/catalog");

        assertThat(page.querySelectorAll(".item-title")).anyMatch(domElement -> expectedTitle.equals(domElement.asNormalizedText()));
    }

    private void mockItems(String title, BigDecimal price) {
        when(catalogService.getItems()).thenReturn(Collections.singletonList(new Item(title, price)));
    }

}
