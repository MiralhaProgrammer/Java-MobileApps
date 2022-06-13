package com.guelzinhocurso.condesdiary.activities.DataBase;

import com.guelzinhocurso.condesdiary.activities.RecyclerView.ValuesList;

import java.util.List;

public interface iDao {

    public boolean save(ValuesList valuesList);
    public boolean update(ValuesList valuesList);
    public boolean delete(ValuesList valuesList);
    public List<ValuesList>list();


}
