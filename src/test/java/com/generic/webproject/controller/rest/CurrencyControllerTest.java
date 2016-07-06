//package com.generic.webproject.controller.rest;
//
//import org.springframework.restdocs.payload.FieldDescriptor;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class CurrencyControllerTest extends GenericRestControllerTest<Currency, CurrencyService> {
//
//    private static final String endpoint = "/currency";
//
//    public void create() throws Exception {
//        Currency currency = getService().create(getEntity());
//        String requestBody = saveRequestJsonString(currency);
//
//        ResultActions resultActions = mockMvc.perform(
//                createRequestBuilder(
//                        endpoint,
//                        requestBody
//                ));
//
//        performDefaultActions(resultActions)
//                .andExpect(jsonPath("$.id", greaterThan(currency.getId())))
//                .andExpect(jsonPath("$.name", is(currency.getName())))
//                .andExpect(jsonPath("$.shortName", is(currency.getShortName())))
//                .andExpect(jsonPath("$.symbol", is(String.valueOf(currency.getSymbol()))))
//                .andExpect(jsonPath("$.code", is(currency.getCode())))
//                .andDo(
//                        document("Create Currency",
//                                responseFields(
//                                        fieldWithPath("id")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Unique currency id"),
//                                        fieldWithPath("name")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency name"),
//                                        fieldWithPath("shortName")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency short name"),
//                                        fieldWithPath("symbol")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency symbol"),
//                                        fieldWithPath("code")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Currency code")
//                                )))
//                .andDo(print());
//    }
//
//    @Override
//    public void update() throws Exception {
//        Currency currency = getEntityAndSave();
//        Currency updatedCurrency = getEntity();
//        String requestBody = saveRequestJsonString(updatedCurrency);
//
//        ResultActions resultActions =
//                mockMvc.perform(
//                        updateRequestBuilder(
//                                endpoint + "/{id}",
//                                currency.getId(),
//                                requestBody
//                        ));
//        performDefaultActions(resultActions)
//                .andExpect(jsonPath("$.id", is(currency.getId())))
//                .andExpect(jsonPath("$.name", is(updatedCurrency.getName())))
//                .andExpect(jsonPath("$.shortName", is(updatedCurrency.getShortName())))
//                .andExpect(jsonPath("$.symbol", is(String.valueOf(updatedCurrency.getSymbol()))))
//                .andExpect(jsonPath("$.code", is(updatedCurrency.getCode())))
//                .andDo(
//                        document("Update Currency",
//                                responseFields(
//                                        fieldWithPath("id")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Unique currency id"),
//                                        fieldWithPath("name")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency name"),
//                                        fieldWithPath("shortName")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency short name"),
//                                        fieldWithPath("symbol")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency symbol"),
//                                        fieldWithPath("code")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Currency code")
//                                )))
//                .andDo(print());
//    }
//
//    @Override
//    public void getAll() throws Exception {
//        List<Currency> currencies = getService().getAll();
//        ResultActions resultActions = mockMvc.perform(getAllRequestBuilder(endpoint));
//        performDefaultActions(resultActions)
//                .andExpect(content().string(objectMapper.writeValueAsString(currencies)))
//                .andDo(
//                        document("Get all  Currencies",
//                                responseFields(new FieldDescriptor[]{
//                                        fieldWithPath("[]")
//                                                .description("List of Currency'es"),
//                                        fieldWithPath("[].id")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Unique currency id"),
//                                        fieldWithPath("[].name")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency name"),
//                                        fieldWithPath("[].shortName")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency short name"),
//                                        fieldWithPath("[].symbol")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency symbol"),
//                                        fieldWithPath("[].code")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Currency code")}
//                                )))
//                .andDo(print());
//    }
//
//    @Override
//    public void getById() throws Exception {
//        Currency currency = getEntityAndSave();
//        ResultActions resultActions =
//                mockMvc.perform(
//                        getByIdRequestBuilder(
//                                endpoint + "/{id}",
//                                currency.getId()
//                        ));
//
//        performDefaultActions(resultActions)
//                .andExpect(jsonPath("$.id", is(currency.getId())))
//                .andExpect(jsonPath("$.name", is(currency.getName())))
//                .andExpect(jsonPath("$.shortName", is(currency.getShortName())))
//                .andExpect(jsonPath("$.symbol", is(String.valueOf(currency.getSymbol()))))
//                .andExpect(jsonPath("$.code", is(currency.getCode())))
//                .andDo(
//                        document("Get Currency by ID",
//                                responseFields(
//                                        fieldWithPath("id")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Unique currency id"),
//                                        fieldWithPath("name")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency name"),
//                                        fieldWithPath("shortName")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency short name"),
//                                        fieldWithPath("symbol")
//                                                .type(JsonFieldType.STRING)
//                                                .description("Currency symbol"),
//                                        fieldWithPath("code")
//                                                .type(JsonFieldType.NUMBER)
//                                                .description("Currency code")
//                                )))
//                .andDo(print());
//    }
//
//    @Override
//    public void deleteEntity() throws Exception {
//        Currency currency = getEntityAndSave();
//        mockMvc.perform(
//                deleteRequestBuilder(
//                        endpoint + "/{id}",
//                        currency.getId()))
//                .andExpect(status().isOk())
//                .andDo(
//                        document("Delete Currency by ID"))
//
//                .andDo(print());
//    }
//
//    @Override
//    protected Currency getEntity() {
//        return testEntityFactory.getCurrency();
//    }
//
//    @Override
//    protected CurrencyService getService() {
//        return currencyService;
//    }
//}
