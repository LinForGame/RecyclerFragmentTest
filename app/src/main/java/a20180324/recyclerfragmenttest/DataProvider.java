package a20180324.recyclerfragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WHY on 2018/3/24.
 */

public class DataProvider {
    private static final String TAG = "---DataProvider";
    private static ArrayList<Map<String,Object>> mList=null;
    DataProvider(){
        if(mList==null)
            mList = new ArrayList<>();
    }

    public ArrayList<Map<String,Object>> getData(){
        return (mList==null)?null:mList;
    }

    public int size(){
        return (mList==null)?0:mList.size();
    }
    public void initDataProvider(int count){
        for(int i=0 ; i< count;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("String","String_"+i);
            map.put("Object","Object_"+i);
            mList.add(map);
        }
    }
    public void clearDataProvider(){
        if(mList!=null) {
            mList.clear();
            mList = null;
        }
    }
}
