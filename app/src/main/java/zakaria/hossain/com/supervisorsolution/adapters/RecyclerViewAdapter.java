package zakaria.hossain.com.supervisorsolution.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zakaria.hossain.com.supervisorsolution.R;
import zakaria.hossain.com.supervisorsolution.models.User;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<User> userList;
    private Context context;
    private static OnMyItemClickListener onMyItemClickListener;

    public RecyclerViewAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    public interface OnMyItemClickListener {
        void onItemMyClick(int position);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener clickListener) {
        onMyItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(userList.get(position).getName());
        holder.email.setText(userList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, email;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMyItemClickListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            onMyItemClickListener.onItemMyClick(position);
                        }
                    }
                }
            });
        }
    }
}
