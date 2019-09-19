package adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercise.R;
import com.example.exercise.databinding.AdapterCountrylistBinding;

import java.util.ArrayList;

import beans.CountryModel;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryHolder> {

    private ArrayList<CountryModel> countryModelArrayList;
    private OnCountryClick onCountryClick;

    public interface OnCountryClick {
        void onCountyClick(int position);
    }

    public CountryListAdapter(ArrayList<CountryModel> countryModelArrayList, OnCountryClick onCountryClick) {
        this.countryModelArrayList = countryModelArrayList;
        this.onCountryClick = onCountryClick;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterCountrylistBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_countrylist, parent, false);
        return new CountryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        CountryModel countryModel = countryModelArrayList.get(position);
        holder.binding.setCountryModel(countryModel);
        holder.binding.setIndex(position);
        holder.binding.setListener(onCountryClick);
    }

    @Override
    public int getItemCount() {
        return countryModelArrayList.size();
    }

    class CountryHolder extends RecyclerView.ViewHolder {

        AdapterCountrylistBinding binding;

        CountryHolder(@NonNull AdapterCountrylistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
