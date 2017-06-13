package com.listne;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.listne.adapter.ListNeAdapter;
import com.listne.api.ApiInterface;
import com.listne.model.ListNe;
import com.listne.model.Ne;
import com.listne.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Ne> listNe;
    private ListNeAdapter adapter;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading . . .");
        progressDialog.setMessage("Load Data Network Element");
        progressDialog.setCancelable(false);


        listNe = new ArrayList<Ne>();
        adapter = new ListNeAdapter(listNe, MainActivity.this);
        recyclerView =(RecyclerView) findViewById(R.id.rv_listne);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        getDataNe();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Reload Data Ne", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getDataNe();
            }
        });
    }

    private void getDataNe(){
        progressDialog.show();
        apiInterface = Utils.getAPIService();

        apiInterface.getListNe().enqueue(new Callback<ListNe>() {
            @Override
            public void onResponse(Call<ListNe> call, Response<ListNe> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    listNe.clear();
                    for (Ne ne : response.body().getResult()){
                        listNe.add(ne);
                    }

                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ListNe> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
