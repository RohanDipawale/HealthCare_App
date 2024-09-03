package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctorDetails1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898765423", "600"},
                    {"Doctor Name : Suraj Singh", "Hospital Address : mumbai", "Exp : 10yrs", "Mobile No: 9892345653", "500"},
                    {"Doctor Name : Rohit sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 9898764553", "900"},
                    {"Doctor Name : Ajay kumar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No: 9894565423", "200"},
                    {"Doctor Name : suraj sharma", "Hospital Address : mumbai", "Exp : 12yrs", "Mobile No: 9898765423", "300"},
            };

    private String[][] doctorDetails2 =
            {
                    {"Doctor Name : viraj sharma", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898765423", "600"},
                    {"Doctor Name : gunjan  Singh", "Hospital Address : mumbai", "Exp : 10yrs", "Mobile No: 9892345653", "500"},
                    {"Doctor Name : Rahul sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 9898764553", "900"},
                    {"Doctor Name : Ajay kumar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No: 9894565423", "200"},
                    {"Doctor Name : suryakumar sharma", "Hospital Address : mumbai", "Exp : 12yrs", "Mobile No: 9898765423", "300"},
            };

    private String[][] doctorDetails3 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898765423", "600"},
                    {"Doctor Name : Suraj Singh", "Hospital Address : mumbai", "Exp : 10yrs", "Mobile No: 9892345653", "500"},
                    {"Doctor Name : Rohit sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 9898764553", "900"},
                    {"Doctor Name : Ajay kumar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No: 9894565423", "200"},
                    {"Doctor Name : suraj sharma", "Hospital Address : mumbai", "Exp : 12yrs", "Mobile No: 9898765423", "300"},
            };

    private String[][] doctorDetails4 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898765423", "600"},
                    {"Doctor Name : Suraj Singh", "Hospital Address : mumbai", "Exp : 10yrs", "Mobile No: 9892345653", "500"},
                    {"Doctor Name : Rohit sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 9898764553", "900"},
                    {"Doctor Name : Ajay kumar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No: 9894565423", "200"},
                    {"Doctor Name : suraj sharma", "Hospital Address : mumbai", "Exp : 12yrs", "Mobile No: 9898765423", "300"},
            };

    private String[][] doctorDetails5 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898765423", "600"},
                    {"Doctor Name : Suraj Singh", "Hospital Address : mumbai", "Exp : 10yrs", "Mobile No: 9892345653", "500"},
                    {"Doctor Name : Rohit sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 9898764553", "900"},
                    {"Doctor Name : Ajay kumar", "Hospital Address : Nagpur", "Exp : 15yrs", "Mobile No: 9894565423", "200"},
                    {"Doctor Name : suraj sharma", "Hospital Address : mumbai", "Exp : 12yrs", "Mobile No: 9898765423", "300"},
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctorDetails1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctorDetails2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctorDetails3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctorDetails4;
        else
            doctor_details = doctorDetails5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}