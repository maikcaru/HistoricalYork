package com.maikcaru.historicalyork;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by michael.carr on 24/02/15.
 */
public class Sites {

    private ArrayList<Site> list;
    private LinkedHashMap<Marker, Site> markers;

    //Constructor method for sites which pulls in the information from the XML file
    public Sites(Context context) {
        list = new ArrayList<Site>();
        markers = new LinkedHashMap<Marker, Site>();

        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = context.getAssets().open("sites.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Parses the XML file to pull the information about each site
    private void parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        list = null;
        int eventType = parser.getEventType();
        Site currentSite = null;
        double temp_lat = 0;
        double temp_lng = 0;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tag = null;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if (tag.equals("site")) {
                        currentSite = new Site();
                    } else if (currentSite != null) {
                        if (tag.equals("name")) {
                            currentSite.setName(parser.nextText());
                        } else if (tag.equals("lat")) {
                            temp_lat = Double.valueOf(parser.nextText());
                        } else if (tag.equals("lng")) {
                            temp_lng = Double.valueOf(parser.nextText());
                            currentSite.setLatLng(new LatLng(temp_lat, temp_lng));
                        } else if (tag.equals("info")) {
                            currentSite.setInfo(parser.nextText());
                        } else if (tag.equals("image")){
                            currentSite.setImageLocation(parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    tag = parser.getName();
                    if (tag.equalsIgnoreCase("site") && currentSite != null) {
                        list.add(currentSite);
                    }
            }
            eventType = parser.next();
        }

    }

    //Correlates the marker with a site
    void setMarkerForSite(Marker m, Site s) {
        markers.put(m, s);
    }

    //Returns the list of all the sites
    ArrayList<Site> getAllSites() {
        return list;
    }

    //Returns a particular site when given the marker
    Site getSite(Marker marker) {
        return markers.get(marker);
    }

    //Return the index of a particular site
    int getIndex(Marker marker){
        return list.indexOf(getSite(marker));
    }

    //Returns the existing the Site object if
    public static Sites get(Context context) {
        if (sites == null) {
            sites = new Sites(context);
        }
        return sites;
    }

    private static Sites sites;
}
