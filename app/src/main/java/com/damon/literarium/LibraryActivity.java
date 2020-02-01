package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.damon.literarium.adapters.IssuedBooksAdapter;
import com.damon.literarium.adapters.LibraryBooksAdapter;
import com.damon.literarium.data.Registry;

public class LibraryActivity extends AppCompatActivity {

    private TextView txtSearch;

    private RecyclerView rvIssued;
    private IssuedBooksAdapter issuedAdapter;

    private RecyclerView rvLibrary;
    private LibraryBooksAdapter libraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        this.initViews();
    }

    public void initViews()
    {
        this.txtSearch = this.findViewById(R.id.txtSearchBook);
        this.txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //TODO: pass the current entered text to adapter.
                libraryAdapter.searchBook(txtSearch.getText().toString());
            }
        });
        this.rvIssued = this.findViewById(R.id.rvIssuedBooks);
        this.issuedAdapter = new IssuedBooksAdapter(Registry.getInstance().getIssuedBooks());
        this.rvIssued.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.rvIssued.setAdapter(this.issuedAdapter);

        this.rvLibrary = this.findViewById(R.id.rvLibrary);
        this.rvLibrary.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.libraryAdapter = new LibraryBooksAdapter(Registry.getInstance().getLibraryBooks(), false);
        this.rvLibrary.setAdapter(this.libraryAdapter);

    }

}
