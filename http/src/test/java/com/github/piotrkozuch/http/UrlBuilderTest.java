package com.github.piotrkozuch.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlBuilderTest {

    @Test
    void should_build_url() {
        // given
        var baseUrl = "https://example.com";

        // when
        var result = UrlBuilder.urlBuilder(baseUrl).build();

        // then
        assertEquals("https://example.com", result.toString());
    }

    @Test
    void should_build_url_with_params() {
        // given
        var baseUrl = "https://example.com/";

        // when
        var result = UrlBuilder.urlBuilder(baseUrl)
            .path("path1")
            .path("path2")
            .parameter("name", "Ted")
            .parameter("surname", "Doe")
            .build();

        // then
        assertEquals("https://example.com/path1/path2?name=Ted&surname=Doe", result.toString());
    }
}