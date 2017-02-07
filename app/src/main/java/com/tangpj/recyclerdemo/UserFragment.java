package com.tangpj.recyclerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangpj.recyclerdemo.model.UserModel;
import com.tangpj.recyclerutils.divider.SimpleViewDivider;

import java.util.Arrays;

/**
 * @ClassName: UserFragment
 * @author create by Tang
 * @date date 17/1/23 下午12:09
 * @Description: TODO
 */

public class UserFragment extends Fragment {

    private UserAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        init(view);
        return view;
    }

    private void init(View view){

        RecyclerView userList = (RecyclerView) view.findViewById(R.id.fragment_list);

        adapter = new UserAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        GridLayoutManager gm = new GridLayoutManager(getActivity(),3);
        StaggeredGridLayoutManager sm = new StaggeredGridLayoutManager(6,StaggeredGridLayoutManager.VERTICAL);
        userList.setLayoutManager(sm);


        userList.setAdapter(adapter);
        adapter.setData(Arrays.asList(UserModel.values()));
        userList.addItemDecoration(SimpleViewDivider.newLinesDivider(getActivity(),16,R.drawable.divider_bg));
    }


}
