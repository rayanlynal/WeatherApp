package adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercise.R;
import com.example.exercise.databinding.AdapterDailyweatherBinding;

import java.util.ArrayList;

import beans.DailyData;
import util.Utils;

public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.DailyHolder> {

    private ArrayList<DailyData> dailyDataArrayList;

    public DailyWeatherAdapter(ArrayList<DailyData> dailyDataArrayList) {
        this.dailyDataArrayList = dailyDataArrayList;
    }

    @NonNull
    @Override
    public DailyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterDailyweatherBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_dailyweather, parent, false);
        return new DailyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyHolder holder, int position) {
        DailyData dailyData = dailyDataArrayList.get(position);
        holder.binding.setDailyData(dailyData);
        holder.binding.tvDay.setText(Utils.getFormatedTime(dailyData.getApparentTemperatureHighTime().toString(), "E"));
        holder.binding.ivWeatherIcon.setImageResource(Utils.getWeatherIcons(dailyData.getIcon()));
    }

    @Override
    public int getItemCount() {
        return dailyDataArrayList.size();
    }

    class DailyHolder extends RecyclerView.ViewHolder {

        AdapterDailyweatherBinding binding;

        DailyHolder(@NonNull AdapterDailyweatherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
