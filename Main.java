import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static DictionaryService service = new DictionaryService();

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/search", new SearchHandler());
        server.createContext("/suggest", new SuggestHandler());
        server.createContext("/add", new AddHandler());

        server.setExecutor(null);

        System.out.println("Server started at port 8080");

        server.start();
    }

    // SEARCH API
    static class SearchHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());

            String word = params.get("word");

            String response = service.searchWord(word);

            sendResponse(exchange, response);
        }
    }

    // SUGGEST API
    static class SuggestHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());

            String prefix = params.get("prefix");
            int k = Integer.parseInt(params.get("k"));

            List<String> suggestions = service.getSuggestions(prefix, k);

            String response = suggestions.toString();

            sendResponse(exchange, response);
        }
    }

    // ADD API
    static class AddHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());

            String word = params.get("word");

            String response = service.addWord(word);

            sendResponse(exchange, response);
        }
    }

    // Common response method
    private static void sendResponse(HttpExchange exchange, String response) throws IOException {

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    // Query parser
    private static Map<String, String> queryToMap(String query) {

        Map<String, String> result = new HashMap<>();

        if (query == null) {
            return result;
        }

        for (String pair : query.split("&")) {

            String[] entry = pair.split("=");

            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }
        }

        return result;
    }
}