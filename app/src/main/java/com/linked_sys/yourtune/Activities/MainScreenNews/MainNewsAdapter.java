package com.linked_sys.yourtune.Activities.MainScreenNews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linked_sys.yourtune.Model.DataModel.TopHeadline.Article;
import com.linked_sys.yourtune.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainNewsAdapter extends RecyclerView.Adapter<MainNewsAdapter.songsViewHolder> {

    private Context context;
    private ArrayList<Article> articles;

    public MainNewsAdapter(Context context, ArrayList<Article> listofarticles) {
        this.context = context;
        this.articles = listofarticles;

    }

    @NonNull
    @Override
    public songsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_main_news,parent,false);
        return new songsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull songsViewHolder holder, int position) {
        if (articles!= null){
            Article article = articles.get(position);
            holder.articleName.setText(article.getTitle());

            Picasso.get().load(article.getUrlToImage()).into(holder.newsCover);
        }
    }

    @Override
    public int getItemCount() {
        if (articles!= null)
            return articles.size();
        else return 0;

    }

    public class songsViewHolder extends RecyclerView.ViewHolder {

        private ImageView newsCover;
        private TextView articleName;
        private TextView artistName;
        private ImageView playPause;
        private TextView songLength;

        public songsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsCover = itemView.findViewById(R.id.news_cover_default);
            articleName = itemView.findViewById(R.id.article_title);

        }
    }
}
