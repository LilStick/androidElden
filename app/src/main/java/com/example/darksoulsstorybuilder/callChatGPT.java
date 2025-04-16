package com.example.darksoulsstorybuilder;

import android.app.Activity;
import android.widget.TextView;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class callChatGPT {

    public static void callChatGPT(Activity activity, String prompt, TextView storyOutput) {
        OkHttpClient client = new OkHttpClient();

        JSONObject json = new JSONObject();
        try {
            json.put("model", "gpt-3.5-turbo");
            json.put("messages", new JSONArray()
                    .put(new JSONObject()
                            .put("role", "user")
                            .put("content", prompt))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(
                json.toString(),
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer VOTRE_CLE_API")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(() -> storyOutput.setText("Erreur : " + e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String resStr = response.body().string();
                    try {
                        JSONObject resJson = new JSONObject(resStr);
                        String reply = resJson
                                .getJSONArray("choices")
                                .getJSONObject(0)
                                .getJSONObject("message")
                                .getString("content");

                        activity.runOnUiThread(() -> storyOutput.setText(reply));
                    } catch (Exception e) {
                        activity.runOnUiThread(() -> storyOutput.setText("Erreur JSON"));
                    }
                } else {
                    activity.runOnUiThread(() -> storyOutput.setText("Réponse invalide de l'API"));
                }
            }
        });
    }
}
