package chirag.rishav.customernavigation;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Coordinates{
    LatLng latLngLt,latLngRt,latLngRb,latLngLb;

    public Coordinates(LatLng latLngLt, LatLng latLngRt, LatLng latLngRb, LatLng latLngLb) {
        this.latLngLt = latLngLt;
        this.latLngRt = latLngRt;
        this.latLngRb = latLngRb;
        this.latLngLb = latLngLb;
    }
}

public class IdentifyBlock {
    ArrayList<String> blockName = new ArrayList<String>(13);
    ArrayList<Coordinates> coordinatesList = new ArrayList<Coordinates>();
    Context context;
    IdentifyBlock(Context context){
        this.context = context;
        blockName.add("Block 1 & 2");
        coordinatesList.add(new Coordinates(new LatLng(30.770216, 76.575546),new LatLng(30.770206, 76.576629),new LatLng(30.769030, 76.577030),new LatLng(30.769102, 76.575339)));
        //To be continued...
        blockName.add("Block 3 & 3A");
        coordinatesList.add(new Coordinates(new LatLng(30.768940, 76.573789),new LatLng(30.7686032,76.5750457),new LatLng(30.768391, 76.576391),new LatLng(30.768512, 76.573747)));
        blockName.add("Block 4");
        coordinatesList.add(new Coordinates(new LatLng(30.767799, 76.574325),new LatLng(30.767774, 76.575400),new LatLng(30.766704, 76.575248),new LatLng(30.766640, 76.574543)));
        blockName.add("Block 5");
        coordinatesList.add(new Coordinates(new LatLng(30.766593, 76.575491),new LatLng(30.766535, 76.576363),new LatLng(30.765747, 76.576345),new LatLng(30.765880, 76.575389)));
        blockName.add("Block 6");
        coordinatesList.add(new Coordinates(new LatLng(30.767707, 76.575652),new LatLng(30.767781, 76.576354),new LatLng(30.766556, 76.576339),new LatLng(30.766593, 76.575504)));
        blockName.add("Block 7 & 8");
        coordinatesList.add(new Coordinates(new LatLng(30.770188, 76.577866),new LatLng(30.770178, 76.579562),new LatLng(30.768112, 76.579633),new LatLng(30.768287, 76.577633)));
        blockName.add("Block 9");
        coordinatesList.add(new Coordinates(new LatLng(30.772483, 76.577164),new LatLng(30.772036, 76.579800),new LatLng(30.770874, 76.579268),new LatLng(30.771029, 76.576968)));
        blockName.add("South Campus");
        coordinatesList.add(new Coordinates(new LatLng(30.772524, 76.567997),new LatLng(30.772293, 76.571297),new LatLng(30.768583, 76.571284),new LatLng(30.768786, 76.567488)));
    }

    public String checkLatLng(LatLng current){
        for(Coordinates obj: coordinatesList){
            double lat = current.latitude;
            double lon = current.longitude;
            if(obj.latLngLt.latitude>lat && obj.latLngLb.latitude<lat){
                if(obj.latLngLt.longitude<lon && obj.latLngRt.longitude>lon){
                    int index = coordinatesList.indexOf(obj);
                    String blockN = blockName.get(index);
                    return blockN;
                }
                else
                    if(obj.latLngLb.longitude<lon && obj.latLngRb.latitude>lon){
                        int index = coordinatesList.indexOf(obj);
                        String blockN = blockName.get(index);
                        return blockN;
                    }
            }
            else
                if(obj.latLngRb.latitude<lat && obj.latLngRt.latitude>lat){
                    if(obj.latLngLt.longitude<lon && obj.latLngRt.longitude>lon){
                        int index = coordinatesList.indexOf(obj);
                        String blockN = blockName.get(index);
                        return blockN;
                    }
                    else
                    if(obj.latLngLb.longitude<lon && obj.latLngRb.latitude>lon){
                        int index = coordinatesList.indexOf(obj);
                        String blockN = blockName.get(index);
                        return blockN;
                    }

            }
        }
        Log.i("CusNav:",current.latitude+","+current.longitude);
        return "Chandigarh University";
    }
}
