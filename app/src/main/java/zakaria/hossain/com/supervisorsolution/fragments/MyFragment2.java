package zakaria.hossain.com.supervisorsolution.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import zakaria.hossain.com.supervisorsolution.R;
import zakaria.hossain.com.supervisorsolution.adapters.RecyclerViewAdapter;
import zakaria.hossain.com.supervisorsolution.models.User;

public class MyFragment2 extends Fragment implements RecyclerViewAdapter.OnMyItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private Context context;
    private List<User> userList;
    private Dialog dialog;
    private SwipeRefreshLayout swipeRefreshLayout;

    public MyFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_fragment2, container, false);

        context = container.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(userList, context);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnMyItemClickListener(MyFragment2.this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.item_dialog_popup);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userList = new ArrayList<>();
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain2", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain3", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain4", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
        userList.add(new User("Zakaria Hossain", "zakaria@gmail.com"));
    }

    @Override
    public void onItemMyClick(int position) {
        TextView tvNameDialog = dialog.findViewById(R.id.tvNameDialog);
        TextView tvEmailDialog = dialog.findViewById(R.id.tvEmailDialog);
        Button btnPhoneCall = dialog.findViewById(R.id.btnPhoneCall);

        tvNameDialog.setText(userList.get(position).getName());
        tvEmailDialog.setText(userList.get(position).getEmail());

        dialog.show();

        btnPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                AlertDialogPopUp();
            }
        });
    }

    private void AlertDialogPopUp() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure to make a call?");
        builder.setIcon(R.drawable.ic_call);

        builder.setPositiveButton("Call Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "calling...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        Toast.makeText(getContext(), "Dummy refresh for 5 second", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
