package com.example.appcadastro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;

    private class UserViewHolder {

    }

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;

    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object user = getItem(position);
       /* if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_user, parent, false);
        }*/
        return convertView;
        //return super.getView(position, convertView, parent);
    }
}
