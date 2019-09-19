package activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.exercise.R;
import com.example.exercise.databinding.ActivityListcountryBinding;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import adapter.CountryListAdapter;
import beans.CountryModel;

/**
 * Activity is used to show the different weather conditions and use of event bus
 * Contains of Recycler with DataBinding and EventBus and others android components
 */
public class CountryListActivity extends AppCompatActivity implements CountryListAdapter.OnCountryClick {

    private ArrayList<CountryModel> countryArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListcountryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_listcountry);
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCountries.setAdapter(new CountryListAdapter(fillCountryList(), this));
    }

    /**
     * Fill List with dummy Data's
     */
    private ArrayList<CountryModel> fillCountryList() {
        countryArrayList.add(new CountryModel("China", "39.913818,116.363625"));
        countryArrayList.add(new CountryModel("Switzerland", "46.8182,8.2275"));
        countryArrayList.add(new CountryModel("Dubai", "25.2048,55.2708"));
        countryArrayList.add(new CountryModel("Germany", "51.1657,10.4515"));
        countryArrayList.add(new CountryModel("Australia", "25.2744,133.7751"));
        countryArrayList.add(new CountryModel("Japan", "36.2048,138.2529"));

        return countryArrayList;
    }

    /**
     * Post Sticky EventBus
     *
     * @param position
     */
    @Override
    public void onCountyClick(int position) {
        EventBus.getDefault().postSticky(countryArrayList.get(position));
        finish();
    }
}
