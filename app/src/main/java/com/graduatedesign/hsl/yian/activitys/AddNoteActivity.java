package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.Note;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesogene on 6/6/16.
 */
public class AddNoteActivity extends FragmentActivity implements View.OnClickListener{
    ImageView img_back;
    Button add_commit;
    TextView title;
    EditText edit_note;
    private List<Note> notes = new ArrayList<Note>();
    RequestClient requestClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        add_commit = (Button)findViewById(R.id.bt_save);
        add_commit.setOnClickListener(this);
        title = (TextView)findViewById(R.id.title);
        edit_note = (EditText)findViewById(R.id.edit_note);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl+"/note/",gson);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                AddNoteActivity.this.finish();
                break;
            case R.id.bt_save:
                //添加笔记

                String content = edit_note.getText().toString();
                notes.add(new Note(1,content,1));
                Call<List<Note>> call = requestClient.addNote(notes);
                call.enqueue(new Callback<List<Note>>() {
                    @Override
                    public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<Note>> call, Throwable t) {

                    }
                });
                AddNoteActivity.this.finish();
                break;
        }
    }
}
