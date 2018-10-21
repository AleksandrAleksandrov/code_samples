

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Alexandrov Alex on 6/26/18.
 */
public class IllnessViewModel extends BaseViewModel<List<Illness>> {

    @Override
    public LiveData<List<Illness>> loadData() {
        return ExtApplication.getInstance().getAppDb().illnessDao().getIllnesses();
    }
}
