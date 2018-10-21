

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Alexandrov Alex on 6/25/18.
 */
public class IllnessesAdapter extends BaseDataAdapter<Illness, IllnessesViewHolder> {

    private List<Illness> mDataList;

    public IllnessesAdapter(List<Illness> list) {
        mDataList = list;
        setData(mDataList);
    }

    @Override
    public IllnessesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_illness, parent, false);
        return new IllnessesViewHolder(view);
    }

    @Override
    public void bindItem(IllnessesViewHolder holder, Illness item) {
        holder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
