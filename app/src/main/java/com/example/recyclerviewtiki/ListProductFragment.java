package com.example.recyclerviewtiki;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewtiki.model.Category;
import com.example.recyclerviewtiki.model.CategoryLab;
import com.example.recyclerviewtiki.model.Product;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListProductFragment extends Fragment {
    RecyclerView recyclerProduct;
    List<Product> products;
    ProductAdapter productAdapter;

    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int categoryId;

    public ListProductFragment() {
        // Required empty public constructor
    }

    public static ListProductFragment newInstance(int param1) {
        ListProductFragment fragment = new ListProductFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        recyclerProduct = view.findViewById(R.id.recyclerProduct);
        recyclerProduct.setLayoutManager(new GridLayoutManager(getActivity(),3));
        Category category = CategoryLab.getInstance(getActivity()).getCategory(categoryId);
        if (category != null) {
            products = category.getProducts();
        }
        productAdapter = new ProductAdapter(getActivity(),products);
        recyclerProduct.setAdapter(productAdapter);
        return view;
    }
}