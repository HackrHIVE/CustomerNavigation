//package chirag.rishav.customernavigation;
//
//import android.app.Activity;
//import android.os.Build;
//import android.os.Bundle;
//import android.speech.tts.TextToSpeech;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.Locale;
//
//public class tts extends Activity {
//    TextToSpeech t1;
//    TextView ed1;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //ed1=(TextView)findViewById(R.id.editText);
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
//            t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                @Override
//                public void onInit(int status) {
//                    if(status != TextToSpeech.ERROR) {
//
//
//                        t1.setLanguage(Locale.ENGLISH);
//                        t1.setSpeechRate(1f);
//                        speaktome("");
//
//                    }
//                }
//
//            });
//        }
////        //b1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            //public void onClick(View v) {
////
//////                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//////                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000, 5, this);
////                String toSpeak = ed1.getText().toString();
////                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
////                t1.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
////            }
////        });
//
//  }
//  public void speaktome(String tospeak)
//  {
//      t1.speak(tospeak,TextToSpeech.QUEUE_ADD,null);
//  }
//
//    public void onPause(){
//        if(t1 !=null){
//            t1.stop();
//            t1.shutdown();
//        }
//        super.onPause();
//    }
//}
//
//
