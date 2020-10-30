package com.example.recyclerviewtiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewtiki.model.Category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category> categories;
    private CallBack callBack;
    public interface CallBack{
        void onClick(View view, int position);
    }

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_common,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName  =itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(this);
        }

        public void bind(Category category){
            txtName.setText(category.getName());
        }

        @Override
        public void onClick(View view) {
            callBack.onClick(view,getAdapterPosition());
        }
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
