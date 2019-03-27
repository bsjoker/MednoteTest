package bakay.stanislav.mednotetest.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bakay.stanislav.mednotetest.R;
import bakay.stanislav.mednotetest.model.data.FillData;
import bakay.stanislav.mednotetest.model.data.Stock;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public ItemClickListener onClickListener;

    private List<Stock> stockList = new ArrayList<>();
    Context ctx;

    public void setList(List<Stock> stockData, Context context, ItemClickListener clickListener) {
        this.stockList = stockData;
        ctx = context;
        onClickListener = clickListener;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Stock curFillData = stockList.get(i);

        viewHolder.name.setText(curFillData.getName());
        viewHolder.volume.setText(curFillData.getVolume().toString());
        viewHolder.amount.setText(String.format("%.2f", curFillData.getPrice().getAmount()));

        viewHolder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.itemViewOnClick(v, i);
            }
        });
    }

    public interface ItemClickListener {
        void itemViewOnClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView volume;
        private TextView amount;
        private LinearLayout llItem;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            volume = itemView.findViewById(R.id.tvVolume);
            amount = itemView.findViewById(R.id.tvAmount);
            llItem = itemView.findViewById(R.id.llItemRecyclerView);
        }
    }
}