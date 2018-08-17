package com.example.logarithm.railwake;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONObject;

import static com.example.logarithm.railwake.MainActivity.API_KEY;


public class PnrStatus extends AppCompatActivity {

    JSONDownloader task;
    String json;
    TextView Pnr,dateOfJourney,dateOfJourneyText,chartPreparedText,startingStationName,startingStationCode,startingStationCodeText,startingStationNameText,destStationName,destStationCode,destStationNameText,destStationCodeText;
    String PnrNumber,DOJ,fromStationName,fromStationCode,toStationName,toStationCode,boardingPointName,boardingPointCode,reservationUptoName,reservationUptoCode,trainName,journeyClassName,journeyClassCode;
    int response_code,total_passenger,trainNumber;
    boolean chartPrepared;



    public void GetStatus(View view){
        if(Pnr.length()<1){
            Toast.makeText(this, "Please Enter PNR Number", Toast.LENGTH_SHORT).show();
        }
        else {
            PnrNumber = Pnr.getText().toString();
            try {
               // json = task.execute("\"https://api.railwayapi.com/v2/pnr-status/pnr/" + PnrNumber + "/apikey/" + API_KEY + "/\"").get();
                json="{\n" +
                        "  \"response_code\": 200,\n" +
                        "  \"debit\": 3,\n" +
                        "  \"pnr\": \"1234567890\",\n" +
                        "  \"doj\": \"25-6-2017\",\n" +
                        "  \"total_passengers\": 3,\n" +
                        "  \"chart_prepared\": true,\n" +
                        "  \"from_station\": {\n" +
                        "    \"name\": \"Kopargaon\",\n" +
                        "    \"code\": \"KPG\"\n" +
                        "  },\n" +
                        "  \"to_station\": {\n" +
                        "    \"name\": \"Hazrat Nizamuddin\",\n" +
                        "    \"code\": \"NZM\"\n" +
                        "  },\n" +
                        "  \"boarding_point\": {\n" +
                        "    \"name\": \"Kopargaon\",\n" +
                        "    \"code\": \"KPG\"\n" +
                        "  },\n" +
                        "  \"reservation_upto\": {\n" +
                        "    \"name\": \"Hazrat Nizamuddin\",\n" +
                        "    \"code\": \"NZM\"\n" +
                        "  },\n" +
                        "  \"train\": {\n" +
                        "    \"name\": \"GOA EXPRESS\",\n" +
                        "    \"number\": \"12779\"\n" +
                        "  },\n" +
                        "  \"journey_class\": {\n" +
                        "    \"name\": \"SLEEPER CLASS\",\n" +
                        "    \"code\": \"SL\"\n" +
                        "  },\n" +
                        "  \"passengers\": [\n" +
                        "    {\n" +
                        "      \"no\": 1,\n" +
                        "      \"current_status\": \"RLWL/11\",\n" +
                        "      \"booking_status\": \"RLWL/39/GN\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": 2,\n" +
                        "      \"current_status\": \"RLWL/12\",\n" +
                        "      \"booking_status\": \"RLWL/40/GN\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"no\": 3,\n" +
                        "      \"current_status\": \"RLWL/13\",\n" +
                        "      \"booking_status\": \"RLWL/41/GN\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                Log.i("PNR STATUS ", json);
                JSONObject jsonObject=new JSONObject(json);

                response_code=jsonObject.getInt("response_code");
                if(response_code==200){
                    //Code for Parsing Details
                    chartPreparedText.setVisibility(View.VISIBLE);
                    chartPrepared=jsonObject.getBoolean("chart_prepared");
                    if(chartPrepared){
                    chartPreparedText.setBackgroundColor(Color.parseColor("#0be881"));
                    chartPreparedText.setText("Chart Prepared");
                    }
                    else{
                        chartPreparedText.setBackgroundColor(Color.parseColor("#e74c3c"));
                        chartPreparedText.setText("Chart Not Prepared");
                    }
                    DOJ=jsonObject.getString("doj");
                    JSONObject fromStation=jsonObject.getJSONObject("from_station");
                    JSONObject toStation=jsonObject.getJSONObject("to_station");
                    JSONObject boardingPoint=jsonObject.getJSONObject("boarding_point");
                    JSONObject reservationUpto=jsonObject.getJSONObject("reservation_upto");
                    JSONObject train=jsonObject.getJSONObject("train");
                    JSONObject journeyClass=jsonObject.getJSONObject("journey_class");
                    dateOfJourneyText.setText(DOJ);
                    fromStationName=fromStation.getString("name");
                    fromStationCode=fromStation.getString("code");
                    toStationName=toStation.getString("name");
                    toStationCode=toStation.getString("code");
                    boardingPointName=boardingPoint.getString("name");
                    boardingPointCode=boardingPoint.getString("code");
                    reservationUptoName=reservationUpto.getString("name");
                    reservationUptoCode=reservationUpto.getString("code");
                    trainName=train.getString("name");
                    trainNumber=train.getInt("number");
                    journeyClassName=journeyClass.getString("name");
                    journeyClassCode=journeyClass.getString("code");
                    startingStationName.setText("      Station  Name : ");
                    startingStationCode.setText("      Station Code :");
                    startingStationNameText.setText(fromStationName);
                    startingStationCodeText.setText(fromStationCode);
                    destStationName.setText("      Station  Name : ");
                    destStationCode.setText("      Station Code :");
                    destStationNameText.setText(toStationName);
                    destStationCodeText.setText(toStationCode);






                    dateOfJourney.setVisibility(View.VISIBLE);
                    dateOfJourneyText.setText(DOJ);





                    }
                else if(response_code==221){
                    Toast.makeText(this, "Invalid PNR", Toast.LENGTH_SHORT).show();
                }
                else if(response_code==220){
                    Toast.makeText(this, "Flushed PNR", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Something Went Wrong !", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception   e){
                Toast.makeText(this, "Something Went  Wrong!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr_status);
        Pnr=findViewById(R.id.pnrTextBar);

        task=new JSONDownloader();
        dateOfJourney=findViewById(R.id.dateOfJourney);
        dateOfJourneyText=findViewById(R.id.dateOfJourneyText);
        chartPreparedText=findViewById(R.id.chartPrepared);
        startingStationName=findViewById(R.id.startingStationName);
        startingStationCode=findViewById(R.id.startingStationCode);
        startingStationCodeText=findViewById(R.id.startingStationCodeText);
        startingStationNameText=findViewById(R.id.startingStationNameText);
        destStationName=findViewById(R.id.startingStationName1);
        destStationCode=findViewById(R.id.startingStationCode1);
        destStationCodeText=findViewById(R.id.startingStationCodeText1);
        destStationNameText=findViewById(R.id.startingStationNameText1);







    }
}
