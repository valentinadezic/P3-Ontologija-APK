package ffos.p3.ontologijap3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<Ontologija> rezultat;

    public AdapterListe(Context context) {
        this.mInflater = LayoutInflater.from(context);
        rezultat = new ArrayList<>();
    }

    @Override
    public Red onCreateViewHolder(ViewGroup roditelj, int viewType) {
        View view = mInflater.inflate(R.layout.red_liste, roditelj, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(Red red, int position) {
        Ontologija o = rezultat.get(position);
        red.tip.setText(o.getType());
        red.opis.setText(o.getProperties());
    }

    @Override
    public int getItemCount() {
        return rezultat==null ? 0 : rezultat.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tip;
        private TextView opis;
        Red(View itemView) {
            super(itemView);
            tip = itemView.findViewById(R.id.tip);
            opis = itemView.findViewById(R.id.opis);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Ontologija getItem(int id) {
        return rezultat.get(id);
    }

    public void setPodaci(List<Ontologija> itemList) {
        this.rezultat = itemList;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
