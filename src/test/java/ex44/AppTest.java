package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void searchForNameInJsonArray() throws IOException {
        AtomicReference<JsonObject> obj = new AtomicReference<>();
        JsonArray jsonArray = App.ParseJsonToProductArray();
        assertTrue(App.SearchForNameInJsonArray(jsonArray, "widget", obj));
        assertTrue(App.SearchForNameInJsonArray(jsonArray, "thing", obj));
        assertFalse(App.SearchForNameInJsonArray(jsonArray, "dsfhg", obj));
    }

    @Test
    void parseJsonToProductArray() throws IOException {
        assertEquals("Widget", App.ParseJsonToProductArray().get(0).getAsJsonObject().get("name").getAsString());
    }
}