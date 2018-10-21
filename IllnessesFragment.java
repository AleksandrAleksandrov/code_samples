

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Alexandrov Alex on 6/21/18.
 */
public class IllnessesFragment extends BaseBodyAndHealthFragment {

    public static final String TAG = "IllnessesFragment";

    private IllnessViewModel mIllnessViewModel;

    private View mView;

    @BindView(R.id.tv_illnesses)
    TextView tvIllnesses;

    @BindView(R.id.tv_doctors)
    TextView tvDoctors;

    @BindView(R.id.rv_illness)
    RecyclerView rvIllness;

    @BindView(R.id.tv_no_data)
    TextView tvNoData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIllnessViewModel = ViewModelProviders.of(this).get(IllnessViewModel.class);

        Observer<List<Illness>> observer = illnesses -> {
            tvNoData.setVisibility(illnesses == null || illnesses.size() == 0 ? VISIBLE : GONE);
            tvIllnesses.setVisibility(illnesses == null || illnesses.size() == 0 ? GONE : VISIBLE);
            tvDoctors.setVisibility(illnesses == null || illnesses.size() == 0 ? GONE : VISIBLE);

            Log.d(TAG, "" + illnesses.size());
            rvIllness.setLayoutManager(new LinearLayoutManager(getContext()));
            IllnessesAdapter adapter = new IllnessesAdapter(illnesses);
            rvIllness.setAdapter(adapter);
        };
        mIllnessViewModel.loadData().observe(this, observer);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) mView = inflater.inflate(R.layout.fragment_body_health_illnesses, container, false);
        ButterKnife.bind(this, mView);

        ivBack.setImageDrawable(backButtonDrawable);
        ivBack.setOnClickListener(v -> onBackPressed());

        tvTitle.setText(getText(R.string.illness));
        return mView;
    }
}
