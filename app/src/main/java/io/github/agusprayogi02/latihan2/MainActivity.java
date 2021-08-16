package io.github.agusprayogi02.latihan2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.agusprayogi02.latihan2.adapters.NegaraAdapter;
import io.github.agusprayogi02.latihan2.models.NegaraModel;

public class MainActivity extends AppCompatActivity implements NegaraAdapter.OnNegaraClickListener {

    public List<NegaraModel> listNegara = new ArrayList<>();
    public RecyclerView.LayoutManager layoutManager;
    public NegaraAdapter adapter;
    public RecyclerView rv;
    public String[] namaNegara = new String[]{"Indonesia", "Malaysia", "Singapore", "Italia", "Inggris", "Belanda", "Argentina", "Chile", "Mesir", "Uganda"};
    public String[] imgCode = new String[]{"ID", "MY", "SG", "IT", "GB", "NL", "AR", "CL", "EG", "UG"};
    public String[] ibuKota = new String[]{"Jakarta", "Kuala Lumpur", "Singapore", "Rome", "London", "Amsterdam", "Buenos Aires", "Santiago de Chile", "Kairo", "Kampala"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvView);

        for (int i = 0; i < namaNegara.length; i++) {
            NegaraModel negara = new NegaraModel(namaNegara[i], ibuKota[i], ("https://www.countryflags.io/" + imgCode[i] + "/shiny/64.png"));
            listNegara.add(negara);
        }
        adapter = new NegaraAdapter(listNegara);
        adapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(layoutManager);
    }


    @Override
    public void onClick(View view, int position) {
        NegaraModel item = listNegara.get(position);
        Toast.makeText(this, "Negara yang dipilih: " + item.getNama() + " ,Ibukotanya " + item.getIbuKota(), Toast.LENGTH_SHORT).show();
    }
}