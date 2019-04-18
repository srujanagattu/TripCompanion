/**

package com.example.tripcompanion;
import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

public class GetNearByPlaces {
    private GoogleMap mMap;
    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject parentObject = new JSONObject(s);
            JSONArray resultsArray = parentObject.getJSONArray("results");

            for(int i= 0; i<resultsArray.length();i++){
                JSONObject jsonObject = resultsArray.getJSONObject(i);
                JSONObject locationObj = jsonObject.getJSONObject("geometry").getJSONObject("location");

                String latitude = locationObj.getString("lat");
                String longitude = locationObj.getString("lng");

                JSONObject nameObject = resultsArray.getJSONObject(i);

                String name_restaurent = nameObject.getString("name");
                String vicinity = nameObject.getString("vicinity");

                LatLng latLng = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title(vicinity);
                markerOptions.position(latLng);

                mMap.addMarker(markerOptions);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}

**/