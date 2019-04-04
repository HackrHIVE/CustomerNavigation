package chirag.rishav.customernavigation;


import java.util.ArrayList;

public class VideoSelector {

    String blockName;
    ArrayList<String> name;
    ArrayList<String> url;

    VideoSelector(String blockName){
        this.blockName = blockName;
        name = new ArrayList<>();
        url = new ArrayList<>();
        name.add("Block 1 & 2");
        url.add("2_1.mp4");
        name.add("Block 3 & 3A");
        url.add("3A_1.mp4");
        name.add("Block 4");
        url.add("2_1.mp4");
        name.add("Block 5");
        url.add("2_1.mp4");
        name.add("Block 6");
        url.add("2_1.mp4");
        name.add("Block 7 & 8");
        url.add("7_1.mp4");
        name.add("Block 9");
        url.add("2_1.mp4");
        name.add("South Campus");
        url.add("2_1.mp4");

    }

    public String getURL(){
        String urlTemp = url.get(name.indexOf(blockName));
        return urlTemp;
    }

}
