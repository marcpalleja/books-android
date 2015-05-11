package edu.upc.eetac.dsa.mpalleja.books_android;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import edu.upc.eetac.dsa.mpalleja.books_android.api.AppException;
import edu.upc.eetac.dsa.mpalleja.books_android.api.Book;
import edu.upc.eetac.dsa.mpalleja.books_android.api.BookAPI;
import edu.upc.eetac.dsa.mpalleja.books_android.api.BookCollection;
import edu.upc.eetac.dsa.mpalleja.books_android.api.Books;
import edu.upc.eetac.dsa.mpalleja.books_android.api.BooksAPI;
import edu.upc.eetac.dsa.mpalleja.books_android.api.BooksCollection;


public class BooksMainActivity extends ListActivity {

    private ArrayList<Book> booksList;


    private final static String TAG = BooksMainActivity.class.toString();
    private static final String[] items = { "lorem", "ipsum", "dolor", "sit",
            "amet", "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam", "vel",
            "erat", "placerat", "ante", "porttitor", "sodales", "pellentesque",
            "augue", "purus" };
    private ArrayAdapter<String> adapter;

    /** Called when the activity is first created. */
   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_main);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    } */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_main);
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("alicia", "alicia"
                        .toCharArray());
            }
        });
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
        (new FetchStingsTask()).execute();
    }

    private class FetchStingsTask extends
            AsyncTask<Void, Void, BookCollection> {
        private ProgressDialog pd;

        @Override
        protected BookCollection doInBackground(Void... params) {
            BookCollection books = null;
            try {
                books = BookAPI.getInstance(BooksMainActivity.this)
                        .getBooks();
            } catch (AppException e) {
                e.printStackTrace();
            }
            return books;
        }

        @Override
        protected void onPostExecute(BookCollection result) {
            ArrayList<Book> books = new ArrayList<Book>(result.getBooks());
            for (Book s : books) {
                Log.d(TAG, s.getId() + "-" + s.getTitulo());
            }
            if (pd != null) {
                pd.dismiss();
            }
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(BooksMainActivity.this);
            pd.setTitle("Searching...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }

    }

    }


