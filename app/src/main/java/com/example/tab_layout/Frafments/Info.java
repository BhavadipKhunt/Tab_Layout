package com.example.tab_layout.Frafments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tab_layout.R;

import java.io.IOException;
import java.io.InputStream;


public class Info extends Fragment {

    int pos;
    String image;
    ImageView imageView;
    TextView textView,textView1;
    String Hotalname[]={"Amiras","Annapurana","K's Charcoal","Gulmohar","Maha Laxmi","Level 5","Royal","3 Story","Sukhdev","Table 101"};
    String Owner_name[]={"Shailesh Makwana","Utsav Raiyani","Vrajesh Dobariya","Yagnesh Gundaliya","Hardik Malani","Pradip Virani","Sagar Makwana","Bhavadip Khunt","K.K.Gohil","Chintan Vasoya"};
    String Mobile_No[]={"+91 9885678960","+91 6988562356","+91 7121452648","+91 8690451232","+91 7753642131","+91 9998998789","+91 9000512456","+91 7816596632","+91 7658912347","+91 9898523469"};
    String Email[]={"hotelamiras12@gmail.com","annapurana2312@gmail.com","Kscharcoal32@gmail.com","gulmoharhotel@gmail.com","mahalaxmi11@gmail.com","level5@gmail.com","royalhotel@gmail.com","3storyhotel@gmail.com","sukdevbar11@gmail.com","tabel101@gmail.com"};
    String Addres[]={"Galaxy Point, Surat - Kamrej Hwy," +"\n"+
            " Bhagavan Nagar, Sarthana Jakat Naka," +"\n"+
            " Sarthi Society, Nana Varachha," +"\n"+
            " Surat, Gujarat 395006",
            "Shop No 139, 140, Goldan Square," +"\n"+
                    " Maharaja Pam Road, Mota Varachha," +"\n"+
                    " Surat - 394101 (Near D Mart)",
            "Upper Ground Floor," +"\n"+
            " Ganga House, Near Iscon Mall," +"\n"+
            " Piplod, Surat",
            "Palm Zumera, Lajpore, " +"\n"+
                    "Surat Navsari Main Road, " +"\n"+
                    "Lajpor, Surat - 394235",
            "Shop No.I-5, Muktanand Nagar," +"\n"+
                    " Adajan Road, " +"\n"+
                    "Surat - 395009 ",
            "515, Fifth Floor, " +"\n"+
                    "Royal Trade Centre, " +"\n"+
                    "Opposite Star Bazaar," +"\n"+
                    " Adajan Gam, Surat",
            "Opp Dhiraj Sons, " +"\n"+
                    "Next To Pawan Hospital, " +"\n"+
                    "Near Someshwara Square, " +"\n"+
                    "Vesu, Surat 395007 ",
            "G-17, Titanium Business Hub," +"\n"+
                    " Bhimrad Road, Oppo Akash Enclave," +"\n"+
                    " Althan Bhatar, Surat",
            "6, Shak Market, " +"\n"+
            "Sarthana Jakat Naka," +"\n"+
            " Swaminarayan Nagar-1," +"\n"+
            " Nana Varachha, " +"\n"+
            "Surat, Gujarat 395006",
            "Ambika Niketan Road, " +"\n"+
                    " Umra Gam, " +"\n"+
                    " Surat, Gujarat 395007"};
    public Info(int position, String image) {
        this.pos=position;
        this.image=image;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_info, container, false);
        imageView = view.findViewById(R.id.info_image);
        InputStream stream=null;
        try {
            stream=getContext().getAssets().open("image/"+image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);
        textView=view.findViewById(R.id.Info_text);
        textView1=view.findViewById(R.id.Addres_text);
        textView.setText("Hotal Name : "+ Hotalname[pos]+"\n\n"
                +"Owner Name : " + Owner_name[pos]+"\n\n"+"Contact : "+ Mobile_No[pos]+"\n\t"+Email[pos]);
        textView1.setText("Addres:"+Addres[pos]);

        return view;
    }
}