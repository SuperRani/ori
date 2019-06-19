//package com.example.livealoneproject;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//import noman.googleplaces.NRPlaces;
//import noman.googleplaces.Place;
//import noman.googleplaces.PlaceType;
//import noman.googleplaces.PlacesException;
//import noman.googleplaces.PlacesListener;
//
//public class EstateMap1 extends AppCompatActivity implements OnMapReadyCallback, LocationListener, PlacesListener {
//
//
//    public EditText estateSearchText;
//    public Button estateSearchButton;
//
//    public GoogleMap map;
//    public LatLng currentPosition;
//    public List<Marker> prevMarkers;
//    public double lat;
//    public double log;
//    public LocationListener locationListener;
//    public MapFragment mapFragment;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_estate_map);
//
//
//
//
//
//        //마커 목록
//        prevMarkers = new ArrayList<>();
//
//        //프레그 먼트 객체 연결
//        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
//
//        //프레그먼트에서 맵을 리턴받음
//        // GoogleMap map = fragment.getMap();
//
//        //비동기적인 방식으로 구글맵을 생성
//        mapFragment.getMapAsync((this));    //지도요청
//
//
//        estateSearchButton = (Button) findViewById(R.id.estateSearchButton);
//        estateSearchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                search();
////                prepareMap();
////                drawMap();
//                showPlaceInformation(currentPosition);
//            }
//        });
//
//    }
//
//    public void drawMap() {
//
//        //지도를 바라보는 카메라 이동
//        map.moveCamera(CameraUpdateFactory.newLatLng(currentPosition));
//
//        //카메라 이동의 애니메이션 효과
//        //줌레벨 : 1~21 숫자가 클수록 자세한 지도
//        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, 15));
//
//        //맵에 마커 표시
//        MarkerOptions marker = new MarkerOptions();
//        marker.position(currentPosition);  //마커를 표시할 좌표
//        marker.title("현재 위치");    //마커의 제목
////        marker.snippet("설명인듯~"); //마커의 설명
//        map.addMarker(marker);  //지도에 마커 추가
//
//
//    }
//
//    public void showPlaceInformation(LatLng location) {
//        map.clear(); //지도 지우기
//        if (prevMarkers != null) {
//            prevMarkers.clear(); //지역정보 마커 클리어
//        }
//
//
//        //구글 정보 검색 API 요청
//        // 장소 검색 API Key 를 입력해야함
//
//        new NRPlaces.Builder()
//                .listener(this) //장소검색 리스너를 구현한 객체
//                .key("AIzaSyAcPvtrvxB84hjewUpf-O9FGmKHNevJD-k")    //key값
//                .latlng(lat, log)
//                .radius(1000)   // 1000m 이내 검색
////                 .type(PlaceType.RESTAURANT)     //식당 말고도 여러개 지원!!
//                .type(PlaceType.REAL_ESTATE_AGENCY)    //공인중개사
//                .build()
//                .execute();
//        //서버에서 결과가 도착하면 onPlacesSuccess() 가 호출됨
//    }
//
//
//
//
//    public void prepareMap() {
//        int check = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
//        if (check != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//        } else{
//            //지도 종류
//            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//            map.setMyLocationEnabled(true); //현재 위치 버튼
//            map.getUiSettings().setZoomControlsEnabled(true);   //줌컨트롤 표시 여부(1~21)
//
//            //위치 정보 관리자 객체
//            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//            //리스너 등록
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0 , this);
//
//            //수동으로 위치 구하기
//            String locationProvider = LocationManager.GPS_PROVIDER;
//            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
//
//            //최근 gps 좌표 저장
//            if (lastKnownLocation != null){
//                lat = lastKnownLocation.getLatitude();
//                log = lastKnownLocation.getLongitude();
//                currentPosition = new LatLng(lat, log);
//                Log.i("test", "currentPosition" + currentPosition);
//            }else{
//                lat = 37.5887407;
//                log = 127.0372883;
//            }
//
//
//
//
//        }
//    }
//
//
//
//
//
////    public void search(){
////        String place = estateSearchText.getText().toString();
////        Geocoder coder = new Geocoder(this);     //Geocoder = text를 좌표로 뽑아내거나 거꾸로
////        List<Address> list = null;
////        try{
////            list = coder.getFromLocationName(place, 1);
////        }catch (IOException e){
////            e.printStackTrace();
////        }
////        Address addr = list.get(0);
////         lat = addr.getLatitude();    //위도
////         log = addr.getLongitude();    //경도
//
//
////        LatLng geoPoint = new LatLng(lat, log);
////        map.animateCamera(CameraUpdateFactory.newLatLngZoom(geoPoint, 15));
////
////        //맵에 마커 표시
////        MarkerOptions marker = new MarkerOptions();
////        marker.position(geoPoint);  //마커를 표시할 좌표
////        marker.title(estateSearchText.getText().toString());    //마커의 제목
////        marker.snippet("조선왕조의 법궁"); //마커의 설명
////        map.addMarker(marker);  //지도에 마커 추가
////
////    }
//
//    //맵이 로딩되면
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        this.map = googleMap;
//        prepareMap();
//        drawMap();
//
//    }
//
//    //위치 정보 리스너 등록
//    @Override
//    public void onLocationChanged(Location location) {
//        lat = location.getLatitude();   //변경된 위도
//        log = location.getLongitude();  //변경된 경도
//
//        //새로운 현재 좌표
//        currentPosition = new LatLng(lat, log);
//
//        //지도출력
//        drawMap();
//    }
//
//
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
//
//    @Override
//    public void onPlacesFailure(PlacesException e) {
//
//
//    }
//
//    @Override
//    public void onPlacesStart() {
//
//    }
//
//
//
//
//
//    //서버에서 장소 검색 결과가 도착할 떄 호출
//    @Override
//    public void onPlacesSuccess(final List<Place> places) {
//        //메인화면을 수정해야 하므로 runOnUiThread()에서 처리
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //서버에서 조회된 장소들을 마커 리스트에 등록
//                for (Place place : places){
//                    LatLng latLng = new LatLng(place.getLatitude(), place.getLongitude());
//
//                    //맵에 마커 표시
//                    MarkerOptions markerOptions = new MarkerOptions();
//                    markerOptions.position(latLng);  //마커를 표시할 좌표
//                    markerOptions.title(place.getName());    //마커의 제목
//                    markerOptions.snippet(place.getVicinity()); //마커의 설명
//                    Marker item = map.addMarker(markerOptions);
//                    prevMarkers.add(item);  //지도에 마커 추가
//                }
//
//
//                //중복된 값들을 제어하기 위한 HashSet 사용
//                HashSet<Marker> hashSet = new HashSet<Marker>();
//                hashSet.addAll(prevMarkers);
//                prevMarkers.clear();    //마커 리스트 클리어
//                prevMarkers.addAll(hashSet);
//            }
//        });
//
//    }
//
//    @Override
//    public void onPlacesFinished() {
//
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        switch (requestCode){
//            case 1:
//                if((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                    prepareMap();
//                    drawMap();
//                }
//                break;
//            default:
//                break;
//
//        }
//    }
//
//
//
//}
