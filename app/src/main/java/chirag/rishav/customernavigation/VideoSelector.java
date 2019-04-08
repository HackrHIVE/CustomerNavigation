package chirag.rishav.customernavigation;

import java.math.*;
import java.util.ArrayList;
import java.util.Random;

public class VideoSelector {

    ArrayList<String> urls;
//    ArrayList<String> name;
//    ArrayList<String> url;

    VideoSelector(){
        urls = new ArrayList<>();
        this.urls.add("/vid_1.mp4");
        this.urls.add("/vid_3.mp4");
        this.urls.add("/vid_2.mp4");
        this.urls.add("/vid_4.mp4");
//        name = new ArrayList<>();
//        url = new ArrayList<>();
//        name.add("Block 1 & 2");
//        url.add("2_1.mp4");
//        name.add("Block 3 & 3A");
//        url.add("3A_1.mp4");
//        name.add("Block 4");
//        url.add("2_1.mp4");
//        name.add("Block 5");
//        url.add("2_1.mp4");
//        name.add("Block 6");
//        url.add("2_1.mp4");
//        name.add("Block 7 & 8");
//        url.add("7_1.mp4");
//        name.add("Block 9");
//        url.add("2_1.mp4");
//        name.add("South Campus");
//        url.add("2_1.mp4");
    }

    public String getURL(){
        Random random = new Random();
        return this.urls.get(random.nextInt(this.urls.size()));
    }

}
