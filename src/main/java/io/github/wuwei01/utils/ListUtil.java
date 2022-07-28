package io.github.wuwei01.utils;

import java.util.Collections;
import java.util.List;

public class ListUtil {

    public Boolean removeAllNull(List<?> list){
        return list.removeAll(Collections.singleton(null));
    }
}
