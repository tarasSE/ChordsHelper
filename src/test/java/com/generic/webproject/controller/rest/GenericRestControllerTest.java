package com.generic.webproject.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.webproject.config.WebConfig;
import com.generic.webproject.entity.GenericEntity;
import com.generic.webproject.service.CurrencyService;
import com.generic.webproject.service.GenericService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Profile("qa")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(classes = {
        InMemoryDataBaseConfig.class,
        CurrencyService.class,
        WebConfig.class,
        TestEntityFactory.class
})
@WebAppConfiguration
public abstract class GenericRestControllerTest<
        E extends GenericEntity,
        S extends GenericService<E, ?>> {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Inject
    protected TestEntityFactory testEntityFactory;

    @Autowired
    protected CurrencyService currencyService;

    @Inject
    protected WebApplicationContext ctx;

    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(ctx)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(
                        document(
                                "{method-name}/",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint())))
                .build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void create() throws Exception {
    }

    public RequestBuilder createRequestBuilder(String path, String requestBody) {
        return post(path)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void update() throws Exception {
    }

    public RequestBuilder updateRequestBuilder(String path, Integer id, String requestBody) {
        return put(path, id)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getAll() throws Exception {
    }

    public RequestBuilder getAllRequestBuilder(String path) {
        return get(path)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void getById() throws Exception {
    }

    public RequestBuilder getByIdRequestBuilder(String path, Integer id) {
        return get(path, id)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    public void deleteEntity() throws Exception {
    }

    public RequestBuilder deleteRequestBuilder(String path, Integer id) {
        return delete(path, id)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON);
    }

    protected void before() {
    }

    public ResultActions performDefaultActions(ResultActions actions) throws Exception {
        return actions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                ;
    }

    protected String saveRequestJsonString(E entity) throws JsonProcessingException {
        return objectMapper.writeValueAsString(entity);
    }

    protected List<E> jsonToList(String json) throws IOException {
        return objectMapper.readValue(
                json, objectMapper
                        .getTypeFactory()
                        .constructCollectionType(List.class, GenericEntity.class));
    }

    protected E getEntityAndSave() {
        int id = getService().create(getEntity()).getId();
        return getService().getById(id);
    }

    protected abstract E getEntity();

    protected abstract S getService();
}