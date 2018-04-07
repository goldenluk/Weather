package ru.golden.weather.model;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ResponseFactory {

    public static Response getResponse(final String url) throws IOException {
        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        return client.newCall(request).execute();
    }
}
