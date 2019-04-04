package chirag.rishav.customernavigation;


//MainActivity
//public class MainActivity extends AppCompatActivity{
//
////Chirag
//
//
//    private static final String TAG = MainActivity.class.getSimpleName();
//
//    @BindView(R.id.location_result)
//    TextView txtLocationResult;
//
//    @BindView(R.id.updated_on)
//    TextView txtUpdatedOn;
//
//    @BindView(R.id.btn_start_location_updates)
//    Button btnStartUpdates;
//
//    @BindView(R.id.btn_stop_location_updates)
//    Button btnStopUpdates;
//
//    // location last updated time
//    private String mLastUpdateTime;
//
//    // location updates interval - 10sec
//    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
//
//    // fastest updates interval - 5 sec
//    // location updates will be received if another app is requesting the locations
//    // than your app can handle
//    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
//
//    private static final int REQUEST_CHECK_SETTINGS = 100;
//
//
//    // bunch of location related apis
//    private LocationManager locationManager;
//
//    // boolean flag to toggle the ui
//    private Boolean mRequestingLocationUpdates;
//    private Context context;
//New
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            Toast.makeText(this, "Grant Permissions", Toast.LENGTH_SHORT).show();
//            Dexter
//                    .withActivity(this)
//                    .withPermissions(Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
//                    .withListener(new PermissionListener() {
//                        @Override
//                        public void onPermissionGranted(PermissionGrantedResponse response) {
//                            Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onPermissionDenied(PermissionDeniedResponse response) {
//                            if (response.isPermanentlyDenied()) {
//                                // open device settings when the permission is
//                                // denied permanently
//                                openSettings();
//                                Toast.makeText(MainActivity.this, "Please grant permission to Application", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
//                            token.continuePermissionRequest();
//                        }
//                    }).check();
//            openSettings();
//            return;
//        }
//    }
//
//
//    @Override
//    public void onLocationChanged(Location location) {
//
//        double lat = location.getLatitude();
//        double lon = location.getLongitude();
//        LatLng latLng = new LatLng(lat,lon);
//        IdentifyBlock identifyBlock = new IdentifyBlock(this);
//        String naem = identifyBlock.checkLatLng(latLng);
//        Toast.makeText(this, lat+" , "+lon, Toast.LENGTH_SHORT).show();
//        txtLocationResult.setText(naem);
//
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
//Fused
//
////
////Rishav
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//
//
//        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            Dexter.withActivity(this)
//                    .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//                    .withListener(new PermissionListener() {
//                        @Override
//                        public void onPermissionGranted(PermissionGrantedResponse response) {
//                            Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                            getLocation();
//                        }
//
//                        @Override
//                        public void onPermissionDenied(PermissionDeniedResponse response) {
//                            if (response.isPermanentlyDenied()) {
//                                // open device settings when the permission is
//                                // denied permanently
//                                openSettings();
//                                Toast.makeText(MainActivity.this, "Please grant permission to Application", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
//                            token.continuePermissionRequest();
//                        }
//                    }).check();
//
//            return;
//        }
//        else{
//            getLocation();
//        }
//
//
////     initialize the necessary libraries
//        init();
//
////         restore the values from saved instance state
//        restoreValuesFromBundle(savedInstanceState);
//    }
//
//    private void init() {
//
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//        mSettingsClient = LocationServices.getSettingsClient(this);
//
//        mLocationCallback = new LocationCallback() {
//            @Override
//            public void onLocationResult(LocationResult locationResult) {
//                super.onLocationResult(locationResult);
//                // location is received
//                mCurrentLocation = locationResult.getLastLocation();
//                mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
//
//                updateLocationUI();
//            }
//        };
//
//        mRequestingLocationUpdates = false;
//
//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
//        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
//        builder.addLocationRequest(mLocationRequest);
//        mLocationSettingsRequest = builder.build();
//    }
//
//    /**
//     * Restoring values from saved instance state
//     */
//    private void restoreValuesFromBundle(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
//            if (savedInstanceState.containsKey("is_requesting_updates")) {
//                mRequestingLocationUpdates = savedInstanceState.getBoolean("is_requesting_updates");
//            }
//
//            if (savedInstanceState.containsKey("last_known_location")) {
//                mCurrentLocation = savedInstanceState.getParcelable("last_known_location");
//            }
//
//            if (savedInstanceState.containsKey("last_updated_on")) {
//                mLastUpdateTime = savedInstanceState.getString("last_updated_on");
//            }
//        }
//
//        updateLocationUI();
//    }
//
//
//    /**
//     * Update the UI displaying the location data
//     * and toggling the buttons
//     */
//    private void updateLocationUI() {
//        if (mCurrentLocation != null) {
//
//            Log.i("CusNav:","Called UpdateLocationUI()");
//            LatLng current = new LatLng(mCurrentLocation.getLatitude(),mCurrentLocation.getLongitude());
//            IdentifyBlock identifyBlock = new IdentifyBlock(this);
//            String data = identifyBlock.checkLatLng(current);
//            txtLocationResult.setText(data);
//
//            Log.i("CusNav:",data);
//            // giving a blink animation on TextView
//            txtLocationResult.setAlpha(0);
//            txtLocationResult.animate().alpha(1).setDuration(300);
//
//            // location last updated time
//            txtUpdatedOn.setText("Last updated on: " + mLastUpdateTime);
//        }
//
//        toggleButtons();
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putBoolean("is_requesting_updates", mRequestingLocationUpdates);
//        outState.putParcelable("last_known_location", mCurrentLocation);
//        outState.putString("last_updated_on", mLastUpdateTime);
//
//    }
//
//    private void toggleButtons() {
//        if (mRequestingLocationUpdates) {
//            btnStartUpdates.setEnabled(false);
//            btnStopUpdates.setEnabled(true);
//        } else {
//            btnStartUpdates.setEnabled(true);
//            btnStopUpdates.setEnabled(false);
//        }
//    }
//
//    /**
//     * Starting location updates
//     * Check whether location settings are satisfied and then
//     * location updates will be requested
//     */
//    private void startLocationUpdates() {
//        mSettingsClient
//                .checkLocationSettings(mLocationSettingsRequest)
//                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
//                    @SuppressLint("MissingPermission")
//                    @Override
//                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
//                        Log.i(TAG, "All location settings are satisfied.");
//
//                        Toast.makeText(getApplicationContext(), "Started location updates!", Toast.LENGTH_SHORT).show();
//
//                        //noinspection MissingPermission
//                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
//                                mLocationCallback, Looper.myLooper());
//
//                        updateLocationUI();
//                    }
//                })
//                .addOnFailureListener(this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        int statusCode = ((ApiException) e).getStatusCode();
//                        switch (statusCode) {
//                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                                Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " +
//                                        "location settings ");
//                                try {
//                                    // Show the dialog by calling startResolutionForResult(), and check the
//                                    // result in onActivityResult().
//                                    ResolvableApiException rae = (ResolvableApiException) e;
//                                    rae.startResolutionForResult(MainActivity.this, REQUEST_CHECK_SETTINGS);
//                                } catch (IntentSender.SendIntentException sie) {
//                                    Log.i(TAG, "PendingIntent unable to execute request.");
//                                }
//                                break;
//                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                                String errorMessage = "Location settings are inadequate, and cannot be " +
//                                        "fixed here. Fix in Settings.";
//                                Log.e(TAG, errorMessage);
//
//                                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
//                        }
//
//                        updateLocationUI();
//                    }
//                });
//    }
//
//    @OnClick(R.id.btn_start_location_updates)
//    public void startLocationButtonClick() {
//        // Requesting ACCESS_FINE_LOCATION using Dexter library
//        Dexter.withActivity(this)
//                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse response) {
//                        mRequestingLocationUpdates = true;
//                        startLocationUpdates();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse response) {
//                        if (response.isPermanentlyDenied()) {
//                            // open device settings when the permission is
//                            // denied permanently
//                            openSettings();
//                        }
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).check();
//    }
//
//    @OnClick(R.id.btn_stop_location_updates)
//    public void stopLocationButtonClick() {
//        mRequestingLocationUpdates = false;
//        stopLocationUpdates();
//    }
//
//    public void stopLocationUpdates() {
//        // Removing location updates
//        mFusedLocationClient
//                .removeLocationUpdates(mLocationCallback)
//                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(getApplicationContext(), "Location updates stopped!", Toast.LENGTH_SHORT).show();
//                        toggleButtons();
//                    }
//                });
//    }
//
//    @OnClick(R.id.btn_get_last_location)
//    public void showLastKnownLocation() {
//        if (mCurrentLocation != null) {
//            Toast.makeText(getApplicationContext(), "Lat: " + mCurrentLocation.getLatitude()
//                    + ", Lng: " + mCurrentLocation.getLongitude(), Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "Last known location is not available!", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            // Check for the integer request code originally supplied to startResolutionForResult().
//            case REQUEST_CHECK_SETTINGS:
//                switch (resultCode) {
//                    case Activity.RESULT_OK:
//                        Log.e(TAG, "User agreed to make required location settings changes.");
//                        // Nothing to do. startLocationupdates() gets called in onResume again.
//                        break;
//                    case Activity.RESULT_CANCELED:
//                        Log.e(TAG, "User chose not to make required location settings changes.");
//                        mRequestingLocationUpdates = false;
//                        break;
//                }
//                break;
//        }
//    }
//
//    private void openSettings() {
//        Intent intent = new Intent();
//        intent.setAction(
//                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//        Uri uri = Uri.fromParts("package",
//                BuildConfig.APPLICATION_ID, null);
//        intent.setData(uri);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }
//
//
////
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        // Resuming location updates depending on button state and
//        // allowed permissions
//        if (mRequestingLocationUpdates && checkPermissions()) {
//            startLocationUpdates();
//        }
//
//        updateLocationUI();
//    }
//
//    private boolean checkPermissions() {
//        int permissionState = ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION);
//        return permissionState == PackageManager.PERMISSION_GRANTED;
//    }
//
//
//
//}

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.net.URI;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    // location last updated time
    private String mLastUpdateTime;

    // location updates interval - 10sec
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    // fastest updates interval - 5 sec
    // location updates will be received if another app is requesting the locations
    // than your app can handle
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;

    private static final int REQUEST_CHECK_SETTINGS = 100;


    // bunch of location related apis
    private TextView outputBlock;
    private FusedLocationProviderClient mFusedLocationClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;
    // boolean flag to toggle the ui
    private Boolean mRequestingLocationUpdates;
    private BlockData blockData;
    TextToSpeech t1;
    private boolean completed;
    private String lastLocation = "Chandigarh University";
    VideoView mediaVideo;
    CardView container;
    MediaController mediaPlayer;
    Thread videoThread;
    String videoURL;

    Bundle saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saved = savedInstanceState;
        blockData = new BlockData(this);
        outputBlock = findViewById(R.id.updated_on);
        mediaVideo = findViewById(R.id.mediaVideo);
        container = findViewById(R.id.containerLocation);
        // initialize the necessary libraries
        init();
        mediaPlayer = new MediaController(this);
        mediaPlayer.setAnchorView(mediaVideo);
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        mRequestingLocationUpdates = true;
                        startLocationUpdates();
                        init1();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        openSettings();
                        token.continuePermissionRequest();
                    }
                }).check();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
            t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.ENGLISH);
                        t1.setSpeechRate(1f);
                    }
                }
            });
        }
    }

    public void init1(){

        Uri uri = Uri.parse(Environment.getExternalStorageDirectory()+"/vid.mp4");
//        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"/vid.mp4");
        mediaVideo.setMediaController(mediaPlayer);
        mediaVideo.setVideoURI(uri);
        mediaVideo.requestFocus();
        mediaVideo.start();

        // restore the values from saved instance state
        restoreValuesFromBundle(saved);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        mRequestingLocationUpdates = true;
                        startLocationUpdates();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        openSettings();
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    public void SpeakOutLoud(StringBuffer tospeak)
    {
        mediaVideo.pause();
        t1.speak(tospeak.toString(),TextToSpeech.QUEUE_ADD,null);
        container.setVisibility(View.VISIBLE);
        videoThread.stop();
        t1.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {

            }

            @Override
            public void onDone(String utteranceId) {
                t1.stop();
                mediaVideo.resume();
                container.setVisibility(View.INVISIBLE);
                videoThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Uri uri = Uri.parse(Environment.getExternalStorageDirectory()+videoURL);
                        mediaVideo.setMediaController(mediaPlayer);
                        mediaVideo.setVideoURI(uri);
                        mediaVideo.requestFocus();
                        mediaVideo.start();
                    }
                });
                videoThread.start();
            }

            @Override
            public void onError(String utteranceId) {

            }
        });

    }


    private void init() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mSettingsClient = LocationServices.getSettingsClient(this);

        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                // location is received
                mCurrentLocation = locationResult.getLastLocation();
                mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());

                updateLocationUI();
            }
        };

        mRequestingLocationUpdates = false;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        mLocationSettingsRequest = builder.build();
    }

    /**
     * Restoring values from saved instance state
     */
    private void restoreValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("is_requesting_updates")) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean("is_requesting_updates");
            }

            if (savedInstanceState.containsKey("last_known_location")) {
                mCurrentLocation = savedInstanceState.getParcelable("last_known_location");
            }

            if (savedInstanceState.containsKey("last_updated_on")) {
                mLastUpdateTime = savedInstanceState.getString("last_updated_on");
            }
        }

        updateLocationUI();
    }

    /**
     * Update the UI displaying the location data
     * and toggling the buttons
     */
    private void updateLocationUI() {
        if (mCurrentLocation != null) {
            LatLng current = new LatLng(mCurrentLocation.getLatitude(),mCurrentLocation.getLongitude());
            IdentifyBlock identifyBlock = new IdentifyBlock(this);
            String data = identifyBlock.checkLatLng(current);
            outputBlock.setText(data);

            ArrayList<String> block_name = blockData.blockName;
            ArrayList<Blocks> blocks_list = blockData.blocksList;

            if("Chandigarh University".equals(data)){
                Log.i("LatLngOutOfCollegeError",mCurrentLocation.getLatitude()+mCurrentLocation.getLongitude()+"");
            }
            else {
                if(lastLocation.equals(data)){

                }
                else{
                    int index = block_name.indexOf(data);
                    Log.i("INDEX:", String.valueOf(index));
                    Log.i("DATA:", String.valueOf(data));
                    Blocks blocks = blocks_list.get(index);
                    StringBuffer content = blocks.overview;
                    VideoSelector videoSelector = new VideoSelector(data);
                    videoURL = videoSelector.getURL();
                    SpeakOutLoud(content);
                    lastLocation = data;
                }
            }
            Log.i("LatLng : ",mCurrentLocation.getLatitude()+mCurrentLocation.getLongitude()+"");
            Log.i("CusNav:",data);
            // giving a blink animation on TextView
//            outputBlock.setAlpha(0);
//            outputBlock.animate().alpha(1).setDuration(300);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("is_requesting_updates", mRequestingLocationUpdates);
        outState.putParcelable("last_known_location", mCurrentLocation);
        outState.putString("last_updated_on", mLastUpdateTime);
    }

    /**
     * Starting location updates
     * Check whether location settings are satisfied and then
     * location updates will be requested
     */
    private void startLocationUpdates() {
        mSettingsClient
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        Log.i(TAG, "All location settings are satisfied.");

                        Toast.makeText(getApplicationContext(), "Started location updates!", Toast.LENGTH_SHORT).show();

                        //noinspection MissingPermission
                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                                mLocationCallback, Looper.myLooper());

                        updateLocationUI();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " +
                                        "location settings ");
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(MainActivity.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                        }

                        updateLocationUI();
                    }
                });
    }


    public void showLastKnownLocation() {
        if (mCurrentLocation != null) {
            Toast.makeText(getApplicationContext(), "Lat: " + mCurrentLocation.getLatitude()
                    + ", Lng: " + mCurrentLocation.getLongitude(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Last known location is not available!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.e(TAG, "User agreed to make required location settings changes.");
                        // Nothing to do. startLocationupdates() gets called in onResume again.
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.e(TAG, "User chose not to make required location settings changes.");
                        mRequestingLocationUpdates = false;
                        break;
                }
                break;
        }
    }

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Resuming location updates depending on button state and
        // allowed permissions
        if (mRequestingLocationUpdates && checkPermissions()) {
            startLocationUpdates();
        }

        updateLocationUI();
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

}