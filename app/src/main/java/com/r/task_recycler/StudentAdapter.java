package com.r.task_recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;

    StudentAdapter(List<Student>students)
    {
        this.students = students;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.txt1.setText(student.getRoll());
        viewHolder.txt2.setText(student.getName());


    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
         private TextView txt1;
         private TextView txt2;


        public ViewHolder(View itemView) {
            super(itemView);
            txt1 =  itemView.findViewById(R.id.text1);
            txt2 =  itemView.findViewById(R.id.text2);

        }
    }


}
