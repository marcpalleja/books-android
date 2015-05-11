package edu.upc.eetac.dsa.mpalleja.books_android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import edu.upc.eetac.dsa.felipeboix.books_android.api.AppException;
import edu.upc.eetac.dsa.felipeboix.books_android.api.Book;
import edu.upc.eetac.dsa.felipeboix.books_android.api.BookAPI;
import edu.upc.eetac.dsa.mpalleja.books_android.api.Book;
import edu.upc.eetac.dsa.mpalleja.books_android.api.Books;
import edu.upc.eetac.dsa.mpalleja.books_android.api.BooksAPI;

/**
 * Created by Marc on 09/05/2015.
 */
public class BooksDetailActivity extends Activity{
    private final static String TAG = BooksDetailActivity.class.getName();
    private class FetchStingTask extends AsyncTask<String, Void, Book> {
        private ProgressDialog pd;

        @Override
        protected Book doInBackground(String... params) {
            Book book = null;
            try {
                book = BookAPI.getInstance(BooksDetailActivity.this)
                        .getSting(params[0]);
            } catch (AppException e) {
                Log.d(TAG, e.getMessage(), e);
            }
            return book;
        }

        @Override
        protected void onPostExecute(Book result) {
            loadBook(result);
            if (pd != null) {
                pd.dismiss();
            }
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(BooksDetailActivity.this);
            pd.setTitle("Loading...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_layout);
    }
    private void loadBook(Book book) {
        TextView tvDetailTitulo = (TextView) findViewById(R.id.tvDetailTitulo);
        TextView tvDetailLengua = (TextView) findViewById(R.id.tvDetailLengua);
        TextView tvDetailEdicion = (TextView) findViewById(R.id.tvDetailEdicion);
        TextView tvDetailEditorial = (TextView) findViewById(R.id.tvDetailEditorial);

        tvDetailTitulo.setText(book.getTitulo());
        tvDetailLengua.setText(book.getLengua());
        tvDetailEdicion.setText(book.getEdicion());
        tvDetailEditorial.setText(book.getEditorial());
    }
}
