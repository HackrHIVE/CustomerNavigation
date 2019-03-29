package chirag.rishav.customernavigation;

import android.content.Context;

import java.util.ArrayList;

class Blocks {

    String name;
    StringBuffer overview;

    Blocks(String name,StringBuffer description){
        this.name = name;
        this.overview = description;
    }

    public String getName() {
        return name;
    }

    public StringBuffer getDescription() {
        return overview;
    }
}
public class BlockData{
    ArrayList<String> blockName = new ArrayList<>();
    ArrayList<Blocks> blocksList = new ArrayList<>();
    Context context;
    BlockData(Context context){
        this.context = context;
        blockName.add("Block 1 & 2");
        StringBuffer temp = new StringBuffer();
        temp.append("Block 1 includes major departments and offices of University.");
        temp.append("\nBlock 1 represents Department of Computer Science.");
        temp.append("\nPro-VC Office, Registrar Office,International Relationship Office,E-Governence.");
        temp.append("\nBlock 2 represents HMCT as major department.");
        temp.append("\nHere you find Cafetaria, Restaurents and Dinning halls of Campus.");
        temp.append("\nPro-VC Office, Registrar Office,International Relationship Office,E-Governence.");
        blocksList.add(new Blocks("BLock 1 & 2",temp));
        blockName.add("Block 3 & 3A");
        temp = new StringBuffer();
        temp.append("Block 3A represents University's Department of Student Welfare at ground floor.");
        temp.append("\nHere also include some major offices like University's Account Office, Music and Dance area at level 7th and Academic Department--Civil Engineering.");
        temp.append("\nBlock 3A is the major block for Engineering Departments like B-Design, Mechanical, Petroleum, Chemical and Aerospace Engineering.");
        temp.append("\nAll floors--Engineering departments.");
        temp.append("\nHere you also find major labs of engineering departments.");
        blocksList.add(new Blocks("BLock 3 & 3A",temp));
        blockName.add("Block 4");
        temp = new StringBuffer();
        temp.append("This block represents department of applied sciences as Major departments.");
        temp.append("\nHere you find general Registration Branch Office at ground floor.");
        blocksList.add(new Blocks("Block 4",temp));
        blockName.add("Block 5");
        temp = new StringBuffer();
        temp.append("This block represents departments like CRC department, Department of Law Studies(major department).");
        temp.append("\nHere you find University Auditorium at level sixth.");
//        temp.add("Law Department--all floors");
        blocksList.add(new Blocks("Block 5",temp));
        blockName.add("Block 6");
        temp = new StringBuffer();
        temp.append("This block also represents Department of Applied Sciences.");
        temp.append("\nHere you find University's most important department as DCD( Department of Career Development.");
        temp.append("\nHere you find University's main Food Arena (Food Republic) at gound floor.");
        blocksList.add(new Blocks("Block 7 & 8",temp));
        blockName.add("Block 7 & 8");
        temp = new StringBuffer();
        temp.append("Block 7 represents CPC(Chandigarh Polytechnic College) as major department.");
        temp.append("\nAlso represents Department of Electrical Engineering and Electronics and Communication Department at different floors.");
//        temp.add("All floors are for polytechnic institute");
        temp.append("\nBlock 8 represents departments like Architechture, Media and Filming Department( as major department).");
        blocksList.add(new Blocks("Block 7 & 8",temp));
        temp = new StringBuffer();
        blockName.add("Block 9");
        temp.append("This is the major Administration block of Chandigarh University.");
        temp.append("\nIt includes various important Departments and Offices at ground or first level.");
        temp.append("\nOffices like ERP Department,Chancellor Office, VC Office, Pro VC Office, Director's Office, Examination Cffice, Help-desk International Admission,Counseling Desk with all different Departments.");
        temp.append("\nThis block also represents Department of Biotechnology and Agriculture as (major department) at all floors.");
        blocksList.add(new Blocks("Block 9",temp));
        temp = new StringBuffer();
        blockName.add("South Campus");
        temp.append("South Campus comprises of Block 11 , Block 12 , Block 13 and Block 14.");
        temp.append("\nBlock 11 represents department of MCA and BCA as major departments at all floors.");
        temp.append("\nBlock 12 represents BBA and MBA as major departments of all fields.");
        temp.append("\nIn Block 13 , Chandigarh University has a separate institution for MBA students.");
        temp.append("\nBlock 14 represents Apex Institute for Computer Science Engineering at all floors as major department.");
        blocksList.add(new Blocks("South Campus",temp));

    }
}