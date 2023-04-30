package com.caterpillar.dasha.demo.restapi;

import com.caterpillar.dasha.demo.entity.Eco1;
import com.caterpillar.dasha.demo.entity.Eco2;
import com.caterpillar.dasha.demo.repo.RepoEco1;
import com.caterpillar.dasha.demo.repo.RepoEco2;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Eco2ControllerTest {
    static String address = "/restapi/eco2";
    static ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    Eco2 eco = new Eco2(1,"sorok",true);
    @MockBean
    RepoEco2 repoEco2;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getEl() throws Exception{

        when(repoEco2.findById(1)).thenReturn(Optional.of(eco));

        var result = mockMvc.perform(get(address +"/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        var expected = objectWriter.writeValueAsString(eco).replaceAll("\n","").replaceAll(" ","");

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAll() throws Exception{
        List list = List.of(eco, new Eco2(2,"EKB",true));
        when(repoEco2.findAll()).thenReturn(list);
        var result = mockMvc.perform(get(address)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        var expected = objectWriter.writeValueAsString(list).replaceAll("\n","").replaceAll(" ","");
        Assertions.assertEquals(expected, result);
    }
    @Test
    void deleteElem() throws Exception{

        when(repoEco2.findById(1)).thenReturn(Optional.of(eco));
        eco.setCheck_text(false);
        when(repoEco2.save(eco)).thenReturn(eco);

        var result = mockMvc.perform(delete(address +"/1")).andReturn().getResponse().getContentAsString();
        var expected = objectWriter.writeValueAsString(eco).replaceAll("\n","").replaceAll(" ","");
        eco.setCheck_text(true);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void updateElem() throws Exception{
        when(repoEco2.findById(1)).thenReturn(Optional.of(eco));
        eco.setLevel("pyatsot");
        when(repoEco2.save(eco)).thenReturn(eco);
        var result = mockMvc.perform(patch(address +"/1?level=pyatsot")).andReturn().getResponse().getContentAsString();
        var expected = objectWriter.writeValueAsString(eco).replaceAll("\n","").replaceAll(" ","");
        System.out.println("\n\n\n-----\n"+result+"\n------\n\n");
        Assertions.assertEquals(expected, result);
    }
}
