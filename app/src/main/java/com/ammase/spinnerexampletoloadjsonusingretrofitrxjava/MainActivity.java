package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.DataItem;
import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.ResponseGetProv;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;
    private Spinner spinner;
    private List<DataItem> listItemProv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        presenter.LoadDataSpinner();

        spinner = (Spinner) findViewById(R.id.spinner_prov);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void handleSpinnerSuccess(ResponseGetProv responseAuth) {
        listItemProv = new ArrayList<>(responseAuth.getData());
        ProvAdapter adapter = new ProvAdapter(this,R.layout.item_list_spinner , listItemProv);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int position, long l) {
                Toast.makeText(getApplicationContext(), "Click "+ String.valueOf(listItemProv.get(position).getNama()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void handleSpinnerError(String error) {

    }
}
