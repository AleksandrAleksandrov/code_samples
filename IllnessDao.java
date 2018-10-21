

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;


import java.util.List;

/**
 * Created by Alexandrov Alex on 6/26/18.
 */
@Dao
public abstract class IllnessDao extends BaseEntityDao<Illness> {

    @Query("SELECT * FROM illness")
    public abstract LiveData<List<Illness>> getIllnesses();

    @Override
    public Class<Illness> getEntity() {
        return Illness.class;
    }
}
