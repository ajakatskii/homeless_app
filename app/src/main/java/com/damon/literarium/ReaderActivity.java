package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.damon.literarium.data.Registry;
import com.damon.literarium.data.Tuition;
import com.damon.literarium.quiz.HomeScreen;
import com.damon.literarium.utils.Utils;

public class ReaderActivity extends AppCompatActivity {

    private String bookName  = "Physics";

    private TextView lblBookName;

    private TextView txtContent;

    Button btnLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        if(this.getIntent().hasExtra("NAME"))
        {
            this.bookName = this.getIntent().getStringExtra("NAME");
        }
        this.initViews();
    }

    protected void initViews()
    {
        this.lblBookName = this.findViewById(R.id.txtSubjectName);
        txtContent = findViewById(R.id.txtContent);
        this.lblBookName.setText(this.bookName);
        btnLanguage = findViewById(R.id.button4);
        btnLanguage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    toggleLanguage(false);
                } else if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    toggleLanguage(true);
                }
                return true;
            }
        });
    }

    public void btnQuiz_Click(View vw)
    {
        Intent i = new Intent(vw.getContext(), HomeScreen.class);
        i.putExtra("NAME", bookName);
        i.putExtra("MIN", 10);
        i.putExtra("RANGE", "10- 15");
        i.putExtra("Q", 10);
        startActivity(i);
    }

    public void btnHelp_Click(View vw)
    {
        //create a tuition class and publish it
        Tuition tuition = new Tuition(
                bookName,
                3,
                "13/01/2020",
                "Pehalgam",
                10,
                "Ratanda",
                "12 - 56"
        );
        Registry.getInstance().addSuggestion(tuition);
        Utils.showMessage("We are trying to get you a Tuition on this, check the Tuition section");
    }

    private boolean langShifted = false;
    private String oldLang = "";

    public void btnLanguage_Click(View vw)
    {

    }

    public void toggleLanguage(boolean langShifted)
    {
        String telugu = "అయితే ఆనందాన్ని ఖండించడం మరియు బాధను ప్రశంసించడం అనే ఈ తప్పు " +
                "ఆలోచన ఎలా పుట్టిందో నేను మీకు వివరించాలి మరియు నేను మీకు వ్యవస్థ గురించి " +
                "పూర్తి వివరాలు ఇస్తాను మరియు సత్యం యొక్క గొప్ప అన్వేషకుడు, " +
                "ాస్టర్-బిల్డర్ యొక్క వాస్తవ బోధలను వివరిస్తాను. మానవ ఆనందం. " +
                "ఆనందాన్ని ఎవరూ తిరస్కరించరు, ఇష్టపడరు, లేదా తప్పించుకుంటారు, ఎందుకంటే " +
                "ఇది ఆనందం, కానీ ఆనందాన్ని ఎలా కొనసాగించాలో తెలియని వారు చాలా " +
                "బాధాకరమైన పరిణామాలను హేతుబద్ధంగా ఎదుర్కొంటారు. మరలా ప్రేమించే " +
                "లేదా అనుసరించే లేదా కోరుకునే వారు లేరు తనను తాను నొప్పిని పొందండి, " +
                "ఎందుకంటే ఇది నొప్పి, కానీ అప్పుడప్పుడు పరిస్థితులు ఏర్పడటం వలన శ్రమ " +
                "మరియు నొప్పి అతనికి ఎంతో ఆనందాన్ని ఇస్తాయి. ఒక చిన్నవిషయం ఉదాహరణగా" +
                "చెప్పాలంటే, మనలో ఎవరు శ్రమతో కూడిన శారీరక వ్యాయామం చేస్తారు, దాని " +
                "నుండి కొంత ప్రయోజనం పొందడం తప్ప? కానీ బాధించే పరిణామాలు లేని ఆనందాన్ని" +
                " ఆస్వాదించడానికి ఎంచుకున్న వ్యక్తితో లేదా ఫలితాన్నిచ్చే ఆనందాన్ని " +
                "కలిగించని నొప్పిని నివారించే వ్యక్తితో తప్పు కనుగొనే హక్కు ఎవరికి ఉంది?" +
                "పుస్తకము యొక్క ముఖ్య భాగము" + "\n మరోవైపు, నీతిమంతులైన కోపంతో మేము ఖండిస్" +
                "తున్నాము మరియు క్షణం యొక్క ఆనందం యొక్క మనోజ్ఞతను చూసి మోసపోయాము మరియు " +
                "నిరాశకు గురవుతున్న పురుషులను ఇష్టపడము, కోరికతో కళ్ళుపోగొట్టుకుంటాము, వారు బాధను " +
                "మరియు కష్టాలను fore హించలేరు; మరియు సమానమైన నింద సంకల్పం యొక్క బలహీనత " +
                "ద్వారా తమ విధిలో విఫలమయ్యేవారికి చెందినది, ఇది శ్రమ మరియు నొప్పి నుండి " +
                "కుదించడం ద్వారా చెప్పడం లాంటిది. ఈ కేసులు ఖచ్చితంగా సరళమైనవి మరియు వేరు " +
                "చేయడం సులభం. ఉచిత గంటలో, మన ఎంపిక శక్తి అప్రమత్తమైనప్పుడు మరియు మనకు " +
                "బాగా నచ్చినదాన్ని చేయలేకపోతున్నప్పుడు, ప్రతి ఆనందాన్ని స్వాగతించాలి మరియు " +
                "ప్రతి నొప్పిని నివారించాలి. కానీ కొన్ని పరిస్థితులలో మరియు విధి యొక్క వాదనలు " +
                "లేదా వ్యాపారం యొక్క బాధ్యతల కారణంగా ఆనందాలు తిరస్కరించబడాలి మరియు కోపాలను " +
                "అంగీకరించాలి. అందువల్ల వివేకవంతుడు ఈ విషయాలలో ఈ ఎంపిక సూత్రానికి ఎల్లప్పుడూ " +
                "ఉంటాడు: అతను ఇతర గొప్ప ఆనందాలను పొందటానికి ఆనందాలను తిరస్కరిస్తాడు, లేకపోతే " +
                "అధ్వాన్నమైన నొప్పులను నివారించడానికి అతను నొప్పులను భరిస్తాడు";
        if(!langShifted)
        {
            langShifted = true;
            this.oldLang = txtContent.getText().toString();
            this.txtContent.setText(telugu);
        } else {
            this.txtContent.setText(oldLang);
            this.langShifted = false;
        }
    }

}
