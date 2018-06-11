package com.mationate.stressless.data;

import com.mationate.stressless.models.Pending;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Pending> pendings() {

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class,"done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;
    }
}
