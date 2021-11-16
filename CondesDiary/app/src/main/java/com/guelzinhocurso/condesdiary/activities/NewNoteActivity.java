package com.guelzinhocurso.condesdiary.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.guelzinhocurso.condesdiary.R;
import com.guelzinhocurso.condesdiary.activities.DataBase.Dao;
import com.guelzinhocurso.condesdiary.activities.RecyclerView.ValuesList;

public class NewNoteActivity extends AppCompatActivity {

    private EditText editTitle, editText, editDate, editRate, editDatem, editDatey;
    private ValuesList taskLoaded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        getSupportActionBar().setTitle("Nova Anotação");

        editText = findViewById(R.id.editText);
        editTitle = findViewById(R.id.editTitle);
        editRate = findViewById(R.id.editRate);
        editRate.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "10")}); // 1-10 FilterMinMax

        editDate = findViewById(R.id.editDate);
        editDate.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "31")});

        editDatem = findViewById(R.id.editDatem);
        editDatem.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});

        editDatey = findViewById(R.id.editDatey);
        editDatey.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "2100")});


        taskLoaded = (ValuesList) getIntent().getSerializableExtra("taskSelected");

        if(taskLoaded!=null){

            //setTexts onCreate
            editText.setText(taskLoaded.getText());
            editTitle.setText(taskLoaded.getTitle());
            editDate.setText(taskLoaded.getDate());
            editRate.setText(taskLoaded.getRate());
            editDatem.setText(taskLoaded.getDatem());
            editDatey.setText(taskLoaded.getDatey());

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
                String dateTask = editDate.getText().toString();
                String rateTask = editRate.getText().toString();
                String datemTask = editDatem.getText().toString();
                String dateyTask = editDatey.getText().toString();


                final boolean condition = !textTask.isEmpty() && !titleTask.isEmpty() && !dateTask.isEmpty() && !rateTask.isEmpty() && !datemTask.isEmpty() && !dateyTask.isEmpty();
                if (taskLoaded!=null){ //update

                    if(condition){

                        ValuesList task = new ValuesList();
                        task.setId(taskLoaded.getId());
                        task.setTitle(titleTask);
                        task.setText(textTask);
                        task.setDate(dateTask);
                        task.setRate(rateTask);
                        task.setDatem(datemTask);
                        task.setDatey(dateyTask);

                        if(dao.update(task)){

                            Toast.makeText(getApplicationContext(), "Sucesso ao atualizar", Toast.LENGTH_LONG).show();
                            Intent openAllNote = new Intent(NewNoteActivity.this, AllNoteActivity.class);
                            startActivity(openAllNote);
                            finish();

                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar", Toast.LENGTH_LONG).show();
                        }

                    }


                }

                else { //save new note

                    if(condition){

                        ValuesList task = new ValuesList();
                        task.setTitle(titleTask);
                        task.setText(textTask);
                        task.setDate(dateTask);
                        task.setRate(rateTask);
                        task.setDatem(datemTask);
                        task.setDatey(dateyTask);

                        if(dao.save(task)){
                        Toast.makeText(getApplicationContext(), "Sucesso ao salvar", Toast.LENGTH_LONG).show();
                        Intent openAllNote = new Intent(NewNoteActivity.this, AllNoteActivity.class);
                        startActivity(openAllNote);
                        finish();
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Erro ao salvar", Toast.LENGTH_LONG).show();
                        }
                    }

                }

                break;

            case R.id.backItem:

                Toast.makeText(getApplicationContext(), "Voltar", Toast.LENGTH_LONG).show();
                finish();

        }
        return super.onOptionsItemSelected(item);
    }
}