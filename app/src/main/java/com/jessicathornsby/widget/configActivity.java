package com.jessicathornsby.widget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

    public class configActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.configuration_activity);
            setResult(RESULT_CANCELED);
            Button setupWidget = (Button) findViewById(R.id.setupWidget);
            setupWidget.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    handleSetupWidget();
                }
            });

        }

        private void handleSetupWidget() {
            showAppWidget();

        }

        int appWidgetId;

        private void showAppWidget() {

            appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

            //Retrieve the App Widget ID from the Intent that launched the Activity//

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                appWidgetId = extras.getInt(
                        AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID);

                // If the intent doesn’t have a widget ID, then call finish()//

                if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                    finish();
                }

                //TO DO, Perform the configuration and get an instance of the AppWidgetManager//


//Create the return intent//

                Intent resultValue = new Intent();

//Pass the original appWidgetId//

                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

//Set the results from the ‘Configure’ Activity//

                setResult(RESULT_OK, resultValue);

//Finish the Activity//

                finish();
            }

        }
    }


