package com.example.qasim.whatsappclone;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qasim.whatsappclone.model.Person;

import java.util.ArrayList;

public class NewPerson extends AppCompatActivity {
    private EditText editText_name;
    private EditText editText_number;
    private EditText editText_email;
    private EditText editText_zipcode;
    private Button button_save;
    private Button button_show;
    private TextView textView;
    private SQLDatabaseAdapter dbAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        editText_name=findViewById(R.id.edt_name);
        editText_number=findViewById(R.id.edt_phone_);
        editText_email=findViewById(R.id.edt_email);
        editText_zipcode=findViewById(R.id.edt_zip);
        button_save=findViewById(R.id.btn_save);
        button_show=findViewById(R.id.btn_show);
        textView=findViewById(R.id.text_contacts);
        dbAdapter=new SQLDatabaseAdapter(this);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContacts();
            }
        });
        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShowClick();
            }
        });


    }

    private void saveContacts() {
        String name=editText_name.getText().toString();
        String num=editText_number.getText().toString();
        int number=Integer.parseInt(num);
        String email=editText_email.getText().toString();
        String zipcode=editText_zipcode.getText().toString();
        Person person=new Person(name,number,email,zipcode);
        dbAdapter.insertPerson(person);
        finish();
    }
    private void onShowClick() {
        ArrayList<Person> persons = dbAdapter.getAllPersons();
        String personsText = "";

        for (int i = 0; i < persons.size(); i++) {

            String person = persons.get(i).getName() + " \t" + persons.get(i).getNumber() + "\n";
            personsText += person;
        }

        textView.setText(personsText);
    }
}