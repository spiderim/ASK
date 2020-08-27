package com.example.ask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ask.Article;
import com.example.ask.R;
import com.squareup.picasso.Picasso;

import java.util.List;

@SuppressWarnings("deprecation")
public class MainArticleAdapter extends RecyclerView.Adapter<MainArticleAdapter.MyViewHolder> {
    private List<Article> articleList;
    private Context context;
    //private OnItemClickListener onItemClickListener;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;





    public  MainArticleAdapter(List<Article> articleList,Context context)
    {
        this.articleList=articleList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Article  article=articleList.get(position);

        Picasso.get().load(article.getUrlToImage()).fit().centerInside().into(holder.imageView);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
  /* public void setOnItemClickListener(OnItemClickListener onItemClickListener)
   {
       this.onItemClickListener=onItemClickListener;
   }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,description;
        // OnItemClickListener onItemClickListener;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageview);
            // if(itemView!=null)
            // itemView.setOnClickListener(this);
            // else Toast.makeText(context,"jj",Toast.LENGTH_SHORT).show();

            title=itemView.findViewById(R.id.article_adapter_tv_title);
            description=itemView.findViewById(R.id.article_adapter_tv_description);
            // this.onItemClickListener=onItemClickListener;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context,"kk", Toast.LENGTH_SHORT).show();
                    onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),v);

                }
            });

        }


    }
    public   void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener)
    {
        this.onRecyclerViewItemClickListener=onRecyclerViewItemClickListener;
    }


}