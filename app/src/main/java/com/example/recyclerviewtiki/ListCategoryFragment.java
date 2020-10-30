package com.example.recyclerviewtiki;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewtiki.model.Category;
import com.example.recyclerviewtiki.model.CategoryLab;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListCategoryFragment extends Fragment {
    RecyclerView recyclerCategory;
    List<Category> categories;
    CategoryAdapter categoryAdapter;
    private CallBack callBack;

    public interface CallBack{
        void onSelectItem(int id);
    }

    public ListCategoryFragment() {
        // Required empty public constructor
    }

    public static ListCategoryFragment newInstance(String param1, String param2) {
        ListCategoryFragment fragment = new ListCategoryFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = CategoryLab.getInstance(getActivity()).getCategories();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_category, container, false);
        recyclerCategory = view.findViewById(R.id.recyclerCategory);
        recyclerCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerCategory.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        categoryAdapter = new CategoryAdapter(getActivity(),categories);
        recyclerCategory.setAdapter(categoryAdapter);

        categoryAdapter.setCallBack(new CategoryAdapter.CallBack() {
            @Override
            public void onClick(View view, int position) {
                callBack.onSelectItem(categories.get(position).getId());
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callBack = null;
    }
}