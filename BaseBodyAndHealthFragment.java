

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Alexandrov Alex on 6/12/18.
 */
public class BaseBodyAndHealthFragment extends BaseFragment {

    @BindView(R.id.include_toolbar)
    Toolbar mIncludeToolbar;

    @BindView(R.id.logo)
    TextView tvTitle;

    @BindView(R.id.txt_save)
    TextView tvSave;

    @BindView(R.id.cancel)
    public ImageView ivBack;

    @BindView(R.id.right_image)
    ImageView ivAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       mIncludeToolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_grey_color));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.toolbar_grey_color));
        }
    }

    protected class UpdateData extends AsyncTask<BodyAndHealth, Void, Void> {

        @Override
        protected Void doInBackground(BodyAndHealth... bodyAndHealths) {
            ExtApplication.getInstance().getAppDb().bodyAndHealthDao().updateItem(bodyAndHealths[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ((BaseActivity) getActivity()).hideKeyboard();
        }
    }
}
