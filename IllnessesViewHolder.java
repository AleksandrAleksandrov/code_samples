

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alexandrov Alex on 6/25/18.
 */
public class IllnessesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_doctor_name)
    TextView tvDoctorName;

    public IllnessesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(Illness illness) {
        tvName.setText(illness.getIllness());
        tvDoctorName.setText(illness.getDoctorName());
    }
}
