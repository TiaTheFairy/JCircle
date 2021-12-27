package com.jnu.jcircle.ui.trade;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jnu.jcircle.R;

import java.util.ArrayList;
import java.util.List;

public class TradeFragment extends Fragment {

    public static final int RESULT_CREATE_SUCCESS = 500;
    private List<TradeViewModel> tradeViewModelList;
    private MyRecyclerViewAdapter recyclerViewAdapter;

    private FloatingActionButton button_add;
    private AlertDialog dialog_add;

    ActivityResultLauncher<Intent> createTicketIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result){
            Intent data = result.getData();
            int resultCode = result.getResultCode();
            if(resultCode == RESULT_CREATE_SUCCESS){
                if(null == data) return;
                String ticket_type = data.getStringExtra("type");
                String ticket_location = data.getStringExtra("location");
                String ticket_time = data.getStringExtra("time");
                String ticket_tip = data.getStringExtra("tip");
                int position = data.getIntExtra("position", tradeViewModelList.size());
                tradeViewModelList.add(position, new TradeViewModel(ticket_type, getString(R.string.ticket_state_waiting), ticket_tip, ticket_location, ticket_time, ""));
                recyclerViewAdapter.notifyItemInserted(position);
            }
        }
    });

    public TradeFragment(){

    }

    public static TradeFragment newInstance(){
        TradeFragment fragment = new TradeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_tickets, container, false);

        initData();

        RecyclerView view_tickets = rootView.findViewById(R.id.tickets_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        view_tickets.setLayoutManager(layoutManager);
        recyclerViewAdapter = new MyRecyclerViewAdapter(tradeViewModelList);
        view_tickets.setAdapter(recyclerViewAdapter);

        FloatingActionButton tickets_add = rootView.findViewById(R.id.tickets_newButton);
        tickets_add.setOnClickListener(view ->{
            Intent intent = new Intent(this.getContext(), create_ticket.class);
            intent.putExtra("position", tradeViewModelList.size());
            createTicketIntent.launch(intent);
            Toast.makeText(TradeFragment.this.getContext(), getString(R.string.ticket_new_created), Toast.LENGTH_LONG).show();
        });

        return rootView;
    }

    public void initData(){
        tradeViewModelList = new ArrayList<TradeViewModel>();
        tradeViewModelList.add(new TradeViewModel("Delivery","Awaiting","3.00", getString(R.string.ticket_location_1),"5 mins", ""));
        tradeViewModelList.add(new TradeViewModel("Takeaway","Expired","10.00",getString(R.string.ticket_location_2),"15 mins", ""));
    }

    public void claimTicket(int position){
        tradeViewModelList.remove(position);
        recyclerViewAdapter.notifyItemRemoved(position);
        Toast.makeText(TradeFragment.this.getContext(), getString(R.string.ticket_claim_claim), Toast.LENGTH_LONG).show();
    }



    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
        private List<TradeViewModel> tradeViewModelList;

        public MyRecyclerViewAdapter(List<TradeViewModel> tradeViewModelList){
            this.tradeViewModelList = tradeViewModelList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_ticket, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.getTickets_type().setText(tradeViewModelList.get(position).getTicketType());
            holder.getTickets_location().setText(tradeViewModelList.get(position).getTicketLocation());
            holder.getTickets_duration().setText(tradeViewModelList.get(position).getTicketDuration());
            holder.getTickets_claim().setText(getString(R.string.ticket_claim) + tradeViewModelList.get(position).getTicketIncome() + ")");
        }

        @Override
        public int getItemCount(){
            return tradeViewModelList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView tickets_type;
            private TextView tickets_location;
            private TextView tickets_duration;
            private Button tickets_claim;

            public MyViewHolder(View itemView){
                super(itemView);
                tickets_type = itemView.findViewById(R.id.tickets_type);
                tickets_location = itemView.findViewById(R.id.tickets_location);
                tickets_duration = itemView.findViewById(R.id.tickets_duration);
                tickets_claim = itemView.findViewById(R.id.tickets_claim);

                tickets_claim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alertClaim = new AlertDialog.Builder(TradeFragment.this.getContext());
                        alertClaim.setPositiveButton(getString(R.string.ticket_claim_yes), (dialogInterface, i) -> {
                            TradeFragment.this.claimTicket(getAdapterPosition());
                        });
                        alertClaim.setNegativeButton(getString(R.string.ticket_claim_no), (dialogInterface, i) -> {

                        });
                        alertClaim.setMessage(getString(R.string.ticket_claim_message));
                        alertClaim.setTitle(getString(R.string.ticket_claim_title)).show();
                    }
                });
            }


            public TextView getTickets_type(){
                return tickets_type;
            }

            public TextView getTickets_location(){
                return tickets_location;
            }

            public TextView getTickets_duration(){
                return tickets_duration;
            }

            public Button getTickets_claim() { return tickets_claim; }

        }
    }
}