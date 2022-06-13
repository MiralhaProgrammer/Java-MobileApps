package com.guelzinhocurso.condesdiary.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.guelzinhocurso.condesdiary.R;
import com.guelzinhocurso.condesdiary.activities.DataBase.Dao;
import com.guelzinhocurso.condesdiary.activities.RecyclerView.ValuesList;

public class NewNoteActivity extends AppCompatActivity {

    private EditText editTitle, editText;
    private ValuesList taskLoaded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        getSupportActionBar().setTitle("Nova Anotação");

        editText = findViewById(R.id.editText);
        editTitle = findViewById(R.id.editTitle);

        taskLoaded = (ValuesList) getIntent().getSerializableExtra("taskSelected");

        if(taskLoaded!=null){

            //setTexts onCreate
            editText.setText(taskLoaded.getText());
            editTitle.setText(taskLoaded.getTitle());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newnote, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.saveItem:

                Dao dao = new Dao(getApplicationContext());

                String textTask = editText.getText().toString();
                String titleTask = editTitle.getText().toString();

                if (taskLoaded!=null){ //update

                    if(!textTask.isEmpty() && !titleTask.isEmpty()){

                        ValuesList task = new ValuesList();
                        task.setId(taskLoaded.getId());
                        task.setTitle(titleTask);
                        task.setText(textTask);

                        if(dao.update(task)){

                            Toast.makeText(getApplicationContext(), "Sucesso ao atualizar", Toast.LENGTH_LONG).show();
                            finish();

                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar", Toast.LENGTH_LONG).show();
                        }

                    }


                }

                else { //save new note

                    if(!textTask.isEmpty() && !titleTask.isEmpty()){

                        ValuesList task = new ValuesList();
                        task.setTitle(titleTask);
                        task.setText(textTask);

                        if(dao.save(task)){
                        Toast.makeText(getApplicationContext(), "Sucesso ao salvar", Toast.LENGTH_LONG).show();
                        finish();
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Erro ao salvar", Toast.LENGTH_LONG).show();
                        }
                    }

                }

                break;

            case R.id.backItem:

                Toast.makeText(getApplicationContext(), "Voltar", Toast.LENGTH_LONG).show();finish();

        }
        return super.onOptionsItemSelected(item);
    }
}