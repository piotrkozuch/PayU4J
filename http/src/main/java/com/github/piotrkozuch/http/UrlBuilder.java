package com.github.piotrkozuch.http;

import com.github.piotrkozuch.http.exception.UrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static com.github.piotrkozuch.validation.Validation.required;
import static java.util.stream.Collectors.joining;

public class UrlBuilder {

    private final URL baseUrl;
    private final Map<String, String> params = new LinkedHashMap<>();
    private final Set<String> paths = new LinkedHashSet<>();

    private UrlBuilder(URI baseUri) {
        this.baseUrl = url(required("baseUri", baseUri));
    }

    public static UrlBuilder urlBuilder(URI baseUrl) {
        return new UrlBuilder(baseUrl);
    }

    public static UrlBuilder urlBuilder(String baseUrl) {
        return new UrlBuilder(URI.create(baseUrl));
    }

    public UrlBuilder parameter(String key, String value) {
        params.put(key, value);
        return this;
    }

    public UrlBuilder path(String path) {
        paths.add(path);
        return this;
    }

    public URL build() {
        var url = baseUrl.toString().endsWith("/") ? baseUrl : baseUrl + "/";
        return url(URI.create(url + buildPath() + buildParams()));
    }

    private String buildParams() {
        if (params.isEmpty()) {
            return "";
        }

        return "?" + params.entrySet()
            .stream()
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(joining("&"));
    }

    private String buildPath() {
        if (paths.isEmpty()) {
            return "";
        }

        return paths.stream()
            .collect(joining("/"));
    }

    private URL url(URI uri) {
        try {
            return uri.toURL();
        } catch (MalformedURLException e) {
            throw new UrlException(e);
        }
    }
}
