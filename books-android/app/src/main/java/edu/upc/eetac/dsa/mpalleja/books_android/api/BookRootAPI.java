package edu.upc.eetac.dsa.mpalleja.books_android.api;

/**
 * Created by Marc on 09/05/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class BookRootAPI {

    private Map<String, Link> links;

    public BookRootAPI() {
        links = new HashMap<String, Link>();
    }

    public Map<String, Link> getLinks() {
        return links;
    }

}